-- 코드를 작성해주세요

-- FISH_NAME_INFO에서 물고기의 종류 별 물고기의 이름과 잡은 수를 출력하는 SQL문을 작성해주세요.
-- 물고기의 이름 컬럼명은 FISH_NAME, 잡은 수 컬럼명은 FISH_COUNT로 해주세요.
-- 결과는 잡은 수 기준으로 내림차순 정렬해주세요.

# select count(*) as FISH_COUNT, 
#     (
#         select FISH_NAME 
#         from FISH_NAME_INFO 
#         where FISH_NAME_INFO.FISH_TYPE = FISH_INFO.FISH_TYPE
#     ) as FISH_NAME
# from FISH_INFO 
# group by FISH_TYPE
# order by FISH_COUNT desc;

# select 
#     COUNT(FI.FISH_TYPE) AS FISH_COUNT,
#     FNI.FISH_NAME AS FISH_NAME
# from FISH_INFO FI
# join FISH_NAME_INFO FNI on FI.FISH_TYPE = FNI.FISH_TYPE
# group by FNI.FISH_NAME
# order by FISH_COUNT desc;

SELECT COUNT(FI.FISH_TYPE) AS FISH_COUNT, FNI.FISH_NAME
FROM FISH_INFO FI JOIN FISH_NAME_INFO FNI ON FI.FISH_TYPE = FNI.FISH_TYPE
GROUP BY FNI.FISH_NAME
ORDER BY FISH_COUNT DESC