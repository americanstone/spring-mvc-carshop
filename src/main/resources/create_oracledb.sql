drop table cost_details;
drop table images;
drop table requests;
drop table user_car;
drop table cars;
drop table repair;
drop table repair_jobs;
drop table garages;
drop table user_address;
drop table address;
drop table expertise;
drop table category;
drop table users;



create table users
(
    username varchar(50),
    password varchar(20),
    fname varchar(10),
    lname varchar(10),
    role varchar(10),
    primary key(username),
    constraint role_constraint check(role in ('customer','employee'))
);

create table address(
	address_id	number,
	address1	varchar(100),
	address2	varchar(100),
	city		varchar(40),
	country		varchar(40),
	phone		varchar(20),
	primary key(address_id)
);
drop sequence ADDRESS_SEQ;
create sequence ADDRESS_SEQ
minvalue 1
maxvalue 999999999999999999
start with 20
increment by 1
cache 20;

create table user_address(
	username	varchar(50),
	address_id	number,
	primary key(username,address_id),
	foreign key(username) references users(username),
	foreign key(address_id) references address(address_id)
);

create table garages(
	gid int,
	name varchar(20),
	description varchar(300),
	address_id int,
	primary key(gid),
	foreign key(address_id) references address(address_id)
);
drop sequence GARAGES_SEQ;
create sequence GARAGES_SEQ
minvalue 1
maxvalue 999999999999999999
start with 20
increment by 1
cache 20;

create table category
(	
	cid int, 
	name varchar(50),
	username varchar(50),
	primary key(cid),
	foreign key(username) references users(username),
	constraint category_constraint check(name in('brake', 'transmission', 'engine', 'window', 'body', 'tire', 'panel', 'battery electrical','exhaust muffler', 'Fluids, Heat Air Conditioning'))
);

create table expertise
(
	cid int, 
	username varchar(50),
	foreign key(cid) references category(cid),
	foreign key(username) references users(username)
);

create table repair_jobs
(
	rid int,
	status char(10),
	name varchar(50),
	description varchar(500),
	cid int,
	starttime date,
	completetime date,
	estimatedcost float,
	estimateddays int,
	comments varchar(500),
	primary key (rid),
	constraint status_constraint check(status in ('new','processing','completed')),
	foreign key(cid) references category(cid)
);
drop sequence REPAIR_SEQ;
create sequence REPAIR_SEQ
minvalue 1
maxvalue 999999999999999999
start with 20
increment by 1
cache 20;

create table repair
(	
	gid int, 
	rid int,
	foreign key(gid) references garages(gid),
	foreign key(rid) references repair_jobs(rid)
);

create table cars
(
	platenumber varchar(10),
	make varchar(20),
	model varchar(20),
	image varchar(100),
	vin varchar(50),
	cartype varchar(15),
	year date,
	primary key(platenumber),
	constraint cartype_constraint check(cartype in ('SUV', 'sedan', 'van', 'pickup', 'convertible','wagon','minivan', 'coupe'))
);

create table requests
(
	rid int,
	username varchar(50),
	platenumber varchar(10),
	personincharge varchar(50),
	foreign key (rid) references repair_jobs(rid),
	foreign key (username) references users(username),
	foreign key (personincharge) references users(username),
	foreign key (platenumber) references cars(platenumber)
);

create table images
(
	imageid int, 
	path varchar(100),
	rid int,
	primary key(imageid),
	foreign key (rid) references repair_jobs(rid)
);

drop sequence IMAGE_SEQ;
create sequence IMAGE_SEQ
minvalue 1
maxvalue 999999999999999999
start with 20
increment by 1
cache 20;

create table cost_details
(
	item varchar(30),
	description varchar(100),
	unitprice float,
	amount float,
	rid int,
	foreign key(rid) references repair_jobs(rid)
);

create table user_car
(
	username varchar(50),
	platenumber varchar(10),
	foreign key(username) references users(username),
	foreign key(platenumber) references cars(platenumber)
);




