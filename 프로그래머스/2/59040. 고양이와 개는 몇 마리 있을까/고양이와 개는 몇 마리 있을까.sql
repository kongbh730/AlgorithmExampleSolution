-- 동물 보호소에 들어온 동물 중 from ANIMAL_INS 
-- 고양이와 개가 각각 몇 마리인지 조회하는 SQL문을 작성해주세요. 
-- 이때 고양이를 개보다 먼저 조회해주세요.

SELECT ANIMAL_TYPE, count(*) as count
from ANIMAL_INS
group by ANIMAL_TYPE
order by 
  case ANIMAL_TYPE
    when 'Cat' then 1
    when 'Dog' then 2
    else 3
  end;