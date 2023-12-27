-- GROUPING, GROUP BY

-- 카테고리가 있는 메뉴들을 카테고리로 묶음
SELECT
		 category_code
  FROM tbl_menu
 WHERE category_code IS NOT NULL -- 행 마다의 조건 
 GROUP BY category_code;
 
SELECT
		 category_code
	  , menu_name -- 이렇게 하면 해당 카테고리의 메뉴 하나의 이름만 나옴 -> 오류 코드
  FROM tbl_menu
 WHERE category_code IS NOT NULL
 GROUP BY category_code; 

-- 그룹을 묶은 컬럼 제외하고, 그룹 함수만 가능
-- COUNT, SUM, AVG
SELECT
		 category_code
	  , COUNT(*) -- 카테고리에 해당하는 메뉴의 수
	  , SUM(menu_price) -- 카테고리에 해당하는 메뉴의 가격 합
	  , AVG(menu_price) -- 카테고리에 해당하는 메뉴의 가격 평균
  FROM tbl_menu
 WHERE category_code IS NOT NULL -- 행 마다의 조건 
 GROUP BY category_code
 ORDER BY 2; -- count수로 오름차순 정렬 

-- COUNT(*) : 모든 행 갯수 세기
-- COUNT(menu_price) : null이 아닌 행만 갯수 세기
-- 메뉴가 없는 카테고리까지 셀건지 구분해서 count 해보기
SELECT
		 COUNT(*)
	  , COUNT(a.menu_name)
  FROM tbl_menu a
 RIGHT JOIN tbl_category b ON (a.category_code = b.category_code);
  

-- HAVING : 그룹의 조건
-- 행 마다의 조건(where)인지, 그룹 마다의 조건(HAVING)인지 잘 파악하기

-- 조회의 6가지 절을 모두 활용한 예제
-- select : group by 절에서 group을 묶는 조건으로 활용한 컬럼만 조회 또는 그룹 함수를 통해 조회
-- from : 테이블 또는 join을 활용한 result set 작성
-- where : from절의 각 행마다 적용될 조건을 작성
-- group by : where절까지 만족하는 행들에 대해 그룹이 될 컬럼을 작성한다.
-- having : 그룹 별로 적용할 조건을 group by에서 작성한 컬럼 또는 그룹 함수를 통해 조회
-- order by : 제일 마지막에 해석되며, select의 결과(result set)의 순번, 별칭, 컬럼명 등으로 정렬

SELECT
		 category_code
	  , COUNT(*)
	  , SUM(menu_price)
	  , AVG(menu_price)
  FROM tbl_menu
 WHERE category_code IS NOT NULL -- 행 마다의 조건 
 GROUP BY category_code
HAVING SUM(menu_price) >= 24000 -- 그룹의 조건
 ORDER BY 2; -- count수로 오름차순 정렬 


-- ---------------------------------------------------------------
-- 함수의 종류
-- 단일행 함수 : NVL 또는 ISNULL과 같이 단일 행마다 적용되어 행의 갯수만큼 결과가 나오는 경우
-- 그룹 함수 : COUNT, SUM, AVG와 같이 그룹마다 적용되어 그룹의 갯수만큼 결과가 나오는 경우
--				  (단, GROUP BY절이 없는 조회는 그룹 함수의 결과가 단일행(행 하나))


SELECT
       menu_price
     , category_code
     , COUNT(*)
  FROM tbl_menu
 GROUP BY menu_price, category_code; -- 가격과 카테고리가 똑같은 메뉴는 같은 그룹
 
-- ----------------------------------------------------------
-- ROLLUP
-- 중간 합계 및 최종 합계를 도출
-- gruop by에서  두 개 이상의 컬럼으로 그룹 형성 시

SELECT
		 menu_price
	  , category_code
	  , SUM(menu_price)
  FROM tbl_menu
 GROUP BY menu_price, category_code
  WITH ROLLUP;
  
  
-- --------------------------------------------------
-- CREATE TABLE sales(
--     CODE INT AUTO_INCREMENT,
--     year VARCHAR(4),
--     month VARCHAR(2),
--     product VARCHAR(50),
--     amount DECIMAL(10, 2),
--     PRIMARY KEY(code)
-- );
-- 
-- INSERT
--   INTO sales
-- (
--   CODE
-- , YEAR
-- , MONTH
-- , product
-- , amount
-- )
-- VALUES
-- (
--   NULL
-- , '2023'
-- , LPAD('1', 2, '0')
-- , 'Product A'
-- , 1000.00
-- ),
-- (
--   NULL, '2023', LPAD('1', 2, '0')
-- , 'Product B', 1500.00
-- ),
-- (
--   NULL, '2023', LPAD('2', 2, '0')
-- , 'Product A', 2000.00
-- ),
-- (
--   NULL, '2023', LPAD('2', 2, '0')
-- , 'Product B', 2500.00
-- ),
-- (
--   NULL, '2023', LPAD('3', 2, '0')
-- , 'Product A', 1200.00
-- ),
-- (
--   NULL, '2023', LPAD('3', 2, '0')
-- , 'Product B', 1700.00
-- );

-- 연도별, 월별, 상품별 합계
-- 연, 월, 상품명을 모두 하나의 그룹으로 묶어
-- 연, 월, 중간 합계 및 전체 합계를 ROLLUP으로 구하기
SELECT
		 year
	  , month
	  , product
	  , SUM(amount) AS total_sales
  FROM sales
 GROUP BY YEAR, MONTH, product
  WITH ROLLUP;
 