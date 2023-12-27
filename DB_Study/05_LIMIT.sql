-- LIMIT

SELECT
		 *
  FROM tbl_menu
 LIMIT 0, 5; -- 0-4(0(1), 1(2), 2(3), 3(4), 4(5) - 5개) 인덱스(메뉴 코드)
 -- 시작 인덱스, 시작 인덱스부터 조회할 행의 갯수

SELECT
		 *
  FROM tbl_menu
 LIMIT 5, 5; -- 5-9(5개) 

-- offset 생략 시 -> 전체 불러오기
SELECT
		 *
  FROM tbl_menu;

-- 시작 인덱스 생략
SELECT
		 *
  FROM tbl_menu
 LIMIT 5; -- LIMIT 0, 5와 동일
 
-- LIMIT을 자주 쓰진 않지만, TOP-N 분석이나 paging 처리를 할 때 사용됨.