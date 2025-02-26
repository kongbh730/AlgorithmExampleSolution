-- 코드를 입력하세요
-- 상반기에 판매된 아이스크림의 맛을 : select FLAVOR
-- 총주문량을 기준으로 내림차순 정렬하고 order by TOTAL_ORDER desc
-- 총주문량이 같다면 출하 번호를 기준으로 오름차순 정렬하여 order by SHIPMENT_ID asc
-- 조회하는 SQL 문을 작성해주세요.

SELECT FLAVOR from FIRST_HALF order by TOTAL_ORDER desc, SHIPMENT_ID asc;