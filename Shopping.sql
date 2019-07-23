create database SHOPPING

use SHOPPING

create table DANHMUC (
    madm varchar(10),
    tendm varchar(30),
    primary key (madm)
)

create table SANPHAM (
    masp varchar(10),
    tensp varchar(30),
    gia integer,
    hinh varchar(30),
    madm varchar(10),
    primary key (masp),
    foreign key (madm) references DANHMUC(madm)
)

create table HOADON (
    mahd integer not null,
    ngaydh varchar(20),
    primary key(mahd)
)

create table CHITIETHOADON (
    mahd integer,
    masp varchar(10),
    soluong integer,
    foreign key (mahd) references HOADON(mahd),
    foreign key (masp) references SANPHAM(masp)
)

insert into DANHMUC 
values ('DM01', 'Apple')

insert into DANHMUC 
values ('DM02', 'Samsung')

insert into DANHMUC
values ('DM03', 'Asus')

insert into DANHMUC
values ('DM04', 'Razer')

insert into DANHMUC
values ('DM05', 'Nubia')

insert into SANPHAM
values ('APL01', 'iPhone 7', 500,'h1.png', 'DM01')

insert into SANPHAM
values ('APL02', 'iPhoneX', 1000, 'h2.png', 'DM01')

insert into SANPHAM
values ('APL03', 'iPhoneXs', 1149, 'h3.png', 'DM01')

insert into SANPHAM
values ('SS01', 'Samsung7Edge', 400,'h4.png', 'DM02')

insert into SANPHAM
values ('SS02', 'SamsungS8', 890, 'h5.png', 'DM02')

insert into SANPHAM
values ('SS03', 'SamsungS10Plus', 1300, 'h6.png', 'DM02')

insert into SANPHAM
values ('NB01', 'Nubia Gaming Phone', 1300, 'h7.png', 'DM05')

insert into SANPHAM
values ('RZ01', 'Razer Gaming Phone', 1250, 'h8.png', 'DM04')

insert into SANPHAM
values ('AS01', 'ROGPhone', 1500, 'h9.png', 'DM03')

------------------------------------------------------------------

create table [ROLE] (
    roleid int identity(1,1) not null,
    [role] varchar(30),
    primary key(roleid)
)

create table [USER] (
    userid int identity(1,1) not null,
    username varchar(30),
    [password] varchar(30),
    roleid int,
    primary key(userid),
    foreign key (roleid) references [ROLE](roleid)
)

create table USERDETAILS (
    userdetailsid int identity(1,1) not null,
    userfirstname varchar(15),
    userlastname varchar(30),
    dateofbirth date,
    gender varchar(7),
    userid int,
    primary key (userdetailsid),
    foreign key (userid) references [USER](userid)
)

create table ORDERHISTORY (
    orderid int identity(1,1) not null,
    dateorder date,
    cost int,
    userdetailsid int,
    primary key (orderid),
    foreign key (userdetailsid) references USERDETAILS(userdetailsid)
)

create table ORDERDETAILS (
    masp varchar(10),
    orderid int,
    soluong int,
    foreign key (orderid) references ORDERHISTORY(orderid),
    foreign key (masp) references SANPHAM(masp)
)

insert into [ROLE] ([role])
values ('admin')

insert into [ROLE] ([role])
values ('customer')

insert into [USER] (username, [password], roleid)
values ('hanryho1612', 'hoxuanhoa1612', 1)

insert into [USER] (username, [password], roleid)
values ('henryho1612', 'hoxuanhieu1612', 2)

insert into USERDETAILS (userfirstname, userlastname, dateofbirth, gender, userid) 
values ('Xuan Hoa', 'Ho', '04/09/1999', 'Male', 1)

insert into USERDETAILS (userfirstname, userlastname, dateofbirth, gender, userid) 
values ('Xuan Hieu', 'Ho', '12/16/1993', 'Male', 2)

select * from DANHMUC
select * from [ROLE]
select * from [USER]
select * from [USERDETAILS]
select * from ORDERHISTORY
select * from ORDERDETAILS
select * from CHITIETHOADON

-- Delete rows from table '[TableName]' in schema '[dbo]'
DELETE FROM [dbo].[ORDERHISTORY]
WHERE orderid = 6 or orderid = 7 or orderid = 8 or orderid = 9 or orderid = 10 or orderid = 11 or orderid = 12 or orderid = 13 or orderid = 14 or orderid = 15
GO