-- CONSTRAINTS

-- NOT NULL 제약 조건
DROP TABLE IF EXISTS user_notnull;
CREATE TABLE IF NOT EXISTS user_notnull (
    user_no INT NOT NULL,
    user_id VARCHAR(255) NOT NULL, -- NOT NULL은 컬럼 레벨에만 적용 가능
    user_pwd VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    gender VARCHAR(3),
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255)
) ENGINE=INNODB;

INSERT 
  INTO user_notnull
(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES
(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@gmail.com'),
(2, 'user02', 'pass02', '유관순', '여', '010-777-7777', 'yu77@gmail.com');

SELECT * FROM user_notnull;


-- user_id가 null인 경우, 에러 발생
INSERT 
  INTO user_notnull
VALUES
(3, null, 'pass03', '유관순', null, '010-777-7777', 'yu77@gmail.com'); 


-- -----------------------------------------------------
-- UNIQUE 제약 조건

DROP TABLE IF EXISTS user_unique;
CREATE TABLE IF NOT EXISTS user_unique (
    user_no INT NOT NULL UNIQUE,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    gender VARCHAR(3),
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    UNIQUE (phone)
) ENGINE=INNODB;

INSERT
  INTO user_unique
(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES
(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@gmail.com'),
(2, 'user02', 'pass02', '유관순', '여', '010-777-7777', 'yu77@gmail.com');

SELECT * FROM user_unique;

-- phone에 같은 번호가 존재할 경우 -> error
INSERT
  INTO user_unique
(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES
(3, 'user03', 'pass03', '고길동', '남', '010-1234-5678', 'go123@gmail.com');


-- ---------------------------------------------
-- PRIMARY KEY : 테이블에 대한 식별자 역할(중복X, NOT NULL)
-- 복합키의 경우, 테이블 레벨에서만 설정 가능

DROP TABLE IF EXISTS user_primarykey;
CREATE TABLE IF NOT EXISTS user_primarykey (
--  user_no INT PRIMARY KEY,
    user_no INT,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    gender VARCHAR(3),
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    PRIMARY KEY (user_no)
) ENGINE=INNODB;

INSERT 
  INTO user_primarykey
(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES
(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@gmail.com'),
(2, 'user02', 'pass02', '유관순', '여', '010-777-7777', 'yu77@gmail.com');

SELECT * FROM user_primarykey;

-- primary key 제약조건 에러 발생(null값 적용)
INSERT 
  INTO user_primarykey
(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES
(null, 'user03', 'pass03', '이순신', '남', '010-777-7777', 'lee222@gmail.com');

-- primary key 제약조건 에러 발생(중복값 적용)
INSERT 
  INTO user_primarykey
(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES
(2, 'user03', 'pass03', '이순신', '남', '010-777-7777', 'lee222@gmail.com');


-- ---------------------------------------------------
-- FOREIGN KEY 제약 조건

-- 1. 회원등급 부모 테이블 먼저 생성
DROP TABLE IF EXISTS user_grade;
CREATE TABLE IF NOT EXISTS user_grade (
    grade_code INT NOT NULL UNIQUE,
    grade_name VARCHAR(255) NOT NULL
) ENGINE=INNODB;

INSERT 
  INTO user_grade
VALUES 
(10, '일반회원'),
(20, '우수회원'),
(30, '특별회원');

SELECT * FROM user_grade;

-- 2. 회원 자식 테이블 이후에 생성(자식테이블 삭제룰X)
DROP TABLE IF EXISTS user_foreignkey1;
CREATE TABLE IF NOT EXISTS user_foreignkey1 (
    user_no INT PRIMARY KEY,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    gender VARCHAR(3),
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    grade_code INT ,
    FOREIGN KEY (grade_code) 
		REFERENCES user_grade (grade_code)
) ENGINE=INNODB;

INSERT 
  INTO user_foreignkey1
(user_no, user_id, user_pwd, user_name, gender, phone, email, grade_code)
VALUES
(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@gmail.com', 10),
(2, 'user02', 'pass02', '유관순', '여', '010-777-7777', 'yu77@gmail.com', 20);

SELECT * FROM user_foreignkey1;


-- 부모테이블에 없는 등급으로 INSERT -> 에러 발생
INSERT 
  INTO user_foreignkey1
(user_no, user_id, user_pwd, user_name, gender, phone, email, grade_code)
VALUES
(3, 'user03', 'pass03', '이순신', '남', '010-777-7777', 'lee222@gmail.com', 50);

-- 자식 테이블에서 FOREIGN KEY 제약조건 컬럼 NULL값으로 INSERT
INSERT 
  INTO user_foreignkey1
(user_no, user_id, user_pwd, user_name, gender, phone, email, grade_code)
VALUES
(3, 'user03', 'pass03', '이순신', '남', '010-777-7777', 'lee222@gmail.com', NULL);

-- -------------------------------------------------------
-- 부모 테이블 지웠을 경우
-- 1. 해당 컬럼을 NULL로
-- 2. 행을 같이 지워버리기

-- 삭제룰을 적용한 FOREIGN KEY 제약조건(외래키 제약조건)
DROP TABLE IF EXISTS user_foreignkey2;
CREATE TABLE IF NOT EXISTS user_foreignkey2 (
    user_no INT PRIMARY KEY,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    gender VARCHAR(3),
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    grade_code INT ,
    FOREIGN KEY (grade_code) 
		REFERENCES user_grade (grade_code)
        ON UPDATE SET NULL
        ON DELETE SET NULL -- 부모 테이블 지웠을 경우, 해당 컬럼 NULL로 변경
) ENGINE=INNODB;

INSERT 
  INTO user_foreignkey2
(user_no, user_id, user_pwd, user_name, gender, phone, email, grade_code)
VALUES
(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@gmail.com', 10),
(2, 'user02', 'pass02', '유관순', '여', '010-777-7777', 'yu77@gmail.com', 20);

SELECT * FROM user_foreignkey2;

-- 부모테이블에서 우수 회원 등급 삭제
SELECT * FROM user_grade;
-- user_foreignkey1 테이블은 삭제룰을 적용하지 않고 20을 참조한 데이터가 있다.
DELETE FROM user_grade WHERE grade_code = 20; -- 에러 발생
DELETE FROM user_foreignkey1 WHERE 1=1; -- 테이블 데이터 삭제

DELETE FROM user_grade WHERE grade_code = 20; -- 부모테이블에서 참조했던 부분을 null로 변경

-- 부모 테이블에 새로운 회원 등급 추가
INSERT
INTO user_grade
VALUES (40, '에메랄드 회원');

-- 부모테이블 컬럼 삭제로 NULL로 변경된 컬럼을 새로 추가한 등급으로 변경 
UPDATE user_foreignkey2
	SET grade_code = 40
 WHERE grade_code IS NULL;
 
SELECT * FROM user_foreignkey2;

-- ---------------------------------------------------
-- CHECK 제약 조건 : 조건식을 활용한 구체적인 제약 조건(논리연산|비교연산)

DROP TABLE IF EXISTS user_check;
CREATE TABLE IF NOT EXISTS user_check (
    user_no INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    gender VARCHAR(3) CHECK(gender IN ('남','여')), -- 남/여 둘 중에 하나만 들어갈 수 있음
    age INT CHECK (age >= 19) -- age값은 19 이상만 들어갈 수 있음
) ENGINE=INNODB;

INSERT 
  INTO user_check
VALUES 
(null, '홍길동', '남', 25),
(null, '이순신', '남', 33);

SELECT * FROM user_check;

-- 성별에 잘못된 값 입력해보기
INSERT 
  INTO user_check
VALUES (null, '아메바', '중', 27);

-- 나이에 잘못된 값 입력해보기(19 미만)
INSERT 
  INTO user_check
VALUES (NULL, '안중근', '남', 15);

-- ------------------------------------------
-- DEFAULT

DROP TABLE IF EXISTS tbl_country;
CREATE TABLE IF NOT EXISTS tbl_country (
    country_code INT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(255) DEFAULT '한국', -- 기본값이 '한국'으로 들어감
    population VARCHAR(255) DEFAULT '0명', -- 기본값이 '0명'으로 들어감
    add_day DATE DEFAULT (CURRENT_DATE), -- 기본값이 현재 날짜로 들어감
    add_time DATETIME DEFAULT (CURRENT_TIME) -- 기본값이 현재 시간으로 들어감
) ENGINE=INNODB;

-- default로 insert 또는 update를 하면 초기 세팅된 값으로 적용
INSERT 
  INTO tbl_country
VALUES (null, default, default, default, default);

-- insert시, default 설정된 컬럼을 무시하고 insert 하면 null이 아닌 default로 초기 세팅된 값이 적용
INSERT 
  INTO tbl_country
(country_code)
VALUES (NULL);

SELECT * FROM tbl_country;
