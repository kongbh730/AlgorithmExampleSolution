-- 3세대의 대장균의 
-- ID(ID) 를 출력하는 SQL 문을 작성해주세요. 
-- 이때 결과는 대장균의 ID 에 대해 오름차순 정렬해주세요.

SELECT g3.ID as ID
from ECOLI_DATA g1 -- 1세대
join ECOLI_DATA g2 on g2.PARENT_ID = g1.ID  -- 2세대
join ECOLI_DATA g3 on g3.PARENT_ID = g2.ID  -- 3세대
where g1.PARENT_ID is null;               -- 1세대
