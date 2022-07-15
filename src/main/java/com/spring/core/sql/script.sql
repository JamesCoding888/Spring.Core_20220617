-- 建立 Emp 資料表
create table  if not exists emp (
	eid int not null auto_increment, -- 主鍵
	ename varchar(30) not null unique, -- 員工姓名
	age int, -- 員工年齡
	createtime timestamp default current_timestamp, -- 建檔時間
	primary key (eid)
);

-- 建立 job 資料表 
create table if not exists job (
	jid int not null auto_increment, -- 主鍵
	jname varchar(50) not null, -- 工作名稱
	eid int, -- 員工 id
	primary key(jid),
	foreign key(eid) references emp(eid) -- 外鍵關聯
	
);

-- 建立初始數據
insert into emp(ename, age) values ('A01', 21);
insert into emp(ename, age) values ('A02', 22);
insert into emp(ename, age) values ('A03', 23);
insert into emp(ename, age) values ('A04', 24);
insert into emp(ename, age) values ('A05', 25);
insert into emp(ename, age) values ('A06', 26);
insert into emp(ename, age) values ('A07', 27);
insert into emp(ename, age) values ('A08', 28);
insert into emp(ename, age) values ('A09', 29);
insert into emp(ename, age) values ('A10', 30);
insert into emp(ename, age) values ('A11', 31);
insert into emp(ename, age) values ('A12', 32);
insert into emp(ename, age) values ('A13', 33);

insert into job(jname, eid) values ('report', 1);
insert into job(jname, eid) values ('coding', 3);
insert into job(jname, eid) values ('jobA', 3);
insert into job(jname, eid) values ('jobB', 4);
insert into job(jname, eid) values ('jobC', 7);
insert into job(jname, eid) values ('jobD', 12);
insert into job(jname, eid) values ('jobE', 13);
insert into job(jname, eid) values ('jobF', 1);
insert into job(jname, eid) values ('jobG', 1);
insert into job(jname, eid) values ('jobH', 3);
insert into job(jname, eid) values ('jobI', 12);
insert into job(jname, eid) values ('jobJ', 7);
insert into job(jname, eid) values ('jobK', 4);
insert into job(jname, eid) values ('jobL', 3);
insert into job(jname) values ('jobM');
insert into job(jname) values ('jobN');

-- 每一個有工作指派的員工之工作列表
select e.ename , j.jname
from emp e, job j
where e.eid = j.eid 
order by e.ename ;

-- 每一個員工有幾項工作 (交集) - 1 ？
select e.ename, count(j.jname)
from emp e inner join job j on e.eid = j.eid 
group by e.ename  
order by e.ename ;

-- 每一個員工有幾項工作 (交集) - 2 ？
select e.ename, count(j.jname) as total
from emp e, job j
where e.eid = j.eid 
group by e.ename 
order by e.ename;

-- 每一個員工有幾項工作 (left join 向左關聯) - 3 ？
select e.ename, count(j.jname) as total
from emp e left join job j on e.eid = j.eid 
group by e.ename 
order by e.ename;

-- 沒有工作的員工
select e.ename
from emp e left join job j on e.eid = j.eid 
where j.eid is NULL ;

-- 沒有員工的工作
select j.jname
from emp e right join job j on e.eid = j.eid
where j.eid is null;

select j.jname
from job j
where j.eid is null;


--------------------------------- 20220715 script --------------------------------- 

select e.eid, e.ename, e.age, e.createtime, 
	   j.jid, j.jname, j.eid from emp e left join job j on j.eid = e.eid;


select j.jid, j.jname, j.eid from job j;

select e.eid, e.ename, e.age, e.createtime, 
	   j.jid as job_jid, j.jname as job_jname, j.eid as job_eid from emp e left join job j on j.eid = e.eid;
       
       
select j.jid, j.jname, j.eid, e.eid, e.ename, e.age, e.createtime from job j left join emp e on e.eid = j.eid;


select j.jid, j.jname, j.eid, e.eid as emp_eid, e.ename as emp_ename, e.age as emp_age, e.createtime as emp_createtime 
	from job j left join emp e on e.eid = j.eid;

	
-- book (書籤資料), stock (庫存資料), wallet (客戶雲端錢包)
-- 建立 book (書籤資料）表
create table if not exists book(
	bid integer not null auto_increment,
	bname varchar(20) not null,
	price integer default 0,
	ct timestamp default current_timestamp,
	primary key( bid )
);

-- 建立 stock(庫存資料) 表
create table if not exists stock(
	sid integer not null auto_increment,
	bid integer not null, -- book 的 bid
	amount integer default 0,
	primary key (sid),
	foreign key(bid) references book(bid), -- 外鍵關聯
);

-- 建立 wallet (客戶雲端錢包) 表
create table if not exists wallet(
	wid integer not null auto_increment,
	wname varchar(20) not null,
	money integer default 0,
	primary key (wid)
);








