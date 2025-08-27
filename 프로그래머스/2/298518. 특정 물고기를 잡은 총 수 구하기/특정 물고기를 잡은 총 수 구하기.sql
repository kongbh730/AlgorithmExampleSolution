-- 코드를 작성해주세요
-- FISH_INFO 테이블에서 잡은 BASS와 SNAPPER의 수를 출력하는 SQL 문을 작성해주세요.
-- 컬럼명은 'FISH_COUNT`로 해주세요.

# select count(*) as 'FISH_COUNT'
# from FISH_INFO
# where FISH_INFO.FISH_TYPE in
# (
#     select FISH_TYPE
#     from FISH_NAME_INFO 
#     where FISH_NAME in ('BASS', 'SNAPPER')
# );


SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO 
WHERE FISH_TYPE IN (
    SELECT FISH_TYPE
    FROM FISH_NAME_INFO 
    WHERE FISH_NAME IN ("BASS", "SNAPPER")
);