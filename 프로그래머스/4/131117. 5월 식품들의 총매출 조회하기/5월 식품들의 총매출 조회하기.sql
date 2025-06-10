-- FOOD_PRODUCT와 FOOD_ORDER 테이블에서
-- 생산일자가 2022년 5월인 식품들의 
-- 식품 ID, 식품 이름, 총매출을 조회하는 SQL문을 작성해주세요. 
-- 이때 결과는 총매출을 기준으로 내림차순 정렬해주시고 
-- 총매출이 같다면 식품 ID를 기준으로 오름차순 정렬해주세요.

SELECT FO.PRODUCT_ID, FP.PRODUCT_NAME, (sum(FO.AMOUNT) * FP.PRICE) as TOTAL_SALES
from FOOD_ORDER FO join FOOD_PRODUCT FP on FO.PRODUCT_ID = FP.PRODUCT_ID
where FO.PRODUCE_DATE between '2022-05-01' and '2022-05-31'
group by FO.PRODUCT_ID
order by TOTAL_SALES desc, FO.PRODUCT_ID asc