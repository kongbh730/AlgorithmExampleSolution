-- 코드를 작성해주세요

-- DEVELOPERS 테이블에서 from DEVELOPERS
-- Python이나 C# 스킬을 가진 개발자의 정보를 조회하려 합니다. in ('Python', 'C#')
-- 조건에 맞는 개발자의 ID, 이메일, 이름, 성을 조회하는 SQL 문을 작성해 주세요. select ID, EMAIL, FIRST_NAME, LAST_NAME
-- 결과는 ID를 기준으로 오름차순 정렬해 주세요. order by ID asc

-- select * from DEVELOPERS;
-- select CODE from SKILLCODES where NAME in ('Python', 'C#');

# select ID, EMAIL, FIRST_NAME, LAST_NAME
# from DEVELOPERS 
# where SKILL_CODE & (
#     SELECT SUM(CODE) FROM SKILLCODES WHERE NAME IN ('Python', 'C#')
# )
# order by ID asc;

# SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
# FROM DEVELOPERS
# -- 둘이 외래키참조방식이 아니라 JOIN은 사용 불가
# WHERE SKILL_CODE & (
#     SELECT SUM(CODE)
#     FROM SKILLCODES
#     WHERE NAME IN ("Python", "C#")
# )
# ORDER BY ID ASC;

SELECT DISTINCT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPERS D
JOIN SKILLCODES S 
ON (D.SKILL_CODE & S.CODE) = S.CODE
WHERE S.NAME IN ("C#", "Python")
ORDER BY D.ID ASC;