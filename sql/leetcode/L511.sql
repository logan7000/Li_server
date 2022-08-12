--  用完了记得销毁，免得其他题目中影响
drop table Activity;



create table Activity
(
    player_id    int,
    device_id    int,
    event_date   date,
    games_played int
);

insert into Activity (player_id, device_id, event_date, games_played) values (1,2,'2016-03-01',5);
insert into Activity (player_id, device_id, event_date, games_played) values (1,2,'2016-03-01',6);
insert into Activity (player_id, device_id, event_date, games_played) values (2,1,'2016-03-01',0);
insert into Activity (player_id, device_id, event_date, games_played) values (2,2,'2016-03-01',1);
insert into Activity (player_id, device_id, event_date, games_played) values (3,4,'2016-03-01',7);

#  每一位玩家的第一个登录日期
select player_id,min(event_date) as first_login from Activity group by player_id;

# 请编写一个 SQL 查询，描述每一个玩家首次登陆的设备名称
#  做一个子查询
select player_id , device_id
from Activity
where (player_id,event_date) in (
    select player_id,min(event_date) from Activity group by player_id
);

select games_played - Activity.device_id as s from Activity where s>Activity.device_id;