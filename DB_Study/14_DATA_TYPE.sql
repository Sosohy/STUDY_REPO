-- DATA TYPE

-- 명시적 형변환
SELECT AVG(menu_price) FROM tbl_menu; -- 메뉴 전체를 하나의 그룹으로 봄

-- 1. 숫자 -> 숫자

-- 소수점에서 반올림해 정수로 변환
SELECT CAST(AVG(menu_price) AS UNSIGNED INTEGER) AS '가격 평균' FROM tbl_menu; -- 숫자가 크면 unsigned 사용

-- 소수점 이하 한자리까지 변환
SELECT CAST(AVG(menu_price) AS FLOAT) AS '가격 평균' FROM tbl_menu; -- 숫자가 크면 unsigned 사용

-- 소수점 이하 12자리까지 변환
SELECT CONVERT(AVG(menu_price), DOUBLE) AS '가격 평균' FROM tbl_menu;

-- 2. 문자 -> 날짜 
-- 구분자($, /, % 등)로 date 나눔

-- 2023년 12월 27일 date형으로 변환
SELECT CAST('2023/12/27' AS DATE);
SELECT CONVERT('2023*12*27', DATE);
SELECT CONVERT('2023=12^27', DATE);

-- 3. 숫자 -> 문자
SELECT CONCAT(CAST(1000 AS CHAR), '원');
-- SELECT 1000+'원'; -- 문자('원')는 암시적 형변환에 의해 0으로 변환됨

SELECT CAST(menu_price AS CHAR(5)) FROM tbl_menu; -- 모든 메뉴의 가격을 문자열로 변환
SELECT CONCAT(CAST(menu_price AS CHAR(5)), '원') FROM tbl_menu; -- 모든 메뉴의 가격에 '원' 붙이기

-- -----------------------------------------------------
-- 암시적 형변환(내부적으로 자동 형변환)
-- 연산자 사용 시 자동 형변환이 되는데 주의해야 함.

SELECT 1 + '2'; -- '2'가 숫자 2로 변환
SELECT '1' + '2';  -- 각 문자가 정수로 변환됨(결과값 3이 나옴)
SELECT CONCAT('1', '2');    -- '12'로 변환

-- 모든 문자는 산술연산 또는 비교 연산을 만나면 0으로 변환.
SELECT 3 > 'MAY'; -- 'MAY'는 0으로 변환됨
SELECT '안녕'+'하세요'; -- 둘 다 0으로 변환됨


