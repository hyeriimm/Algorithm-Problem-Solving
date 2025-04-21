select flavor
from first_half
natural join icecream_info
where ingredient_type = 'fruit_based'
and total_order > 3000
order by total_order desc
;