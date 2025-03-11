-- 코드를 작성해주세요

-- FISH_INFO 테이블에서 from FISH_INFO
-- 가장 큰 물고기 10마리의 ID와 길이를 출력하는 SQL 문을 작성해주세요. select ID, LENGTH
-- 결과는 길이를 기준으로 내림차순 정렬하고, order by LENGTH DESC
-- 길이가 같다면 물고기의 ID에 대해 오름차순 정렬해주세요.  order by ID ASC
-- 단, 가장 큰 물고기 10마리 중 길이가 10cm 이하인 경우는 없습니다. 
-- ID 컬럼명은 ID, 길이 컬럼명은 LENGTH로 해주세요.

select ID, LENGTH
from FISH_INFO
where LENGTH > 10
order by LENGTH desc, ID asc
limit 10;