## 数据库

#### 创建数据库

```mysql
CREATE DATABASE `li_server` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
```

#### 删除数据库

```mysql
drop database `task_app`
```

## 表

#### 创建一个新的表结构
```mysql
create table t_task
(
    id          int          not null  primary key,
    title       varchar(200) not null comment '任务标题',
    description varchar(400) null comment '任务详细描述'
);

```
#### 修改表