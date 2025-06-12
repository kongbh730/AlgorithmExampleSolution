-- MEMBER_PROFILE와 REST_REVIEW 테이블에서 
-- 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회하는 SQL문을 작성해주세요. 
-- 회원 이름, 리뷰 텍스트, 리뷰 작성일이 출력되도록 작성해주시고, 
-- 결과는 리뷰 작성일을 기준으로 오름차순, 리뷰 작성일이 같다면 리뷰 텍스트를 기준으로 오름차순 정렬해주세요.

select MP.MEMBER_NAME, RR.REVIEW_TEXT, date_format(RR.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from MEMBER_PROFILE MP join REST_REVIEW RR on MP.MEMBER_ID = RR.MEMBER_ID
where MP.MEMBER_ID = (
    select MEMBER_ID
    from REST_REVIEW
    group by MEMBER_ID
    order by count(*) desc
    limit 1
)
order by RR.REVIEW_DATE asc, RR.REVIEW_TEXT asc;