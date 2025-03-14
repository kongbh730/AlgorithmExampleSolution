-- 코드를 작성해주세요

-- FISH_INFO 테이블에서 잡은 물고기 중 가장 큰 물고기의 길이를 'cm' 를 붙여 출력하는 SQL 문을 작성해주세요.
-- 이 때 컬럼명은 'MAX_LENGTH' 로 지정해주세요

select CONCAT(max(LENGTH) ,'cm') as MAX_LENGTH
from FISH_INFO;