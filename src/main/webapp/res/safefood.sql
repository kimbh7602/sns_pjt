/*create database safefood;
use safefood;*/

create table food(
	code int primary key,
    name varchar(200) not null,
    supportpereat double,
    calory double,
    carbo double,
    protein double,
    fat double,
    sugar double,
    natrium double,
    chole double,
    fattyacid double,
    transfat double,
    maker varchar(200),
    material varchar(2000),
    img varchar(200),
    allergy varchar(500),
    searchCount int default 0
);

create table user (
	id varchar(200) primary key,
    password varchar(200) not null,
    mname varchar(200) not null,
    addr varchar(200) not null,
    tel varchar(200) not null,
    allergy varchar(1000),
    question varchar(200),
    answer varchar(200)
    );
    

create table notice (
	nid int primary key auto_increment,
    ntitle varchar(200),
    ncontent varchar(2000),
    ncount int default 0
);

create table board (
	bid int primary key auto_increment,
    user_id varchar(200) not null,
    btitle varchar(200),
    bcontent varchar(2000),
    bcount int default 0,
    foreign key (user_id) references user (id)
);

create table intake (
	code int,
    id varchar(200),
	idate date,
    icount int default 0
);



alter table intake add constraint pk_intake primary key (code, id, idate);
alter table intake add constraint fk_intake_user foreign key (id) references user(id);
alter table intake add constraint fk_intake_food foreign key (code) references food(code);

/*select * from food;
select * from intake;
select * from intake where idate = current_date();
select icount from intake where code=3 and id='a@a.a' and idate = current_date();

select f.*, i.icount from food as f join intake as i using(code) where i.id = 'a@a.a';
select sum(f.calory*i.icount), sum(f.carbo*i.icount) from food as f join intake as i using(code) where i.id = 'a@a.a';*/