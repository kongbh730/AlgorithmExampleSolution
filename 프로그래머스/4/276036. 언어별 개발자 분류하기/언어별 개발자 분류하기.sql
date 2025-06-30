-- GRADE가 존재하는 개발자의 GRADE, ID, EMAIL을 조회하는 SQL 문을 작성해 주세요.
-- 결과는 GRADE와 ID를 기준으로 오름차순 정렬해 주세요.
-- A : Front End 스킬과 Python 스킬을 함께 가지고 있는 개발자
-- B : C# 스킬을 가진 개발자
-- C : 그 외의 Front End 개발자

-- Python : 256
-- C# : 1024
-- Front End : JavaScript : 16, React : 2048, Vue : 8192

-- Python의 코드 찾기
# SELECT CODE FROM SKILLCODES WHERE NAME = 'Python'

-- C#의 코드 찾기
# SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#'

-- Front End 코드 찾기
# SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End'

-- 풀이
SELECT 
    (CASE 
    WHEN (SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End')) AND
        (SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'Python')) 
        THEN 'A'
    WHEN (SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#')) THEN 'B'
    WHEN (SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End')) THEN 'C'
    END) AS GRADE,
    ID, EMAIL
FROM DEVELOPERS 
GROUP BY GRADE, ID, EMAIL
HaVING GRADE IS NOT NULL
ORDER BY GRADE ASC, ID ASC;