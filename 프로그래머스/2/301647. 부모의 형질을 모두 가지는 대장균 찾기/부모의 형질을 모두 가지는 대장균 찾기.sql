-- 코드를 작성해주세요

-- 부모의 형질을 모두 보유한 where GENOTYPE & (select GENOTYPE from ECOLI_DATA where ID = PARENT_ID) > 0
-- 대장균의 ID(ID), 대장균의 형질(GENOTYPE), 부모 대장균의 형질(PARENT_GENOTYPE)을 출력하는 SQL 문을 작성해주세요.  select ID, GENOTYPE, PARENT_GENOTYPE
-- 이때 결과는 ID에 대해 오름차순 정렬해주세요. order by ID

-- 직계부모만 검사
-- 부모의 GENOTYPE을 추출해서, & 연산 결과가 0보다 큼

select E.ID, E.GENOTYPE, P.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA E
join ECOLI_DATA P on E.PARENT_ID = P.ID
where (E.GENOTYPE & P.GENOTYPE) = P.GENOTYPE
order by E.ID;