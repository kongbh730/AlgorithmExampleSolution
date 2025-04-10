-- HR_DEPARTMENT, HR_EMPLOYEES, HR_GRADE 테이블에서 from HR_DEPARTMENT, HR_EMPLOYEES, HR_GRADE
-- 2022년도 한해 평가 점수가 가장 높은 사원 정보를 조회하려 합니다. 2022년도 평가 점수가 가장 높은 사원들의 점수, 사번, 성명, 직책, 이메일을 조회하는 SQL문을 작성해주세요.
-- 2022년도의 평가 점수는 상,하반기 점수의 합을 의미하고, 평가 점수를 나타내는 컬럼의 이름은 SCORE로 해주세요.

select sum(HG.SCORE) as SCORE, HG.EMP_NO, HE.EMP_NAME, HE.POSITION, HE.EMAIL
from HR_GRADE HG join HR_EMPLOYEES HE on HG.EMP_NO = HE.EMP_NO
group by HG.EMP_NO
order by sum(HG.SCORE) desc
limit 1;