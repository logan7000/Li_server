select *
from t_boy
         left join t_girl tg on t_boy.id = tg.meta_id;

select * from t_boy right join  t_girl tg on t_boy.id = tg.meta_id;