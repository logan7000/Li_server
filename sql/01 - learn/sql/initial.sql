create
database `test`;
use
test;
drop table `user`;
create table `user`
(
    uid    bigint       not null unique auto_increment,
    `name` varchar(200) not null,
    age    smallint
);


#goods 商品表
drop table goods;

create table goods
(
    id    int unsigned unique auto_increment primary key,
    name  varchar(200),
    cpu   varchar(200),
    cat_id int unsigned,
    price int unsigned
);

insert into goods (name, price, cpu,cat_id)
values ('小米9', 1100, '850',1),
       ('小米10', 1100, '850',1),
       ('小米11', 1200, '855',2),
       ('红米12', 1300, '855',2),
       ('小米13', 1400, '850',3),
       ('红米8', 1400, '850',2),
       ('红米13', 1400, '850',1);



create table category (
    cat_id int unsigned auto_increment primary key ,
    cat_name varchar(20) comment '手机类型',
    parent_id  int unsigned
);
insert into category (cat_name, parent_id)
values
    ('手机类型',0),
    ('3G手机',1),
    ('4G手机',1),
    ('5G手机',1),
    ('手机配件',0),
    ('电池',5),
    ('摄像头',5);


drop table t_boy;

create table t_boy (
    id int unsigned auto_increment primary key,
    name varchar(20),
    mate_id int unsigned
);
insert into t_boy (name,mate_id)
values
    ('杨过',2),
    ('武大郎',3),
    ('猪八戒',1);

drop table  t_girl;
create table t_girl (
    id int unsigned auto_increment primary key,
    name varchar(20),
    meta_id int unsigned
);

insert into t_girl ( name,meta_id)
values
    ('嫦娥',1),
    ('小龙女',2),
    ('潘金莲',3);


create table t_temp (
    id int unsigned auto_increment primary key ,
    column1 TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    column2 DATETIME DEFAULT CURRENT_TIMESTAMP
)