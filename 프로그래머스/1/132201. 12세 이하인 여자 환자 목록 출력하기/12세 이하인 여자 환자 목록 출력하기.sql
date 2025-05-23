-- 코드를 입력하세요

-- PATIENT 테이블에서 from PATIENT
-- 12세 이하인 where AGE <= 12
-- 여자환자의 where GEND_CD = 'W'
-- 환자이름, 환자번호, 성별코드, 나이, 전화번호를 조회하는 SQL문을 작성해주세요. select PT_NAME, PT_NO, GEND_CD, AGE, TLNO
-- 이때 전화번호가 없는 경우, 'NONE'으로 출력시켜 주시고 ifnull(TLNO, 'NONE')
-- 결과는 나이를 기준으로 내림차순 정렬하고, order by AGE desc
-- 나이 같다면 환자이름을 기준으로 오름차순 정렬해주세요. -- order by PT_NAME asc;

SELECT PT_NAME, PT_NO, GEND_CD, AGE, ifnull(TLNO, 'NONE') as TLNO
from PATIENT
where AGE <= 12 && GEND_CD = 'W'
order by AGE desc, PT_NAME asc;