-- 입양을 간 동물 중, ANIMAL_OUTS에 존재해야함
-- 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름을 조회하는 SQL문을 작성해주세요. limit 2
-- 이때 결과는 보호 기간이 긴 순으로 조회해야 합니다.

SELECT ANIMAL_OUTS.ANIMAL_ID, ANIMAL_OUTS.NAME
from ANIMAL_OUTS join ANIMAL_INS on ANIMAL_OUTS.ANIMAL_ID = ANIMAL_INS.ANIMAL_ID
order by ANIMAL_OUTS.DATETIME - ANIMAL_INS.DATETIME desc
limit 2;