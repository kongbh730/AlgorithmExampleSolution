-- '경제' 카테고리에 속하는 도서들의 where CATEGORY = '경제'
-- 도서 ID(BOOK_ID), 저자명(AUTHOR_NAME), 출판일(PUBLISHED_DATE) 리스트를 출력하는 SQL문을 작성해주세요. select BOOK_ID, AUTHOR_NAME, PUBLISHED_DATE
-- 결과는 출판일을 기준으로 오름차순 정렬해주세요. order by PUBLISHED_DATE asc

-- 코드를 입력하세요
SELECT BOOK.BOOK_ID, AUTHOR.AUTHOR_NAME, DATE_FORMAT(BOOK.PUBLISHED_DATE,'%Y-%m-%d') as PUBLISHED_DATE
from BOOK join AUTHOR on BOOK.AUTHOR_ID = AUTHOR.AUTHOR_ID
where BOOK.CATEGORY = '경제'
order by PUBLISHED_DATE asc;