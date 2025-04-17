-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성해주세요.

-- ANIMAL_OUTS 에는 존재하는 ANIMAL_ID가
-- ANIMAL_INS 에서는 조회되지 않는 경우?

SELECT ANIMAL_ID, NAME
from ANIMAL_OUTS
where not exists(
    select 1 -- SELECT * 써도 되지만 보통은 1로 쓰는 게 관례, 존재 여부만 파악하는 용도
    from ANIMAL_INS
    where ANIMAL_OUTS.ANIMAL_ID = ANIMAL_INS.ANIMAL_ID
)
order by ANIMAL_OUTS.ANIMAL_ID;