-- INDEX

-- 인덱스 생성
CREATE TABLE phone (
    phone_code INT PRIMARY KEY,
    phone_name VARCHAR(100),
    phone_price DECIMAL(10, 2)
);

INSERT 
  INTO phone (phone_code , phone_name , phone_price )
VALUES 
(1, 'galaxyS23', 1200000),
(2, 'iPhone14pro', 1433000),
(3, 'galaxyZfold3', 1730000);

SELECT * FROM phone;

-- 단순 조회
SELECT * FROM phone WHERE phone_name = 'galaxyS23';

-- 조회의 실행 계획 확인
-- 조회가 어떤 것을 활용하여 실행했는지 -> 현재는 where절 활용
EXPLAIN SELECT * FROM phone WHERE phone_name = 'galaxyS23';

-- where절에 활용한 컬럼에 index 추가
CREATE INDEX idx_name ON phone (phone_name);

-- 복합 인덱스 생성도 가능
-- CREATE INDEX idx_name_price ON phone (phone_name, phone_price);

-- 인덱스 생성 확인
SHOW INDEX FROM phone;

-- 인덱스 추가 후, 다시 해당 컬럼을 조건으로 조회 -> using index condition
EXPLAIN SELECT * FROM phone WHERE phone_name = 'galaxyS23';

-- 인덱스는 주기적으로 다시 달아주어야 함(테이블과 인덱스 최적화)
OPTIMIZE TABLE phone;

-- 인덱스 삭제
DROP INDEX idx_name ON phone;
SHOW INDEX FROM phone;

-- 인덱스 재구성
ALTER TABLE phone DROP INDEX idx_name;
ALTER TABLE phone ADD INDEX idx_name(phone_name);


