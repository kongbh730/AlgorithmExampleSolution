-- 2022년 1월의 카테고리 별 도서 판매량을 합산하고, 
-- 카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력하는 SQL문을 작성해주세요.
-- 결과는 카테고리명을 기준으로 오름차순 정렬해주세요.
SELECT BOOK.CATEGORY, sum(BOOK_SALES.SALES) as TOTAL_SALES
from BOOK_SALES join BOOK on BOOK_SALES.BOOK_ID = BOOK.BOOK_ID
where year(BOOK_SALES.SALES_DATE) = 2022 and month(BOOK_SALES.SALES_DATE) = 1
group by CATEGORY
order by CATEGORY asc;