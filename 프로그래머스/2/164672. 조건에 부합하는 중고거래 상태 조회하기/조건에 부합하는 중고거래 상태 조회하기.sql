-- USED_GOODS_BOARD 테이블에서 from USED_GOODS_BOARD
-- 2022년 10월 5일에 등록된 where CREATED_DATE = '2022-10-05'
-- 중고거래 게시물의 게시글 ID, 작성자 ID, 게시글 제목, 가격, 거래상태를 조회하는 SQL문을 작성해주세요. 
-- 거래상태가 SALE 이면 판매중, RESERVED이면 예약중, DONE이면 거래완료 분류하여 출력해주시고, 
-- 결과는 게시글 ID를 기준으로 내림차순 정렬해주세요.

SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, case 
    when STATUS = 'SALE'
    then '판매중'
    when STATUS = 'RESERVED'
    then '예약중'
    when STATUS = 'DONE'
    then '거래완료'
    end as STATUS
from USED_GOODS_BOARD
where CREATED_DATE = '2022-10-05'
order by BOARD_ID desc;

