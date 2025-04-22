-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문을 작성해주세요. 
-- 이때 결과는 보호 시작일이 빠른 순으로 조회해야합니다.

-- 시작일과 보호일을 비교해야 하니 ANIMAL_OUTS  과 ANIMAL_INS 둘 모두에 들어가야 함?
SELECT ANIMAL_OUTS.ANIMAL_ID, ANIMAL_OUTS.NAME
from ANIMAL_OUTS join ANIMAL_INS on ANIMAL_OUTS.ANIMAL_ID = ANIMAL_INS.ANIMAL_ID
where ANIMAL_OUTS.DATETIME < ANIMAL_INS.DATETIME
order by ANIMAL_INS.DATETIME asc;