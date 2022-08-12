# limit [偏移量],[容量]

# 取出前3名商品
select *
from goods
limit 0,3;
# 取出4，5名商品
select *
from goods
limit 3,2;

# 取出最新的商品
select *
from goods
order by id desc
limit 0,1;
