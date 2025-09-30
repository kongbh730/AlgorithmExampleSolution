-- 코드를 입력하세요

-- PRODUCT 테이블에서 from PRODUCT
-- 만원 단위의 가격대 별로 상품 개수를 출력하는 SQL 문을 작성해주세요. 이때 컬럼명은 각각 컬럼명은 PRICE_GROUP, PRODUCTS로 지정해주시고 select (price / 10000) as PRICE_GROUP, count(*) as PRODUCTS
-- 가격대 정보는 각 구간의 최소금액(10,000원 이상 ~ 20,000 미만인 구간인 경우 10,000)으로 표시해주세요. group by (price / 10000)
-- 결과는 가격대를 기준으로 오름차순 정렬해주세요. order by PRICE_GROUP asc;

# SELECT floor(price / 10000) * 10000 as PRICE_GROUP, count(*) as PRODUCTS
# from PRODUCT
# group by floor(price / 10000)
# order by PRICE_GROUP asc;

SELECT (FLOOR(PRICE / 10000) * 10000) AS PRICE_GROUP, COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP ASC