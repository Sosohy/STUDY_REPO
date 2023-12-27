-- DDL

-- CREATE
CREATE TABLE IF NOT EXISTS tb1 ( 
-- IF NOT EXISTS은 옵션 : 적용 시, 기존에 존재하는 테이블이라도 에러X
    pk INT PRIMARY KEY, -- 컬럼 레벨에 제약조건 추가(컬럼 옆에 추가) + pk는 자동으로 not null
    fk INT,
    col1 VARCHAR(255), -- varchar : 들어간 데이터 크기만큼 축소시켜서 공간낭비X (가변 자료형)
    CHECK(col1 IN ('Y', 'N')) -- 테이블 레벨에서 제약조건 추가
	 -- col1컬럼에 Y 또는 N만 들어가도록 제약조건 거는 것(데이터 무결성을 위해)
) ENGINE=INNODB; -- 엔진 설정

-- 테이블 구조 확인
DESCRIBE tb1; -- (== DESC tb1;)

INSERT INTO tb1 VALUES (3, 10, 'N');
SELECT * FROM tb1;

-- ---------------------------------------------
-- auto_increment

-- DROP TABLE tb2; 테이블 삭제
CREATE TABLE IF NOT EXISTS tb2 ( 
    pk INT PRIMARY KEY AUTO_INCREMENT, 
    fk INT,
    col1 VARCHAR(255),
    CHECK(col1 IN ('Y', 'N')) 
) ENGINE=INNODB;

DESCRIBE tb2;
INSERT INTO tb2 VALUES (null, 10, 'N');
SELECT * FROM tb2;

-- --------------------------------------------
-- ALTER

-- 컬럼 추가
ALTER TABLE tb2 ADD col2 INT NOT NULL;
DESC tb2;

-- 컬럼 삭제
ALTER TABLE tb2 DROP COLUMN col2;

-- 컬럼 이름 및 컬럼 정의(데이터 형식, 제약 조건 등) 변경
ALTER TABLE tb2
CHANGE COLUMN fk change_fk INT NOT NULL;
SELECT * FROM tb2;

-- 제약조건 제거
ALTER TABLE tb2 DROP PRIMARY KEY; -- auto_increment가 존재해서 에러 발생

-- auto_increment 제거
ALTER TABLE tb2 MODIFY pk INT;

-- 한번에 여러 컬럼 추가 가능
ALTER TABLE tb2
ADD col3 DATE NOT NULL,			
ADD col4 TINYINT NOT NULL; 

-- -----------------------------------------
-- DROP
DROP TABLE tb2; -- 조건 달 수 있음

-- -----------------------------------------
-- TRUNCATE 테이블 초기화

CREATE TABLE IF NOT EXISTS tb6(
  pk INT AUTO_INCREMENT PRIMARY KEY,
  fk INT,
  col1 VARCHAR(255),
  CHECK(col1 IN ('Y', 'N'))
) ENGINE=INNODB;

-- 4개 행 데이터 INSERT
INSERT INTO tb6
VALUES
(NULL, 10, 'Y'),
(NULL, 20, 'Y'),
(NULL, 30, 'Y'),
(NULL, 40, 'Y');
SELECT * FROM tb6;

-- 테이블 초기화
TRUNCATE TABLE tb6; -- (== TRUNCATE tb6) TABLE 키워드 생략 가능
