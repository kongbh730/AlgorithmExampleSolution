-- APPOINTMENT 테이블에서 from APPOINTMENT
-- 2022년 5월에 where date_format(APNT_YMD, "%Y-%m") = '2022-05'
-- 예약한 환자 수를 select count(*)
-- 진료과코드 별로 조회하는 SQL문을 작성해주세요. group by MCDP_CD
-- 이때, 컬럼명은 '진료과 코드', '5월예약건수'로 지정해주시고 as '진료과 코드', as '5월예약건수'
-- 결과는 진료과별 예약한 환자 수를 기준으로 오름차순 정렬하고, order by '5월예약건수' asc
-- 예약한 환자 수가 같다면 진료과 코드를 기준으로 오름차순 정렬해주세요. order by '진료과 코드' asc

SELECT MCDP_CD as '진료과 코드', count(*) as '5월예약건수'
from APPOINTMENT
where date_format(APNT_YMD, "%Y-%m") = '2022-05'
group by MCDP_CD
order by `5월예약건수` asc, `진료과 코드` asc;