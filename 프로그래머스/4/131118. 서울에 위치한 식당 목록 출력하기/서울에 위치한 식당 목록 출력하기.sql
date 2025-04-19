select rest_id, rest_name, food_type, favorites, address, round(score, 2) score
from rest_info
natural join (
    select rest_id, avg(review_score) as score
    from rest_review
    group by rest_id
) as rest_score
where address like '서울%'
order by score desc, favorites desc
;
