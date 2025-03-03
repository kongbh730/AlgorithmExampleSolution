-- 코드를 입력하세요
-- USED_GOODS_BOARD와 USED_GOODS_REPLY 테이블에서 
-- 2022년 10월에 작성된 where CREATED_DATE between '2022-10-01' and '2022-10-31'
-- 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회하는 SQL문을 작성해주세요. select B.TITLE, R.BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS, date_format(R.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
-- 결과는 댓글 작성일을 기준으로 오름차순 정렬해주시고, 댓글 작성일이 같다면 게시글 제목을 기준으로 오름차순 정렬해주세요. order by CREATED_DATE asc, TITLE asc

SELECT B.TITLE, B.BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS, date_format(R.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE -- 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글내용, 댓글 작성일 
from USED_GOODS_REPLY R join USED_GOODS_BOARD B on R.BOARD_ID = B.BOARD_ID
where B.CREATED_DATE between '2022-10-01' and '2022-10-31 23:59:59' -- 2022년 10월 게시글 기준
order by R.CREATED_DATE asc, B.TITLE asc; -- 댓글 작성일 기준, 게시글 제목 기준