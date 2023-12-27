-- JOIN

SELECT
		 *
  FROM tbl_menu JOIN tbl_category ON tbl_menu.category_code = tbl_category.category_code;


-- --------------------------------
SELECT
		 *
  FROM tbl_menu;

SELECT
		 *
  FROM tbl_category;

-- 메뉴명과 카테고리명 조회
SELECT
		 menu_name
	  , category_name
  FROM tbl_menu
  JOIN tbl_category ON (tbl_menu.category_code = tbl_category.category_code);
  
-- 테이블명도 별칭(alias)을 붙일 수 있다.
SELECT
		 menu_name
	  , category_name
  FROM tbl_menu AS m
  JOIN tbl_category AS c ON (m.category_code = c.category_code);

-- **두 테이블에 같은 컬럼명이 있을 경우, 주의할 점**
SELECT
		 menu_name
	  , category_name
  FROM tbl_menu AS m
  JOIN tbl_category AS c ON (m.category_code = c.category_code); -- 두 테이블이 동일한 컬럼명일 시 별칭 필수/컬럼명이 다른 경우 별칭을 안 붙여도 돌아감.
  -- 두 테이블의 컬럼명이 같은 경우, 별칭 없으면 ambiguous 에러남 

SELECT
		 menu_name
	  , category_name
	  , m.category_code -- 같은 컬럼이 존재하므로 별칭 필수
  FROM tbl_menu AS m
  JOIN tbl_category AS c ON (m.category_code = c.category_code);

-- 관례상 join시에는 쿼리에 사용되는 모든 컬럼에 별칭을 다는 것을 원칙으로 한다.
SELECT
		 a.menu_name
	  , b.category_name
  FROM tbl_menu AS a -- 우선순위에 따라 a,b,c 순으로 하는게 좋다.
  JOIN tbl_category AS b ON (a.category_code = b.category_code)
 WHERE b.category_code = 8;

-- -----------------------------------
-- 1) inner join : on 또는 using 뒤에 오는 join 조건을 만족하여 매칭되는 결과물만 join 됨
SELECT
  FROM tbl_menu a
  JOIN tbl_category b ON (a.category_code = b.category_code)
 WHERE b.category_code = 7; -- 조회 결과가 없음 (카테고리 코드가 7인 메뉴가 없으므로 join결과에 존재X)

-- 2) left join : join 키워드 기준 왼쪽 테이블의 행이 모두 나오도록 join
-- ALTER TABLE tbl_menu MODIFY category_code NULL;
UPDATE tbl_menu
   SET category_code = NULL
 WHERE menu_code = 1;
  
-- 3) right join : join 키워드 기준 오른쪽 테이블의 행이 모두 나오도록 join
SELECT
		*
  FROM tbl_menu a
  RIGHT JOIN tbl_category b ON (a.category_code = b.category_code);
  
-- 4) cross join
-- cross join은 의도했다기 보다는 on에 쓰는 join 조건을 잘못 썼을 가능성이 높다.
SELECT
		 *
  FROM tbl_menu a
  JOIN tbl_category b ON (1=1); -- 모든 경우의 수를 곱한 게 조회(하나하나 매칭해서?)
  -- 테이블의 모든 가능한 조합

SELECT
		 *
  FROM tbl_menu a
 CROSS JOIN tbl_category b;

-- 5) self join
-- self join은 하나의 테이블에 상위 개념과 하위 개념이 모두 들어있을 때
-- 자기 자신 테이블을 join하게 되는 경우에 사용
-- ex. 신입사원 - 사수(선배 사원), 하위 카테고리 - 상위 카테고리, 댓글 - 대댓글 등

SELECT
		 *
  FROM tbl_category;

SELECT
		 a.category_name
	  , b.category_name
  FROM tbl_category a
  JOIN tbl_category b ON (a.ref_category_code = b.category_code); -- a가 참조하는 b의 카테고리 코드(a.ref가 b인 것)
