-- 아이템의 희귀도가 'RARE'인 아이템들의
-- 모든 다음 업그레이드 아이템의 
-- 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME), 아이템의 희귀도(RARITY)를 출력하는 SQL 문을 작성해 주세요. 
-- 이때 결과는 아이템 ID를 기준으로 내림차순 정렬주세요.

select ITEM_INFO.ITEM_ID, ITEM_INFO.ITEM_NAME, ITEM_INFO.RARITY
from ITEM_INFO 
where ITEM_INFO.ITEM_ID IN 
(
    SELECT ITEM_TREE.ITEM_ID
    FROM ITEM_INFO
    JOIN ITEM_TREE ON ITEM_INFO.ITEM_ID = ITEM_TREE.PARENT_ITEM_ID
    WHERE ITEM_INFO.RARITY = 'RARE'
)
order by ITEM_INFO.ITEM_ID desc;