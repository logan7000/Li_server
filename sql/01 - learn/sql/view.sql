select * from goods;

create view v2goods as select id,name,price from goods;

select * from v2goods;

select cat_id,avg(price) as pj from goods group by cat_id;

create view v2_avage_goods as
select cat_id,avg(price) as pj from goods group by cat_id;

select * from v2_avage_goods;
update v2_avage_goods set pj = 890 where cat_id = 1;

update goods
set name =  'new'
where id=8;

update v2goods set name = '小米1' where id = 8;




create table user3 (
    id int,
    name varchar(20)
);

explain select * from user3;