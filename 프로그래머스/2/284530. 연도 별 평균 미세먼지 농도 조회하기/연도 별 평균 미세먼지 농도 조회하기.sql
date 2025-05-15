-- AIR_POLLUTION 테이블에서 from AIR_POLLUTION
-- 수원 지역의 where LOCATION2 = '수원'
-- 연도 별 group by year(YM) as YEAR
-- 평균 미세먼지 오염도와 avg(PM_VAL1)
-- 평균 초미세먼지 오염도를 조회하는 SQL문을 작성해주세요. avg(PM_VAL2)
-- 이때, 평균 미세먼지 오염도와 평균 초미세먼지 오염도의 컬럼명은 각각 PM10, PM2.5로 해 주시고, as PM10, as PM2.5'
-- 값은 소수 셋째 자리에서 반올림해주세요. round(value, 3)
-- 결과는 연도를 기준으로 오름차순 정렬해주세요. order by YEAR

select year(YM) as YEAR, round(avg(PM_VAL1), 2) as 'PM10', round(avg(PM_VAL2), 2) as 'PM2.5' 
from AIR_POLLUTION
where LOCATION2 = '수원'
group by YEAR
order by YEAR;