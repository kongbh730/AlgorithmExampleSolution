-- 0시부터 23시까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요. 
-- 이때 결과는 시간대 순으로 정렬해야 합니다.

# SELECT hour(DATETIME) as HOUR, count(*) as COUNT
# from ANIMAL_OUTS 
# group by hour(DATETIME)
# order by hour(DATETIME) asc;

WITH RECURSIVE HOURS AS (
  SELECT 0 AS hour
  UNION ALL
  SELECT hour + 1 FROM HOURS WHERE hour < 23
)
SELECT 
  hour AS HOUR,
  COUNT(AO.DATETIME) AS COUNT
FROM HOURS H
LEFT JOIN ANIMAL_OUTS AO
  ON HOUR(AO.DATETIME) = H.hour
GROUP BY hour
ORDER BY hour;
