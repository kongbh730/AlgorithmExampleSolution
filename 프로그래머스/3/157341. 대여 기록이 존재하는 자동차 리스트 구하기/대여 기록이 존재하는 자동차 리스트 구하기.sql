-- CAR_RENTAL_COMPANY_CAR 테이블과 CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 
-- 자동차 종류가 '세단'인 자동차들 중 
-- 10월에 대여를 시작한 기록이 있는 자동차 ID 리스트를 출력하는 SQL문을 작성해주세요. 
-- 자동차 ID 리스트는 중복이 없어야 하며, 
-- 자동차 ID를 기준으로 내림차순 정렬해주세요.

-- 우선 10월에 대여를 시작한 자동차 ID 구하기
# select CAR_ID
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
# where month(START_DATE) = 10

-- 10월에 대여를 시작한 기록이 있는 세단 종류 자동차 찾기
select distinct CAR_RENTAL_COMPANY_CAR.CAR_ID
from CAR_RENTAL_COMPANY_CAR join CAR_RENTAL_COMPANY_RENTAL_HISTORY on CAR_RENTAL_COMPANY_CAR.CAR_ID = CAR_RENTAL_COMPANY_RENTAL_HISTORY.CAR_ID
where CAR_RENTAL_COMPANY_CAR.CAR_TYPE = '세단' and month(CAR_RENTAL_COMPANY_RENTAL_HISTORY.START_DATE) = 10
order by CAR_RENTAL_COMPANY_CAR.CAR_ID desc;