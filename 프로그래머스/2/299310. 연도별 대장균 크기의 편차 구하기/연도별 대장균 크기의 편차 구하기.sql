-- 코드를 작성해주세요

-- 분화된 연도(YEAR), 분화된 연도별 대장균 크기의 편차(YEAR_DEV), 대장균 개체의 ID(ID) 를 출력하는 SQL 문을 작성해주세요. 
-- 분화된 연도별 대장균 크기의 편차는 분화된 연도별 가장 큰 대장균의 크기 - 각 대장균의 크기로 구하며 결과는 연도에 대해 오름차순으로 정렬하고 같은 연도에 대해서는 대장균 크기의 편차에 대해 오름차순으로 정렬해주세요.

select year(E.DIFFERENTIATION_DATE) as year, 
(M.max_size - E.SIZE_OF_COLONY) as YEAR_DEV, 
E.ID
from ECOLI_DATA E
join (
    select year(DIFFERENTIATION_DATE) as year, max(SIZE_OF_COLONY) as max_size
    from ECOLI_DATA
    group by year(DIFFERENTIATION_DATE) 
) M on year(DIFFERENTIATION_DATE) = M.year
order by year(DIFFERENTIATION_DATE) asc, YEAR_DEV asc;
