-- 더 이상 업그레이드할 수 없는 아이템의 
-- 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME), 아이템의 희귀도(RARITY)를 출력하는 SQL 문을 작성해 주세요. 
-- 이때 결과는 아이템 ID를 기준으로 내림차순 정렬해 주세요.
-- 셀프 조인?

# select *
# from ITEM_INFO II
#     left join ITEM_TREE IT on II.ITEM_ID = IT.PARENT_ITEM_ID
# order by II.ITEM_ID desc;

select II.ITEM_ID, II.ITEM_NAME, II.RARITY
from ITEM_INFO II
    left join ITEM_TREE IT on II.ITEM_ID = IT.PARENT_ITEM_ID
where IT.PARENT_ITEM_ID is null
order by II.ITEM_ID desc;
