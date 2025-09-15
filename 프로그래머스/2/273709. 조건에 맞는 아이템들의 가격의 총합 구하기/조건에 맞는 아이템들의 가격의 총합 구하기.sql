-- 코드를 작성해주세요
-- ITEM_INFO 테이블에서 from ITEM_INFO
-- 희귀도가 'LEGEND'인 아이템들의  where RARITY = 'LEGEND'
-- 가격의 총합을 구하는 SQL문을 작성해 주세요.  select sum(price)
-- 이때 컬럼명은 'TOTAL_PRICE'로 지정해 주세요. as TOTAL_PRICE

# select sum(price) as TOTAL_PRICE
# from ITEM_INFO
# where RARITY = 'LEGEND';


SELECT SUM(PRICE) AS TOTAL_PRICE
FROM ITEM_INFO
WHERE RARITY = 'LEGEND'