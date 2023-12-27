-- BUILD IN FUNCTIONS

-- 1. 문자열 관련 함수

-- 아스키 코드 <-> char
-- ASCII('A') : 문자로 아스키 코드 값 추출
-- CHAR(아스키 코드) : 아스키 코드로 문자 추출
SELECT ASCII('A'), CHAR(65);

-- bit_length(문자열) : 할당된 bit 크기(byte*8)
-- char_length(문자열) : 문자열 길이
-- length(문자열) : 할당된 byte 크기
SELECT
		 BIT_LENGTH('한글')
	  , CHAR_LENGTH('한글')
	  , LENGTH('한글');

-- CONCAT(문자열1, 문자열2,...), CONCAT_WS(구분자, 문자열1, 문자열2,...)
SELECT CONCAT('호랑이', '토끼', '용');
SELECT CONCAT_WS('@', '호랑이', '토끼', '용');
SELECT CONCAT(cast(menu_price AS CHAR), '원') FROM tbl_menu;

-- ELT(위치, 문자열1, 문자열2, ...) : 해당 위치의 문자열 반환
-- FIELD(찾을 문자열, 문자열1, 문자열2, ...) : 찾을 문자열 위치 반환
-- FIND_IN_SET(찾을 문자열, 문자열 리스트) : 찾을 문자열의 위치 반환
-- INSTR(기준 문자열, 부분 문자열) : 기준 문자열에서 부분 문자열의 시작 위치 반환
-- LOCATE(부분 문자열, 기준 문자열) : INSTR과 동일하고 파라미터 순서가 반대
SELECT 
       ELT(2, '레미제라블', '오페라의유령', '레드북')
     , FIELD('레드북', '레미제라블', '오페라의유령', '레드북')
     , FIND_IN_SET('레드북', '레미제라블,오페라의유령,레드북') -- ,만 가능?
     , INSTR('레미제라블오페라의유령레드북', '레드북') -- 12번 문자에서 레드북 시작
     , LOCATE('오페라의유령', '레미제라블오페라의유령레드북'); -- 6번 문자에서 오페라의유령 시작

-- INSERT(기준 문자열, 위치, 해당 위치에서 지울 길이, 삽입할 문자열)
-- 기준 문자열의 위치부터 길이만큼을 지우고, 삽입할 문자열을 끼워 넣는다.
SELECT INSERT('나와라 피카츄', 5, 1, '꼬부기'); -- 나와라 꼬부기카츄
SELECT INSERT('나와라 피카츄', 5, 3, '꼬부기'); -- 나와라 꼬부기

-- LEFT(문자열, 길이), RIGHT(문자열, 길이) : 문자열에서 길이만큼 반환
SELECT LEFT('Hello World!', 3), RIGHT('NICE SHOT!', 3);

-- UPPER(문자열), LOWER(문자열) : 소문자, 대문자 변환
SELECT LOWER('Hello World!'), UPPER('Hello World!');

--  LPAD(문자열, 길이, 채울 문자열), RPAD(문자열, 길이, 채울 문자열)
-- 문자열을 길이만큼 (왼쪽 또는 오른쪽으로)늘리고 빈 곳을 문자열로 채움.
SELECT LPAD('왼쪽', 10, '#'), RPAD('오른쪽', 10, '#');

-- 공백 제거
-- TRIM(문자열), TRIM(방향 '제거할 문자열' FROM '문자열')
-- 방향(LEADING(앞), BOTH(양쪽), TRAILING(뒤))
SELECT TRIM('    TRIM    '),
		 TRIM(BOTH '@' FROM '@@@@TRIM@@@@'), -- 양쪽
		 TRIM(LEADING '@' FROM '@@@@TRIM@@@@'), -- LTRIM
		 TRIM(TRAILING '@' FROM '@@@@TRIM@@@@'); -- RTRIM

-- LTRIM(문자열), RTRIM(문자열)
SELECT LTRIM('    왼쪽'), RTRIM('오른쪽    ');

SELECT CONCAT(menu_name, '의 가격은 ', menu_price, '입니다.') FROM tbl_menu;

-- 2. 숫자 관련 함수



-- 3. 날짜 및 시간 관련 함수



