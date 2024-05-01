### DML(Data Manipulation Language)
- 데이터 조작언어
- 값 삽입, 수정, 삭제

#### INSERT
- 새로운 행 추가
- 행의 수 증가

```sql
INSERT 
  INTO tbl_menu
(
  menu_name, menu_price
, category_code, orderable_status
)
VALUES 
(
  '초콜릿죽', 6500
, 7, 'Y'
);
```

#### UPDATE
- 테이블에 기록된 컬럼의 값을 수정
- 전체 행 개수 변화 X
- 서브쿼리도 활용 가능
    - 단 자기 자신의 테이블 사용할 수 없음

```sql
UPDATE tbl_menu
   SET category_code = 7
     , menu_name = '딸기맛붕어빵'
 WHERE menu_code = 24;
```

#### DELETE
- 테이블의 행 삭제
- 행의 수 감소

```sql
DELETE
  FROM tbl_menu
 WHERE menu_code = 24;
 -- LIMIT 2; LIMIT 활용 가능
 
```

#### REPLACE
- INSERT 시 PRIMARY KEY 또는 UNIQUE KEY가 충돌이 발생할 수 있다면, REPLACE를 통해 중복 된 데이터를 덮어쓰기 가능
- 업데이트 시, WHERE 구문 없이 UPDATE가 가능

```sql
-- INSERT INTO tbl_menu VALUES (17, '참기름소주', 5000, 10, 'Y'); -- 에러 발생
REPLACE INTO tbl_menu VALUES (17, '참기름소주', 5000, 10, 'Y');
```

<hr>

### DDL(Data Definition Language)
- 데이터 정의어
- 데이터베이스의 스키마를 정의하거나 수정하는 데 사용

#### CREATE
- 테이블 생성을 위한 구문
-  IF NOT EXISTS를 적용 시, 기존에 존재하는 테이블이라도 에러 발생 X

```sql
CREATE TABLE IF NOT EXISTS tb1 (
    pk INT PRIMARY KEY, -- 컬럼 레벨에서  제약조건 추가
    fk INT,
    col1 VARCHAR(255),
    CHECK(col1 IN ('Y', 'N')) -- 테이블 레벨에서 제약조건 추가
) ENGINE=INNODB;
```
>AUTO_INCREMENT
- INSERT 시 PRIMARY키에 해당하는 컬럼에 자동으로 번호를 발생(중복되지 않게)시켜 저장

#### ALTER
- 테이블에 추가/변경/수정/삭제
- 열 추가 : `ALTER TABLE 테이블명 ADD 컬럼명 컬럼정의`
- 열 삭제 : `ALTER TABLE 테이블명 DROP COLUMN 컬럼명`
- 열 이름 및 데이터 형식 변경 : `ALTER TABLE 테이블명 CHANGE COLUMN 기존컬럼명 바꿀 컬럼명 컬럼정의`
- 열 제약 조건 추가 및 삭제 : `ALTER TABLE 테이블명 drop 제약조건`

  ```sql
  ALTER TABLE tb2
   ADD col2 INT NOT NULL; -- 컬럼 추가
  -- DROP COLUMN col2;      -- 컬럼 삭제
  -- CHANGE COLUMN fk change_fk INT NOT NULL; -- 열 이름 및 데이터 형식 변경
  -- MODIFY pk INT; -- 컬럼 정의 변경
  -- DROP PRIMARY KEY; -- 제약조건 삭제
  ```

#### DROP
- 테이블 삭제

```sql
DROP TABLE IF EXISTS tb3, tb5;
```

#### TRUNCATE
- 테이블 초기화
- AUTO_INCREMENT 컬럼이 있는 경우 시작 값도 0으로 초기화

```sql
-- TRUNCATE TABLE tb6;
TRUNCATE tb6;    -- TABLE 키워드 생략 가능
```


