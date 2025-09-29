-- 보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 
-- 09:00부터 19:59까지, -- where hour(DATETIME) between 9 and 19
-- 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요. -- SELECT hour(DATETIME) as HOUR, count(*) as COUNT
-- 이때 결과는 시간대 순으로 정렬해야 합니다. -- order by hour(DATETIME) asc;

# SELECT hour(DATETIME) as HOUR, count(*) as COUNT
# from ANIMAL_OUTS
# where hour(DATETIME) between 9 and 19
# group by hour(DATETIME)
# order by hour(DATETIME) asc;

# SELECT HOUR_GROUP as HOUR, count(*) as COUNT
# from(
#     select hour(DATETIME) as HOUR_GROUP
#     from ANIMAL_OUTS
#     where hour(DATETIME) BETWEEN 9 AND 19
# ) as TEMP_TABLE
# group by HOUR_GROUP
# order by HOUR_GROUP asc;

SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR
HAVING HOUR BETWEEN 9 AND 19
ORDER BY HOUR ASC