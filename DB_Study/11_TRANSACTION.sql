-- TRANSACTION

-- autocommit 비활성화
-- SET autocommit = 0; -- (== OFF)

-- TRANSACTION 활용
START TRANSACTION; -- 작업 시작
-- 실행할 작업
ROLLBACK; -- 실행한 작업 취소
COMMIT; -- 작업 완료
-- COMMIT 후에는 ROLLBACK이 동작하지 않음

START TRANSACTION; -- 안 넣으면 명령어 단위로 ROLLBACK
-- ex) insert 1번, update 2번 할 경우 -> update 2번만 취소 

INSERT
  INTO tbl_menu
VALUES
(
  NULL, '바나나해장국', 8500
, 4, 'Y'
);

UPDATE tbl_menu
   SET menu_name = '수정된 메뉴1'
 WHERE menu_code = 5;
 
UPDATE tbl_menu
   SET menu_name = '수정된 메뉴2'
 WHERE menu_code = 6;  
 
SELECT * FROM tbl_menu; -- 조회된 데이터는 실제 DB에 적용된 값이 아님.

COMMIT; -- 작업 완료 * COMMIT 이후에 ROLLBACK 하면 ROLLBACK은 적용되지 않음

ROLLBACK; -- START TRANSACTION 시점으로 돌아감

-- ROLLBACK 또는 COMMIT 이후 SELECT한 것이 실제 이후에 적용된 값
SELECT * FROM tbl_menu;
