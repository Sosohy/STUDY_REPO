#계정 생성 CREATE USER 'practice'@'%' IDENTIFIED BY 'practice';
#권한 GRANT ALL PRIVILEGES ON *.* TO 'practice'@'%';
#SELECT `user`* FROM USER;
#CREATE DATABASE employeedb;

SELECT
		 *
  FROM location;
-- 
	  
SELECT
		 a.EMP_NAME
	  , b.DEPT_TITLE
	  , c.LOCAL_NAME
	  , d.NATIONAL_NAME
  FROM employee a
  JOIN department b ON (a.DEPT_CODE = b.DEPT_ID)
  JOIN location c ON (b.LOCATION_ID = c.LOCAL_CODE)
  JOIN national d ON (c.NATIONAL_CODE = d.NATIONAL_CODE)
 WHERE d.NATIONAL_NAME IN ('한국', '일본');


SELECT
		 a.EMP_NAME
	  , b.JOB_NAME
	  , a.SALARY
  FROM employee a
  JOIN job b ON (a.JOB_CODE = b.JOB_CODE)
 WHERE a.BONUS IS NULL AND a.JOB_CODE IN ('J4', 'J7');


SELECT
		 a.EMP_NAME
	  , b.DEPT_TITLE
	  , c.LOCAL_NAME
	  , d.NATIONAL_NAME
  FROM employee a
  JOIN job b ON (a.JOB_CODE = b.JOB_CODE)
  JOIN department c ON (a.DEPT_CODE = c.DEPT_ID)
  JOIN location  ON (b.LOCATION_ID = c.LOCAL_CODE)
  JOIN national d ON (c.NATIONAL_CODE = d.NATIONAL_CODE)
 WHERE .NATIONAL_NAME IN ('한국', '일본');
 
 
--  
-- 		 a.EMP_ID
-- 		 a.EMP_NAME -- a employee
-- 	  , b.JOB_NAME -- b job
-- 	  , c.DEPT_TITLE -- c departm 
-- 	  , d.LOCAL_NAME -- d location

SELECT
		 a.EMP_ID
	  , a.EMP_NAME -- a employee
	  , b.JOB_NAME -- b job
	  , c.DEPT_TITLE -- c departm 
	  , d.LOCAL_NAME -- d location
	  , a.SALARY
  FROM employee a
  JOIN job b ON (a.JOB_CODE = b.JOB_CODE) 
  JOIN department c ON (a.DEPT_CODE = c.DEPT_ID) 
  JOIN location d ON (c.LOCATION_ID = d.LOCAL_CODE)
 WHERE b.JOB_NAME = '대리' AND d.LOCAL_NAME LIKE '%ASIA%';
 
 -- WHERE DEPT_CODE = 'D6' and SALARY > 3000000;
 

SELECT
		 a.EMP_NAME
	  , a.DEPT_CODE
	  , b.EMP_NAME
  FROM employee a
  self JOIN employee b ON (a.DEPT_CODE = b.DEPT_CODE)
 WHERE a.EMP_ID != b.EMP_ID;


SELECT
		 a.EMP_NAME '사원명'
	  , b.JOB_NAME '직급명'
	  , a.SALARY '급여'
	  , 12*a.SALARY*(1+a.BONUS) '연봉' -- 여기서 null 처리는 어떻게 해야하는지 모르겠어요
  FROM employee a
  JOIN job b ON (a.JOB_CODE = b.JOB_CODE)
  JOIN sal_grade c ON (a.SAL_LEVEL = c.SAL_LEVEL)
 WHERE a.SALARY > c.MIN_SAL;

SELECT
		 a.EMP_NAME
	  , a.DEPT_CODE
	  , b.EMP_NAME
  FROM employee a
  JOIN employee b ON (a.DEPT_CODE = b.DEPT_CODE)
 WHERE a.EMP_ID != b.EMP_ID;