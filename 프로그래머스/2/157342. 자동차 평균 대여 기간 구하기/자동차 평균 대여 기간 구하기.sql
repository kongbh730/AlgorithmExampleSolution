-- CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 from CAR_RENTAL_COMPANY_RENTAL_HISTORY
-- 평균 대여 기간이 7일 이상인 자동차들의 where AVERAGE_DURATION >= 7
-- 자동차 ID와 평균 대여 기간(컬럼명: AVERAGE_DURATION) 리스트를 출력하는 SQL문을 작성해주세요. select CAR_ID, avg(END_DATE - START_DATE) as AVERAGE_DURATION
-- 평균 대여 기간은 소수점 두번째 자리에서 반올림하고, round(avg(END_DATE - START_DATE), 1) as AVERAGE_DURATION
-- 결과는 평균 대여 기간을 기준으로 내림차순 정렬해주시고, order by AVERAGE_DURATION
-- 평균 대여 기간이 같으면 자동차 ID를 기준으로 내림차순 정렬해주세요. order by CAR_ID;

-- SELECT CAR_ID, round(avg(END_DATE - START_DATE + 1), 1) as AVERAGE_DURATION
SELECT CAR_ID, round(avg(datediff(END_DATE, START_DATE) + 1), 1) as AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
having avg(datediff(END_DATE, START_DATE) + 1) >= 7
order by AVERAGE_DURATION desc, CAR_ID desc;