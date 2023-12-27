SELECT
	  menu_name 
 	, category_name
FROM tbl_menu

DESC tbl_category;

SELECT
	   category_code
	 , category_name
FROM tbl_category;

-- 특수기호가 들어간 별칭은 ''반드시 필요
-- ex. SELECT 3+7 합 입니다., 3*10 AS '곱 입니다';
SELECT 3+7 AS “합”, 3*10 AS “곱”;
SELECT 3+7 plus, 3*10 AS "곱";

-- %(mod) 나머지 연산자 가능
SELECT NOW() AS '현재 시간'; -- 현재 시간
SELECT CONCAT('한', ' ', '소혜');
