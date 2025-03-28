-- 코드를 입력하세요
-- 동물 보호소에 들어온 동물 중, -- from ANIMAL_INS 
-- 이름이 없는 채로 들어온 -- where NAME is null
-- 동물의 ID를 조회하는 SQL 문을 작성해주세요. -- select ANIMAL_ID
-- 단, ID는 오름차순 정렬되어야 합니다. -- order by ANIMAL_ID

SELECT ANIMAL_ID
from ANIMAL_INS 
where NAME is null
order by ANIMAL_ID;