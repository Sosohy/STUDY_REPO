### TRANSACTION
- 한 번에 수행되는 작업의 단위
- ROLLBACK : 시작 이전 단계로 되돌리는 작업(모든 연산 취소)
- COMMIT : 작업이 성공하여 데이터 베이스에 반영(커밋 이후 롤백 불가)

```sql
START TRANSACTION;

SELECT * FROM tbl_menu;
INSERT INTO tbl_menu VALUES (null, '바나나해장국', 8500, 4, 'Y');
UPDATE tbl_menu SET menu_name = '수정된 메뉴' WHERE menu_code = 5;
DELETE FROM tbl_menu WHERE menu_code = 7;

-- COMMIT; 
ROLLBACK;
```

#### 트랜잭션 특성 - ACID
A(Atomicity) 원자성 : 전부 반영되거나 전부 반영되지 않아야 함.
C(Consistency) 일관성 : 실행 전과 후의 상태가 같아야 함.
I(Isolation) 독립성 : 트랜잭션은 독립적으로 실행되어야 함.
D(Durability) 영속성 : 완료된 결과는 영구적으로 반영되어야 함.

<hr>

### CONSTRAINTS
- 테이블에 데이터가 입력되거나 수정될 때의 규칙을 정의
- 데이터 무결성을 보장하는 데 도움

#### NOT NULL
- NULL값을 허용 X

#### UNIQUE
- 중복값 허용 X

#### PRIMARY KEY
- 테이블에서 한 행의 정보를 찾기 위해 사용 할 컬럼을 의미
- 테이블에 대한 식별자 역할
- NOT NULL + UNIQUE

#### FOREIGN KEY
- 참조 무결성을 위배하지 않기 위해 사용
- 참조(REFERENCES)된 다른 테이블에서 제공하는 값만 사용 가능
- 제공되는 값 외에는 NULL을 사용 O

#### CHECK
- check 제약 조건 위반시 허용하지 않음

#### DEFAULT
- 컬럼에 null 대신 기본 값 적용
- 컬럼 타입이 DATE일 시 current_date만 가능
- 컬럼 타입이 DATETIME일 시 current_time과 current_timestamp, now() 모두 사용 가능

<hr>

### DATA TYPE

#### 형 변환
- SQL 데이터의 형변환에는 명시적 형변환과 암시적 형변환이 있다.
- **명시적 형변환(Explicit Conversion)**
    - 사용자가 직접 데이터 타입을 변경하는 것
    - `CAST (expression AS 데이터형식 [(길이)])`
    - `CONVERT (expression, 데이터형식 [(길이)])`
    - 데이터 형식으로 가능한 것은 BINARY, CHAR, DATE, DATETIME, DECIMAL, JSON, SIGNED INTEGER, TIME, UNSIGNED INTEGER 등이 있다.
- **암시적 형변환(Implicit Conversion)**
    - 따로 처리하지 않아도 (연산자 사용 시) 내부적으로 자동 형변환
