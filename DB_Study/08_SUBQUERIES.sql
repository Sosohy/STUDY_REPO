-- SUBQUERIES

-- 유재식씨의 부서와 같은 부서에서 일하는 직원
SELECT
		 *
  FROM employee;

SELECT -- 서브 쿼리
		 dept_code
  FROM employee
 WHERE emp_name = '유재식'; -- 유재식 부서 코드

-- 유재식 부서와 같은 부서의 직원
SELECT -- 메인 쿼리
		 *
  FROM employee
 WHERE dept_code = 'D6'; -- 이전에 얻은 부서 코드


-- 서브 쿼리를 포함한 메인 쿼리
SELECT 
		 *
  FROM employee
 WHERE dept_code = (SELECT dept_code
 							 FROM employee
							WHERE emp_name = '유재식');

-- 이와 같은 방법으로 유재식 사원 번호 추출해서 해당 사원은 제거
SELECT
		 *
  FROM employee
 WHERE dept_code = (SELECT dept_code
 							 FROM employee
							WHERE emp_name = '유재식')
	AND emp_id <> (SELECT emp_id
						  FROM employee
						 WHERE emp_name = '유재식');

-- --------------------------------------------------
-- 상관 서브 쿼리
-- 메뉴 조회 시, 메뉴의 카테고리에 있는 메뉴들의 평균 가격보다 높은 가격의 메뉴만 조회 
-- 단일행 서브쿼리
SELECT
		 menu_code
	  , menu_name
	  , menu_price
	  , category_code
	  , orderable_status
  FROM tbl_menu a
 WHERE a.menu_price > (SELECT AVG(b.menu_price) -- 현재 카테고리에 있는 메뉴 가격 평균
 								 FROM tbl_menu b
								WHERE b.category_code = a.category_code);

-- 메뉴 카테고리의 평균과 같은 가격의 메뉴 조회
-- 상관 서브쿼리 안쓰고, 다중행 서브쿼리
SELECT
		 *
  FROM tbl_menu a
 WHERE a.menu_price IN (SELECT AVG(b.menu_price)
 								 FROM tbl_menu b
								GROUP BY b.category_code);

-- ------------------------------------
-- 메뉴가 있는 카테고리 조회
SELECT
		 category_code
	  , category_name
  FROM tbl_category a
 WHERE EXISTS(SELECT 1 -- EXISTS : 조회 되는지 안되는지 -> 하나라도 나오면 true
                FROM tbl_menu b
                WHERE b.category_code = a.category_code)
 ORDER BY 1;
 -- 카테고리 중에 -> 메뉴가 하나라도 있는 카테고리면 -> 참 -> 출력O

-- 4번 카테고리를 메인 쿼리에서 where 조건 판별 중 동작하는 서브쿼리
-- -> 하나라도 나오면 true
-- 카테고리를 가진 메뉴의 카테고리만 조회
SELECT 1
  FROM tbl_menu b
 WHERE b.category_code = 4;

-- -------------------------------------
-- join을 활용한, 메뉴가 있는 카테고리 조회
SELECT
		 a.category_code
	  , a.category_name
  FROM tbl_category a
  JOIN tbl_menu b ON (a.category_code = b.category_code)
  GROUP BY a.category_code, a.category_name;
-- 메뉴-카테고리 연결해서 존재하는 카테고리 그룹 별로 묶기


-- 가장 높은 급여를 받는 사원 조회
SELECT  -- 서브쿼리
		 MAX(salary)
	FROM employee;
	
SELECT
		 *
  FROM employee
  WHERE salary = (SELECT MAX(salary)
  						  FROM employee);

-- 평균 급여가 가장 높은 부서 조회
SELECT AVG(salary)
  FROM employee
 GROUP BY dept_code;
 
SELECT MAX(a.sal_avg) -- 부서별 평균 중에 가장 높은 급여 
  FROM (SELECT AVG(salary) AS sal_avg -- 부서별 평균
  			 FROM employee
			GROUP BY dept_code) a;

SELECT dept_code
  FROM employee
 GROUP BY dept_code
HAVING AVG(salary) = (SELECT MAX(a.sal_avg) -- 부서별 평균 중에 가장 높은 급여 
  								FROM (SELECT AVG(salary) AS sal_avg -- 부서별 평균
  			 							  FROM employee
										 GROUP BY dept_code) a);
-- ALL 활용 방법
-- 서브쿼리 중에 다중행 서브쿼리인 경우에는 비교 연산자가 일반 비교연산자와 달라진다.
-- > ALL, < ALL, > ANY, < ANY, IN
-- 1. > ALL : 모든 서브쿼리 결과보다 크다. (서브쿼리 최대값보다 크다.)
-- 2. < ALL : 모든 서브쿼리 결과보다 작다. (서브쿼리 최소값보다 작다.)
-- 3. > ANY : 서브쿼리 결과보다 최소 하나보다는 크다. (서브쿼리의 최소값보다 크다.)
-- 4. < ANY : 서브쿼리 결과보다 최대 하나보다는 작다. (서브쿼리의 최대값보다 작다.)
-- 5. IN : 서브쿼리 결과 중에 하나라도 일치한다.
 
SELECT
		 dept_code
	  , AVG(salary)
  FROM employee
 GROUP BY dept_code
 HAVING AVG(salary) >= ALL(SELECT AVG(salary)
 									  FROM employee
									 GROUP BY dept_code);

-- CTE
-- 인라인 뷰로 쓰인 서브쿼리를 미리 정의하고 메인쿼리가 심플해질 수 있도록 사용하는 문법
