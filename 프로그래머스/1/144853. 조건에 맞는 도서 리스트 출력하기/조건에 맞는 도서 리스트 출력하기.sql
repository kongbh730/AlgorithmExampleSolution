-- 코드를 입력하세요

-- BOOK 테이블에서 from BOOK
-- 2021년에 출판된 where year(PUBLISHED_DATE) = 2021
-- '인문' 카테고리에 속하는 도서 리스트를 찾아서 -- where CATEGORY = '인문'
-- 도서 ID(BOOK_ID), 출판일 (PUBLISHED_DATE)을 출력 -- select BOOK_ID, PUBLISHED_DATE
-- 결과는 출판일을 기준으로 오름차순 정렬해주세요. -- order by PUBLISHED_DATE asc;
SELECT BOOK_ID, date_format(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
from BOOK 
where year(PUBLISHED_DATE) = 2021 and CATEGORY = '인문' 
order by PUBLISHED_DATE asc;