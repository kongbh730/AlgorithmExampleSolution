-- ROOT 아이템을 찾아 
-- 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME)을 출력하는 SQL문을 작성해 주세요. 
-- 이때, 결과는 아이템 ID를 기준으로 오름차순 정렬해 주세요.

select ITEM_ID, ITEM_NAME
from ITEM_INFO 
where ITEM_ID in (
    select ITEM_ID
    from ITEM_TREE 
    where PARENT_ITEM_ID is null
)
order by ITEM_ID asc;
