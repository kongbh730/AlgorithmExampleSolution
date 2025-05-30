-- CAR_RENTAL_COMPANY_CAR 테이블과 CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블과 CAR_RENTAL_COMPANY_DISCOUNT_PLAN 테이블에서 
-- 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중 
-- 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고 
-- 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차에 대해서 
-- 자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력하는 SQL문을 작성해주세요. 
-- 결과는 대여 금액을 기준으로 내림차순 정렬하고, 
-- 대여 금액이 같은 경우 자동차 종류를 기준으로 오름차순 정렬, 
-- 자동차 종류까지 같은 경우 자동차 ID를 기준으로 내림차순 정렬해주세요.

-- CAR_RENTAL_COMPANY_CAR car
-- CAR_RENTAL_COMPANY_RENTAL_HISTORY history
-- CAR_RENTAL_COMPANY_DISCOUNT_PLAN plan

-- 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중 
-- 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능함 조건
# select car.CAR_ID, car.CAR_TYPE
# from CAR_RENTAL_COMPANY_CAR car left join CAR_RENTAL_COMPANY_RENTAL_HISTORY history on car.CAR_ID = history.CAR_ID
#     and not (
#         history.END_DATE < '2022-11-01' OR history.START_DATE > '2022-11-30'
#     )
# where car.CAR_TYPE in ('세단', 'SUV') and history.HISTORY_ID is null;

-- 조건에 해당하는 차량의 30일 간의 대여금액 구하기
select car.CAR_ID, car.CAR_TYPE, FLOOR(car.DAILY_FEE * 30 * (100 - IFNULL(plan.DISCOUNT_RATE, 0)) / 100) as FEE
from CAR_RENTAL_COMPANY_CAR car 
    left join CAR_RENTAL_COMPANY_RENTAL_HISTORY history on car.CAR_ID = history.CAR_ID
        and not (
            history.END_DATE < '2022-11-01' OR history.START_DATE > '2022-11-30'
        )
    left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN plan on car.CAR_TYPE = plan.CAR_TYPE AND plan.DURATION_TYPE = '30일 이상'
where car.CAR_TYPE in ('세단', 'SUV') 
    and history.HISTORY_ID is null 
    and FLOOR(car.DAILY_FEE * 30 * (100 - IFNULL(plan.DISCOUNT_RATE, 0)) / 100) >= 500000
    and FLOOR(car.DAILY_FEE * 30 * (100 - IFNULL(plan.DISCOUNT_RATE, 0)) / 100) < 2000000
order by FEE desc, car.CAR_TYPE asc, car.CAR_ID desc;