-- PRODUCT 테이블에서 from PRODUCT
-- 상품 카테고리 코드(PRODUCT_CODE 앞 2자리) 별 group by CATEGORY
-- 상품 개수를 출력하는 SQL문을 작성해주세요. select substring(PRODUCT_CODE, 0, 2) as CATEGORY, count(*) as PRODUCTS
-- 결과는 상품 카테고리 코드를 기준으로 오름차순 정렬해주세요. order by PRODUCT_CODE

# SELECT substring(PRODUCT_CODE, 1, 2) as CATEGORY, count(*) as PRODUCTS
# from PRODUCT
# group by CATEGORY
# order by PRODUCT_CODE asc;


SELECT SUBSTR(PRODUCT_CODE, 1, 2) AS CATEGORY,
COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY CATEGORY
