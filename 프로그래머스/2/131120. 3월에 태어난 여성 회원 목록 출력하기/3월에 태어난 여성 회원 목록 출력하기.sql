-- 코드를 입력하세요
-- MEMBER_PROFILE 테이블에서 from MEMBER_PROFILE
-- 생일이 3월인 where
-- 여성 회원의 where GENDER = 'W'
-- ID, 이름, 성별, 생년월일을 조회하는 SQL문을 작성해주세요. select MEMBER_ID, MEMBER_NAME, GENDER, DATE_OF_BIRTH
-- 이때 전화번호가 NULL인 경우는 출력대상에서 제외시켜 주시고, where TLNO not null
-- 결과는 회원ID를 기준으로 오름차순 정렬해주세요. order by MEMBER_ID asc;
SELECT MEMBER_ID, MEMBER_NAME, GENDER, date_format(DATE_OF_BIRTH, '%Y-%m-%d') as 'DATE_OF_BIRTH'
from MEMBER_PROFILE
where date_format(DATE_OF_BIRTH, '%m') = '03' and GENDER = 'W' and TLNO is not NULL
order by MEMBER_ID asc;

