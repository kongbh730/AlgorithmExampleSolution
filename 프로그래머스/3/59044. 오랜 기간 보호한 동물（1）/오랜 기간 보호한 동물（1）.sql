-- 아직 입양을 못 간 동물 중, 
-- 가장 오래 보호소에 있었던 동물 3마리의
-- 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요.
-- 이때 결과는 보호 시작일 순으로 조회해야 합니다.

SELECT ANIMAL_INS.NAME, ANIMAL_INS.DATETIME
from ANIMAL_INS left join ANIMAL_OUTS on ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
where ANIMAL_OUTS.ANIMAL_ID is null
order by ANIMAL_INS.DATETIME asc
limit 3;