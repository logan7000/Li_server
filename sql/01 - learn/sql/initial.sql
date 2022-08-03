
create database `test`;
use test;


drop table `user`;

create table `user`
(
    uid bigint not null unique auto_increment,
    `name` varchar(200) not null,
    age smallint
);

select * from user;

insert into user (uid, name, age)
values (3,'lisi',28);

insert into user(name,age) values ('poly','1');

select * from user where uid = 1;

update user set age = 2 where age = 1;

delete from user where uid = 1;
