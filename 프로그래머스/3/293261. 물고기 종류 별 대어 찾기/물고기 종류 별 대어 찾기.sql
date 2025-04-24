-- 물고기 종류 별로 가장 큰 물고기의 ID, 물고기 이름, 길이를 출력하는 SQL 문을 작성해주세요.
-- 물고기의 ID 컬럼명은 ID, 이름 컬럼명은 FISH_NAME, 길이 컬럼명은 LENGTH로 해주세요.
-- 결과는 물고기의 ID에 대해 오름차순 정렬해주세요.
-- 단, 물고기 종류별 가장 큰 물고기는 1마리만 있으며 10cm 이하의 물고기가 가장 큰 경우는 없습니다.

select FISH_INFO.ID, FISH_NAME_INFO.FISH_NAME, FISH_INFO.LENGTH
from FISH_INFO 
    join FISH_NAME_INFO on FISH_INFO.FISH_TYPE = FISH_NAME_INFO.FISH_TYPE
    join ( -- 3개의 테이블 조인
        select FISH_TYPE, max(length) as MAX_LENGTH
        from FISH_INFO
        group by FISH_TYPE
    ) 
    as MAX_FISH on FISH_INFO.FISH_TYPE = MAX_FISH.FISH_TYPE and FISH_INFO.LENGTH = MAX_FISH.MAX_LENGTH
order by FISH_INFO.ID asc

# select FISH_TYPE, max(length) as MAX_LENGTH
#         from FISH_INFO
#         group by FISH_TYPE