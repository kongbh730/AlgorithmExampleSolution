-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 
-- 큰 순서대로 상위 3개의 
-- 맛을 조회하는 SQL 문을 작성해주세요.

# select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
# from FIRST_HALF
# group by FLAVOR

# select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
# from JULY
# group by FLAVOR

# select * 
# from (
#     select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
#     from FIRST_HALF
#     group by FLAVOR
# ) FH 
# join (
#     select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
#     from JULY
#     group by FLAVOR
# ) J on FH.FLAVOR = J.FLAVOR

# select FH.FLAVOR, FH.TOTAL_ORDER + J.TOTAL_ORDER
# from (
#     select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
#     from FIRST_HALF
#     group by FLAVOR
# ) FH 
# join (
#     select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
#     from JULY
#     group by FLAVOR
# ) J on FH.FLAVOR = J.FLAVOR

select FH.FLAVOR
from (
    select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
    from FIRST_HALF
    group by FLAVOR
) FH 
join (
    select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
    from JULY
    group by FLAVOR
) J on FH.FLAVOR = J.FLAVOR
order by FH.TOTAL_ORDER + J.TOTAL_ORDER desc
limit 3;