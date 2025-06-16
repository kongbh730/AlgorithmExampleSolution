-- 2022년 1월의 도서 판매 데이터를 기준으로 
-- 저자 별, 카테고리 별 매출액(TOTAL_SALES = 판매량 * 판매가) 을 구하여, 
-- 저자 ID(AUTHOR_ID), 저자명(AUTHOR_NAME), 카테고리(CATEGORY), 매출액(SALES) 리스트를 출력하는 SQL문을 작성해주세요.
-- 결과는 저자 ID를 오름차순으로, 저자 ID가 같다면 카테고리를 내림차순 정렬해주세요.

SELECT B.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(BS.SALES * B.PRICE) AS TOTAL_SALES
from BOOK_SALES BS 
    join BOOK B on BS.BOOK_ID = B.BOOK_ID 
    join AUTHOR A on B.AUTHOR_ID = A.AUTHOR_ID
where BS.SALES_DATE between '2022-01-01' and '2022-01-31'
group by B.AUTHOR_ID, B.CATEGORY
order by B.AUTHOR_ID asc, B.CATEGORY desc
