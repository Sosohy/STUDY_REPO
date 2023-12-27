-- DML
-- DESC tbl_menu;

-- INSERT
INSERT
  INTO tbl_menu
(
  menu_code
, menu_name
, menu_price
, category_code
, orderable_status
)
VALUES
(
  NULL
, '바나나해장국'
, 8500
, 4
, 'Y'  
);

SELECT * FROM tbl_menu ORDER BY 1 DESC;

INSERT 
  INTO tbl_menu
(
  menu_name, menu_price -- menu_name은 설정이 not null이라서 값 빼면 안됨
, category_code, orderable_status
)
VALUES 
(
  '초콜릿죽', 6500
, 7, 'Y'
);

-- --------------------------------------------
-- DELETE
DELETE
  FROM tbl_menu
 WHERE menu_code = 23; -- 23번 초콜릿죽 삭제 -- auto increment는 24부터 시작

-- LIMIT을 활용해서 삭제도 가능
DELETE FROM tbl_menu
ORDER BY menu_price
LIMIT 2;

-- 전체 행 삭제
DELETE FROM tbl_menu; -- WHERE 1 = 1; (경고문구를 안 띄우고 싶다면)

-- --------------------------------------------
-- update : 행은 그대로인데 내용만 변경
UPDATE tbl_menu
	SET menu_name = '딸기해장국'
 WHERE menu_code = 22;

-- --------------------------------------------
-- replace
REPLACE
	INTO tbl_menu
(
  menu_code
, menu_name
, menu_price
, category_code
, orderable_status
)	
VALUES
(
  17
, '참기름소주'
, 5000
, 10
, 'Y'
);

-- UPDATE 시 WHERE 구문 없이 UPDATE가 가능
REPLACE tbl_menu
    SET menu_code = 2
      , menu_name = '우럭쥬스'
      , menu_price = 2000
      , category_code = 9
      , orderable_status = 'N';