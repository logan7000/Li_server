#  where group by, having; order by; limit;
select * from goods;

# 查出最新的商品
select * from goods order by id desc limit 1;
# 利用子查询，max查询出最大的id,然后基于id进行查询
select * from goods where id = (select max(id) from goods);
# 利用子查询，max多个不同cat_id里面的最新的
select * from goods where id in (select max(id) from goods group by cat_id);

select * from category;