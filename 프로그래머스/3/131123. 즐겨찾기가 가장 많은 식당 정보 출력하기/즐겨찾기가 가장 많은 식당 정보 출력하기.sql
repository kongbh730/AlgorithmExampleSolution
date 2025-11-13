-- REST_INFO 테이블에서 from REST_INFO
-- 음식종류별로 group by FOOD_TYPE
-- 즐겨찾기수가 가장 많은 식당의 -- 서브쿼리
-- 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회하는 SQL문을 작성해주세요. select FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
-- 이때 결과는 음식 종류를 기준으로 내림차순 정렬해주세요. order by FOOD_TYPE desc

# SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
# from REST_INFO
# where (FOOD_TYPE, FAVORITES) in (
#     select FOOD_TYPE, max(FAVORITES)
#     from REST_INFO
#     group by FOOD_TYPE
# )
# order by FOOD_TYPE desc;

SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM REST_INFO
WHERE (FOOD_TYPE, FAVORITES) IN (
    SELECT FOOD_TYPE, MAX(FAVORITES)
    FROM REST_INFO
    GROUP BY FOOD_TYPE
)
ORDER BY FOOD_TYPE DESC;
