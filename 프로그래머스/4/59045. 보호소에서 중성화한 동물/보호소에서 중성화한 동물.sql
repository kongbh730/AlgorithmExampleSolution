-- 보호소에 들어올 당시에는 중성화되지 않았지만,
-- 보호소를 나갈 당시에는 중성화된 동물의 
-- 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문을 작성해주세요.

SELECT AO.ANIMAL_ID, AO.ANIMAL_TYPE, AO.NAME
from ANIMAL_INS AI right join ANIMAL_OUTS AO on AI.ANIMAL_ID = AO.ANIMAL_ID
where AI.SEX_UPON_INTAKE like('%Intact%')  and (
        AO.SEX_UPON_OUTCOME like('%Spayed%' ) or 
        AO.SEX_UPON_OUTCOME like('%Neutered%')
    )