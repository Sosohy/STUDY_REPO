-- DISTINCT

SELECT
		 DISTINCT category_code
--   , menu_name -- 일반 컬럼과 함께 사용할 수 없음. distinct가 무의미 해지기 때문
					  -- 둘 중 하나 택하거나 에러, select 도는게 다름 -> grouping 개념 
  FROM tbl_menu;

-- null값을 포함한 컬럼의 DISTINCT
SELECT
       DISTINCT ref_category_code
  FROM tbl_category;

-- 기본 정렬의 개념은 syntax error 발생
-- 순번이나 별칭을 사용해야 가능

-- 에러 발생 코드
-- SELECT
-- 		 DISTINCT ref_category_code
--   FROM tbl_category
--  ORDER BY DISTINCT ref_category_code DESC;

-- 1. 순번 사용 정렬 - null 값을 나중으로 보내는 정렬
SELECT
		 DISTINCT ref_category_code
  FROM tbl_category
 ORDER BY 1 DESC; -- -1은 안됨

-- 2. 별칭 사용 정렬 - null값 나중으로 보내고 나머지는 오름차순
SELECT
		 DISTINCT ref_category_code AS 'dcode'
  FROM tbl_category
 ORDER BY -dcode DESC;

SELECT
		 SUM(menu_price) AS 'sum'
  FROM tbl_menu
 GROUP BY category_code
 ORDER BY menu_price;
 
-- -------------------------------------

-- 컬럼 두 개 이상도 DISTINCT로 묶을 수는 있지만 좋은 형태는 아니다.
-- 컬럼 두개 이상 부터는 group by 통해 중복 제거
SELECT
		 DISTINCT category_code, orderable_status
  FROM tbl_menu;
