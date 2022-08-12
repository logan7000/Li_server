drop table student;

create table student (
    `name` varchar(20) not null,
    lesson varchar(20) not null ,
    score int unsigned
);


select * from student;

insert into student (name,lesson,score)
values
    ('张三','地理',30),
    ('张三','化学',60),
    ('张三','生物',40),
    ('张四','数学',30),
    ('张四','语文',130),
    ('张四','英语',110);

select * from student;

# 查看每一个人的挂科情况
select * from student where score < 60;
#  查看每个人的挂科情况，表达式`score<60`返回0和1
select name,score <60  from student;
# 计算每一人的挂科数目
select name,sum(score<60) from student group by name;
# 计算每一人的平均分
select name,avg(score) avg_score from student group by name;
# 筛选挂科2门及以上的
#  利用having在 查询得到的内存数据进行再次过滤
select name,sum(score<60) under_perform,avg(score) from student group by name  having under_perform >= 2;
