-- 코드를 입력하세요
-- CAR_RENTAL_COMPANY_CAR 테이블에서 -> from CAR_RENTAL_COMPANY_CAR
-- 자동차 종류가 'SUV'인 자동차들의 -> where CAR_TYPE = 'SUV'
-- 평균 일일 대여 요금을 출력하는 SQL문을 작성해주세요. -> sum(DAILY_FEE) / count(*)
-- 이때 평균 일일 대여 요금은 소수 첫 번째 자리에서 반올림하고, -> round(sum(DAILY_FEE) / count(*), 0)
-- 컬럼명은 AVERAGE_FEE 로 지정해주세요. -> as AVERAGE_FEE

SELECT round(sum(DAILY_FEE) / count(*), 0) as AVERAGE_FEE from CAR_RENTAL_COMPANY_CAR where CAR_TYPE = 'SUV';