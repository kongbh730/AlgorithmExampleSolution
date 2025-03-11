-- 코드를 작성해주세요
-- 잡은 물고기 중 길이가 10cm 이하인 where LENGTH <= 10 or LENGTH is null;
-- 물고기의 수를 출력하는 SQL 문을 작성해주세요. select count(*)
-- 물고기의 수를 나타내는 컬럼 명은 FISH_COUNT로 해주세요. -- as FISH_COUNT

select count(*) as FISH_COUNT
from FISH_INFO 
where LENGTH is null or LENGTH <= 10 ;
