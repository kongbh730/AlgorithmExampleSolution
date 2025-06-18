-- USER_INFO 테이블과 ONLINE_SALE 테이블에서 
-- 년, 월, 성별 별로 상품을 구매한 회원수를 집계하는 SQL문을 작성해주세요. 
-- 결과는 년, 월, 성별을 기준으로 오름차순 정렬해주세요. 
-- 이때, 성별 정보가 없는 경우 결과에서 제외해주세요.

SELECT year(OS.SALES_DATE) as YEAR, month(OS.SALES_DATE) as MONTH, UI.GENDER, count(distinct OS.USER_ID) as USERS
from ONLINE_SALE OS join USER_INFO UI on OS.USER_ID = UI.USER_ID
where GENDER is not null
group by year(OS.SALES_DATE), month(OS.SALES_DATE), UI.GENDER
order by year(OS.SALES_DATE) asc, month(OS.SALES_DATE) asc, UI.GENDER asc