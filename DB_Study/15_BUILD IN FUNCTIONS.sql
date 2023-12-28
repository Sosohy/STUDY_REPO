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
     , FIND_IN_SET('레드북', '레미제라블,오페라의유령,레드북') -- ,만 가능한듯
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

-- 길이 넘어가면 잘린다.
SELECT RPAD(CONCAT(menu_name, '의 가격은 ', menu_price, '입니다.'), 25, '##') FROM tbl_menu;

-- FORMAT(숫자, 소수점 자릿수)
-- 1000단위마다 ,표시해주고 소수점 아래 자릿수(반올림) 표현
SELECT FORMAT(1321645.2315464849, 3); -- 결과가 문자로 나옴

-- BIN(숫자) : 2진수 표현 / OCT(숫자) : 8진수 표현 / HEX(숫자) : 16진수 표현
SELECT BIN(65), OCT(65), HEX(65); -- 결과가 문자로 나옴

-- REPEAT(문자열, 횟수) : 문자열을 횟수만큼 반복
SELECT REPEAT('우하하', 3);

-- REPLACE(문자열, 찾을 문자열, 바꿀 문자열)
-- 찾을 문자열 -> 바꿀 문자열로 치환
SELECT REPLACE('오페라의 유령', '오페라', '드라큘라');

-- REVERSE(문자열) : 문자열 순서 뒤집기
SELECT REVERSE('HAPPY');

-- SPACE(길이) : 길이 만큼의 공백 반환
SELECT CONCAT('뮤지컬 이름은', SPACE(5), '이고 올해로', SPACE(3), '주년입니다.');

-- SUBSTRING(문자열, 시작위치, 길이)
-- 시작 위치부터 길이 만큼의 문자를 반환(길이 생략 시, 시작위치-끝까지 반환)
SELECT SUBSTRING('안녕하세요 반갑습니다.', 7, 2),
       SUBSTRING('안녕하세요 반갑습니다.', 7); -- 7번째부터 끝까지

-- SUBSTRING_INDEX(문자열, 구분자, 횟수)
-- 구분자가 왼쪽부터 횟수번째 나오면 그 이후의 오른쪽은 버리기
-- 횟수가 음수일 경우, 오른쪽부터 세고 왼쪽을 버린다.
SELECT SUBSTRING_INDEX('010-1234-1234', '-', 2),
       SUBSTRING_INDEX('010-1234-1234', '-', -1);

-- -------------------------------------------------------
-- 2. 숫자 관련 함수

-- ABS(숫자) : 절대값 반환
SELECT ABS(-123);

-- CEILING(숫자) : 올림값 반환(아예 올려서)
-- FLOOR(숫자) : 버림값 반환(아예 버리고)
-- ROUND(숫자) :  반올림값 반환
SELECT CEILING(1234.56), FLOOR(1234.56), ROUND(1234.46);

-- CONV(숫자, 원래 진수, 변환할 진수) : 원래 진수 -> 변환하고자 하는 진수
SELECT CONV('A', 16, 10), CONV('A', 16, 2), CONV(1010, 2, 8);

-- MOD(숫자1, 숫자2) or 숫자1%숫자2 or 숫자1 MOD 숫자2
SELECT MOD(75, 10), 75 % 10, 75 MOD 10;

-- POW(숫자1, 숫자2) : 거듭제곱값 추출
-- SQRT(숫자) : 제곱근 추출
SELECT POW(2, 4) -- 2의 4제곱(16)
     , SQRT(16); -- 16의 제곱근(4)


-- **RAND() : 0이상 1 미만의 실수를 구한다.
-- 'm <= 임의의 정수 < n'을 구하고 싶다면 FLOOR((RAND() * (n - m) + m)을 사용한다.
-- FLOOR(RAND() * 생성할 난수 갯수(구할 범위) + 난수의 초기값) -- FLOOR로 소수점 버리기
SELECT RAND(), FLOOR(RAND()*(4)+5); -- 범위 5,6,7,8(4개), 시작점 5

-- SIGN(숫자) : 양수면 1, 0이면 0, 음수면 -1
SELECT SIGN(10.1), SIGN(0), SIGN(-10.1);

-- TRUNCATE(숫자, 정수) : 소수점 기준으로 정수 위치까지 구하고 나머지 버림
SELECT TRUNCATE(12345.12345, 2), -- 소수점 2자리까지 구하기
       TRUNCATE(12345.12345, -2); -- 소수점 왼쪽 2자리까지 구하고 나머지 버리기

-- -------------------------------------------------------
-- 3. 날짜 및 시간 관련 함수

-- ADDDATE(날짜, 차이), SUBDATE(날짜, 차이) 
-- 날짜를 기준으로 차이를 더하거나 뺀 날짜 -> (윤년까지 고려해줌)
SELECT ADDDATE('2023-12-09', 100),
       ADDDATE('2023-07-28', INTERVAL 1 YEAR),
		 SUBDATE('2023-02-05', INTERVAL 30 DAY), 
       SUBDATE('2023-02-05', INTERVAL 28 MONTH);

-- ADDTIME(날짜/시간, 시간), SUBTIME(날짜/시간, 시간)
-- 날짜 또는 시간을 기준으로 시간을 더하고 뺌
SELECT SUBTIME('2023-12-28 10:23:08', '1:0:30'),
       ADDTIME('2023-12-31 23:59:29', '1:0:59');
       
-- CURDATE: 현재 연-월-일 추출
-- CURTIME: 현재 시:분:초 추출
-- NOW()/SYSDATE(): 현재 연-월-일 시:분:초 추출
SELECT CURDATE(), CURTIME(), NOW(), SYSDATE();

-- CURDATE() == CURRENT_DATE() == CURRENT_DATE
SELECT CURDATE(), CURRENT_DATE(), CURRENT_DATE;

-- CURTIME() == CURRENT_TIME() == CURRENT_TIME
SELECT CURTIME(), CURRENT_TIME(), CURRENT_TIME;

SELECT @@GLOBAL.TIME_ZONE; -- 현재 타임존 기준을 확인하는 조회문

-- 모두 동일, 컴퓨터 타임존에 따라 결과가 나옴(시스템의 현재 시간)
SELECT NOW(), LOCALTIME, LOCALTIME(), LOCALTIMESTAMP, LOCALTIMESTAMP();

-- YEAR(날짜), MONTH(날짜), DAY(날짜)
-- DAET(날짜/시간), TIME(날짜/시간) : 날짜, 시간 구분해서 추출
SELECT YEAR(CURDATE()), MONTH(CURDATE()), DAY(CURDATE()), DAY(CAST('2023-12-28' AS DATE));
SELECT HOUR(CURTIME()), MINUTE(CURTIME()), SECOND(CURRENT_TIME);

SELECT DATE(NOW()), TIME(NOW());

-- DATEDIFF(날짜1, 날짜2) : 날짜1 - 날짜2 일 수 반환(디데이)
-- TIMEDIFF(날짜1 또는 시간1, 날짜2 또는 시간2) : 시간1 - 시간2 결과 반환 
SELECT DATEDIFF('2024-06-14', '2023-12-28'),
       TIMEDIFF('2023-12-29 09:00:00', NOW()),
       TIMEDIFF('17:50:00', '10:40:00');
       
-- DAYOFWEEK(날짜) : 요일 반환(1이 일요일)
-- MONTHNAME() : 해당 달의 이름 반환
-- DAYOFYEAR(날짜) : 해당 년도에서 며칠이 지났는지 반환
SELECT DAYOFWEEK(CURDATE()), MONTHNAME(CURDATE()), DAYOFYEAR(CURDATE());

-- LAST_DAY(날짜) : 해당 날짜의 달에서 마지막 날짜 반환
SELECT LAST_DAY(NOW());

-- MAKEDATE(연도, 정수) : 해당 연도의 정수만큼 지난 날짜 반환
SELECT MAKEDATE(2023, 362);

-- MAKETIME(시, 분, 초) : '시:분:초' TIME 형식을 만듦
SELECT MAKETIME(17, 03, 02);

-- PERIOD_ADD: 연월에 + 개월 수 이후의 연월을 구한다.(연월은 YYYY 또는 YYYYMM형식)
-- PERIOD_DIFF: 연월1 - 연월2의 개월 수.
SELECT PERIOD_ADD(202312, 6),
       PERIOD_DIFF(202406, 202312);

-- QUARTER(날짜) :  해당 날짜의 분기를 구함(총 4분기)
SELECT QUARTER('2023-12-28');

-- TIME_TO_SEC(시간) : 오늘 흐른 시간을 초 단위로 구함
SELECT TIME_TO_SEC(CURTIME());
