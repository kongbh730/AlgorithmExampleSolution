-- 동물 보호소에 들어온 동물 이름 중, from ANIMAL_INS 
-- 이름에 "EL"이 들어가는 where NAME like('%EL%') and ANIMAL_TYPE = 'Dog'
-- 개의 아이디와 이름을 조회하는 SQL문을 작성해주세요. select ANIMAL_ID, NAME
-- 이때 결과는 이름 순으로 조회해주세요. 단, 이름의 대소문자는 구분하지 않습니다. order by NAME asc
SELECT ANIMAL_ID, NAME
from ANIMAL_INS
where NAME like('%EL%') and ANIMAL_TYPE = 'Dog'
order by NAME asc;