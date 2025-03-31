-- 코드를 입력하세요

-- FOOD_WAREHOUSE 테이블에서 from FOOD_WAREHOUSE
-- 경기도에 위치한 창고의 where WAREHOUSE_NAME like '창고_경기%'
-- ID, 이름, 주소, 냉동시설 여부를 조회하는 SQL문을 작성해주세요. select WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, FREEZER_YN
-- 이때 냉동시설 여부가 NULL인 경우, 'N'으로 출력시켜 주시고 ifnull(FREEZER_YN, 'N')
-- 결과는 창고 ID를 기준으로 오름차순 정렬해주세요. order by WAREHOUSE_ID asc;

SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, ifnull(FREEZER_YN, 'N')
from FOOD_WAREHOUSE
where WAREHOUSE_NAME like '창고_경기%'
order by WAREHOUSE_ID asc;