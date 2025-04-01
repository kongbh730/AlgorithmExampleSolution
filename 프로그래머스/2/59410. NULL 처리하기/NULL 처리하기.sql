-- 코드를 입력하세요

-- 동물의 생물 종, 이름, 성별 및 중성화 여부를 select ANIMAL_TYPE, NAME, SEX_UPON_INTAKE
-- 아이디 순으로 조회하는 SQL문을 작성해주세요. order by ANIMAL_ID
-- 이때 프로그래밍을 모르는 사람들은 NULL이라는 기호를 모르기 때문에, 이름이 없는 동물의 이름은 "No name"으로 표시해 주세요. select ifnull(NAME, 'No name')

SELECT ANIMAL_TYPE, ifnull(NAME, 'No name') as NAME, SEX_UPON_INTAKE
from ANIMAL_INS 
order by ANIMAL_ID;