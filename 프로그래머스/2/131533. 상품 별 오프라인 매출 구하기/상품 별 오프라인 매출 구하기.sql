-- 코드를 입력하세요
-- PRODUCT 테이블과 OFFLINE_SALE 테이블에서 from PRODUCT join OFFLINE_SALE on PRODUCT.PRODUCT_ID = OFFLINE_SALE.PRODUCT_ID
-- 상품코드 별 group by PRODUCT.PRODUCT_CODE
-- 매출액(판매가 * 판매량) 합계를 출력하는 SQL문을 작성해주세요. select sum(PRODUCT.PRICE * OFFLINE_SALE.SALES_AMOUNT)
-- 결과는 매출액을 기준으로 내림차순 정렬해주시고 order by PRICE desc
-- 매출액이 같다면 상품코드를 기준으로 오름차순 정렬해주세요. order by PRODUCT_CODE asc

SELECT PRODUCT.PRODUCT_CODE, sum(PRODUCT.PRICE * OFFLINE_SALE.SALES_AMOUNT) as SALES
from PRODUCT join OFFLINE_SALE on PRODUCT.PRODUCT_ID = OFFLINE_SALE.PRODUCT_ID
group by PRODUCT.PRODUCT_CODE
order by SALES desc, PRODUCT.PRODUCT_CODE asc;