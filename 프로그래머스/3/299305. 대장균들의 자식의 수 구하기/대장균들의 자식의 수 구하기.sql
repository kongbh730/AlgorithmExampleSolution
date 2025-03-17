-- 코드를 작성해주세요
-- 대장균 개체의 ID(ID)와 자식의 수(CHILD_COUNT)를 출력하는 SQL 문을 작성해주세요. select ID, as CHILD_COUNT
-- 자식이 없다면 자식의 수는 0으로 출력해주세요. 
-- 이때 결과는 개체의 ID 에 대해 오름차순 정렬해주세요. order by ID
-- 직계 자식까지만

select P.ID, count(C.ID) as CHILD_COUNT
from ECOLI_DATA P
left join ECOLI_DATA C on P.ID = C.PARENT_ID
group by P.ID
order by P.ID;