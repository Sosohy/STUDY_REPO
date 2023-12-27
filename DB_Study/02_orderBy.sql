--  오름차순
SELECT
       menu_code
     , menu_name
     , menu_price
  FROM tbl_menu
 -- ORDER BY menu_price ASC;	-- ASC는 오름차순
 ORDER BY menu_price;
 
-- 내림차순
SELECT
		 menu_code
	  , menu_name
	  , menu_price
  FROM tbl_menu
 ORDER BY menu_price DESC;  -- 내림차순

-- 컬럼의 순번을 활용한 정렬
SELECT
		 menu_price
	  , menu_name
  FROM tbl_menu
 ORDER BY 1 ASC;  -- 가격 따라서
 
-- 별칭을 활용한 정렬
SELECT
		 menu_price AS 'mp'
	  , menu_name AS 'mn' 
  FROM tbl_menu
 ORDER BY mp DESC;
 -- 별칭으로 정렬할 때는 별칭명에 ' 붙이면 안됨. 

 -- 컬럼의 복수개로 정렬
SELECT
		 menu_price
	  , menu_name
  FROM tbl_menu
 ORDER BY 1 DESC, 2 ASC;
 -- 가격으로 내림차순 후, 같은 가격일 시 '메뉴 이름'을 오름차순 조회
 
 
 -- ------------------------------------------------
 --  field
 SELECT FIELD ('a', 'b', 'z', 'a'); -- 1번 이후 값부터 0번째 값 위치 찾기 (=3)
 
 -- table에서 조회 시 field 활용
SELECT
		 FIELD(orderable_status, 'N', 'Y')
	  , orderable_status
	  , menu_name
	  , menu_code
  FROM tbl_menu;

-- field 활용한 order by
SELECT
		 menu_name
	  , orderable_status
  FROM tbl_menu
 ORDER BY FIELD(orderable_status, 'N', 'Y') DESC;
 
-- --------------------------------
-- null 값에 대한 정렬
-- 1) 오름차순 시
SELECT
		 *
  FROM tbl_category
 ORDER BY ref_category_code ASC; -- null값이 먼저 오는게 기본

-- 2) 내림차순 시
SELECT
		 *
  FROM tbl_category
 ORDER BY ref_category_code DESC; -- null값이 뒤에 나옴

-- 3) 오름차순, null값 나중에
SELECT
		 *
  FROM tbl_category
 ORDER BY -ref_category_code DESC; -- DESC 통해 null을 나중에 보냄 -> -로 null이 아닌 값을 ASC로 바꿈

-- 4) 내림차순, null값 먼저
SELECT
		 *
  FROM tbl_category
 ORDER BY -ref_category_code ASC; -- ASC 통해 null을 먼저 보냄 -> -로 null이 아닌 값을 DESC로 바꿈

