select USED_GOODS_USER.USER_ID, 
       USED_GOODS_USER.NICKNAME, 
       concat(USED_GOODS_USER.CITY, ' ', USED_GOODS_USER.STREET_ADDRESS1, ' ', USED_GOODS_USER.STREET_ADDRESS2) AS 전체주소, 
       concat(left(USED_GOODS_USER.TLNO, 3), '-', mid(USED_GOODS_USER.TLNO, 4, 4), '-', right(USED_GOODS_USER.TLNO, 4)) as 전화번호
FROM USED_GOODS_USER
join (
    select WRITER_ID
    from USED_GOODS_BOARD
    group by WRITER_ID
    having count(*) >= 3
) board on USED_GOODS_USER.USER_ID = board .WRITER_ID
order by USED_GOODS_USER.USER_ID desc;
