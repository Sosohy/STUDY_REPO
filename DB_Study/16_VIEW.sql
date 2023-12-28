-- VIEW

SELECT 
       menu_name
     , menu_price
  FROM tbl_menu;

-- view 생성
CREATE or REPLACE VIEW v_menu 
-- or replace : 테이블이 있을 경우 대체
AS
SELECT 
       menu_name '메뉴이름'
     , menu_price '메뉴가격'
  FROM tbl_menu;
  
SELECT * FROM v_menu;

-- VIEW는 원본 테이블을 참조해서 보여주는 용도 -> 뷰를 통해 업데이트 안하는 게 좋음
-- -> 실제 보여지는 건 원본 테이블의 데이터

-- 베이스 테이블이 변경되면 view의 결과도 함께 바뀜
UPDATE tbl_menu
   SET menu_price = 10
 WHERE menu_code = 11;

-- 뷰 생성 시 별칭으로 생성했으면 뷰를 통한 조회는 별칭으로만 가능
SELECT 메뉴이름, 메뉴가격 FROM v_menu; 

-- VIEW 삭제
DROP VIEW hansik;

-- ---------------------------------------------
-- VIEW를 통한 DML (But, VIEW를 통해 작업하지 말기)

SELECT * FROM tbl_menu;

-- VIEW 생성
CREATE VIEW hansik AS
SELECT 
       menu_code 
     , menu_name
     , menu_price
     , category_code
     , orderable_status
  FROM tbl_menu 
 WHERE category_code = 4;

-- 생성된 VIEW 조회
SELECT * FROM hansik;

-- VIEW를 통한 INSERT
-- INSERT INTO hansik VALUES (null, '식혜맛국밥', 5500, 4, 'Y');    -- 에러 발생
INSERT 
  INTO hansik
VALUES (99, '수정과맛국밥', 5500, 5, 'Y');   
SELECT * FROM hansik;
SELECT * FROM tbl_menu;

-- VIEW를 통한 UPDATE
UPDATE hansik
   SET menu_name = '버터맛국밥', menu_price = 5700 
 WHERE menu_code = 99;
SELECT * FROM hansik;
SELECT * FROM tbl_menu;

-- VIEW를 통한 DELETE
DELETE FROM hansik WHERE menu_code = 99;
SELECT * FROM hansik;
SELECT * FROM tbl_menu;
