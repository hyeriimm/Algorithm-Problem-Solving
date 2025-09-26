select id , fish_name, length
from fish_info
natural join fish_name_info
where (fish_name, length) in
    (select fish_name, max(length) as length
    from fish_info i
    natural join fish_name_info n
    group by fish_name)
;