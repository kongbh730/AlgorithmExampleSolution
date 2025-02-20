-- 코드를 입력하세요

-- 상반기 아이스크림 총 주문량이 3000보다 높고, where TOTAL_ORDER > 3000
-- 아이스크림 주 성분이 과일인 where INGREDIENT_TYPE = fruit_based
-- 아이스크림의 맛을 FLAVOR
-- 총 주문량이 큰 순서대로 조회 order by TOTAL_ORDER desc

SELECT II.FLAVOR
from ICECREAM_INFO II
    join FIRST_HALF FH on II.FLAVOR = FH.FLAVOR -- inner join : ICECREAM_INFO와 FIRST_HALF에서 일치하는 데이터만 조회
where FH.TOTAL_ORDER > 3000 -- where TOTAL_ORDER > 3000
and II.INGREDIENT_TYPE = 'fruit_based' -- where INGREDIENT_TYPE = 'fruit_based'
order by FH.TOTAL_ORDER desc; -- order by TOTAL_ORDER desc