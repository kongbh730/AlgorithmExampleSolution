-- USED_GOODS_BOARD와 USED_GOODS_FILE 테이블에서 
-- 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회하는 SQL문을 작성해주세요.
-- 첨부파일 경로는 FILE ID를 기준으로 내림차순 정렬해주세요.
-- 기본적인 파일경로는 /home/grep/src/ 이며, 게시글 ID를 기준으로 디렉토리가 구분되고, 
-- 파일이름은 파일 ID, 파일 이름, 파일 확장자로 구성되도록 출력해주세요. 
-- 조회수가 가장 높은 게시물은 하나만 존재합니다.

-- 조회수가 가장 높은 ID부터 찾기
select BOARD_ID
from  USED_GOODS_BOARD
order by VIEWS desc
limit 1;

-- 해당 ID 기준으로 정보 조회
select BOARD_ID, FILE_ID, FILE_NAME, FILE_EXT
from USED_GOODS_FILE
where BOARD_ID = (
    select BOARD_ID
    from  USED_GOODS_BOARD
    order by VIEWS desc
    limit 1
);

-- concat으로 문자열 합체
select concat('/home/grep/src/',BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT) as FILE_PATH
from USED_GOODS_FILE
where BOARD_ID = (
    select BOARD_ID
    from  USED_GOODS_BOARD
    order by VIEWS desc
    limit 1
)
order by FILE_ID desc;
