-- 코드를 작성해주세요

-- DEVELOPERS 테이블에서 from DEVELOPERS
-- Python이나 C# 스킬을 가진 개발자의 정보를 조회하려 합니다. in ('Python', 'C#')
-- 조건에 맞는 개발자의 ID, 이메일, 이름, 성을 조회하는 SQL 문을 작성해 주세요. select ID, EMAIL, FIRST_NAME, LAST_NAME
-- 결과는 ID를 기준으로 오름차순 정렬해 주세요. order by ID asc

-- select * from DEVELOPERS;
-- select CODE from SKILLCODES where NAME in ('Python', 'C#');

select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS 
where SKILL_CODE & 1024 or SKILL_CODE & 256
order by ID asc;
