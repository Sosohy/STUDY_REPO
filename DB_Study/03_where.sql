-- orderable_status = 'N'인 행을 조회 -> 주문 불가능한 메뉴 조회
SELECT
 		 menu_name
 	  , menu_code
 	  , orderable_status
  FROM tbl_menu
 WHERE orderable_status = 'N';

-- DESC를 통한 컬럼명 빠르게 확인
DESC tbl_menu;

-- ------------------------------------
-- '기타' 카테고리에 해당하지 않는 메뉴 조회하기
-- 1) 기타 카테고리의 번호 파악하기
SELECT * FROM tbl_category WHERE category_name = '기타';
-- 카테고리 code == 10

-- 2) 해당 번호를 가지지 않는 메뉴 조회
SELECT
		 *
  FROM tbl_menu
 WHERE category_code != 10;
-- WHERE category_code <> 10;과 동일함
 
-- ------------------------------------
-- 10,000원 이상 메뉴 조회
SELECT
		 *
  FROM tbl_menu
 WHERE menu_price >= 10000;
 
-- 10,000원 미만 메뉴 조회
SELECT
		 *
  FROM tbl_menu
 WHERE menu_price < 10000;
 
-- 10,000원 이상 12,000원 이하 메뉴 조회
SELECT
		 *
  FROM tbl_menu
 WHERE 10000 <= menu_price
   AND menu_price <= 12000;
 
-- 논리 연산자(참과 거짓의 연산)

-- AND, 둘 다 만족, 이면서, 그리고, 동시에
-- ex.롤러코스터는 7세 이상, 100cm 이상만 가능하다.

SELECT
		 menu_code
	  , menu_name
	  , menu_price
	  , category_code
	  , orderable_status
  FROM tbl_menu
 WHERE menu_price > 5000 -- 5000원 이상이면서, 카테고리 코드도 10
 	AND category_code = 10;

-- OR, 둘 중에 아무거나(둘 다 FALSE만 아니면 TRUE), 이거나, 또는
-- ex.내 친구는 콜라도 좋아하고 사이다도 좋아한다. -> (콜라 또는 사이다)

SELECT
		 menu_code
	  , menu_name
	  , menu_price
	  , category_code
	  , orderable_status
  FROM tbl_menu
 WHERE menu_price > 5000 -- 5000원 이상 또는 카테고리 코드가 10
 	 OR category_code = 10;
 	 
-- ---------------------------------------
-- BETWEEN 연산자 -> 이상/이하만 가능(초과,미만 불가능)
-- 가격이 5000원 이상 9000원 이하 메뉴 전체 조회
SELECT
		 menu_code
	  , menu_name
	  , menu_price
	  , category_code
	  , orderable_status
  FROM tbl_menu
 WHERE menu_price BETWEEN 5000 AND 9000;

-- 반대의 범위 테스트
SELECT
		 *
  FROM tbl_menu
 WHERE 5000 > menu_price
    OR menu_price > 9000;

SELECT
		 *
  FROM tbl_menu
 WHERE menu_price NOT BETWEEN 5000 AND 9000; -- NOT의 위치 컬럼명 앞 뒤 모두 가능
 
-- ----------------------------------
-- 메뉴 중에 '밥'이 들어간 메뉴 조회
SELECT
		 *
  FROM tbl_menu
 WHERE menu_name LIKE '%밥%';

-- 메뉴명에 '밥'이 안 들어간 메뉴 조회
SELECT
		 *
  FROM tbl_menu
 WHERE NOT menu_name LIKE '%밥%';
 
-- -----------------------------------
-- IN 연산자

-- 카테고리가 중식, 커피, 기타인 카테고리 메뉴 조회
-- 1. 카테고리 코드 조회
SELECT
		 *
  FROM tbl_category
 WHERE category_name IN ('커피', '중식', '기타');

-- 2. 원하는 카테고리 코드에 해당하는 메뉴 조회
SELECT
		 *
  FROM tbl_menu
 WHERE category_code IN (5, 8, 10);
 
-- -----------------------------------
-- is null 연산자 활용

-- 상위 카테고리 번호(ref_category_code)가 없는 카테고리 조회
SELECT
		 *
  FROM tbl_category
 WHERE ref_category_code IS NULL;

-- 상위 카테고리가 null이 아닌 카테고리 조회
SELECT
		 *
  FROM tbl_category
 WHERE ref_category_code IS NOT NULL;

SELECT
		 *
  FROM tbl_category
 WHERE NOT ref_category_code IS NULL;