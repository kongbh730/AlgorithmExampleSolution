-- 코드를 입력하세요
-- 흉부외과 또는 일반외과 의사 목록 출력
-- 고용일자 기준으로 내림차순 정렬, 고용일자가 같으면 이름을 기준으로 오름차순 정렬
-- HIRE_YMD는 YYYY-MM-DD 포맷으로 출력

SELECT DR_NAME, DR_ID, MCDP_CD, date_format(HIRE_YMD, '%Y-%m-%d')
from DOCTOR 
where MCDP_CD = 'CS' or MCDP_CD = 'GS'
order by HIRE_YMD desc, DR_NAME asc;
