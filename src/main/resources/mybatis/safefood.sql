use safefood;

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
    allergy varchar(500)
);
create table board(
	bid int primary key auto_increment,
    user_id varchar(200) not null,
    btitle varchar(200),
    bcontent varchar(2000),
    bcount int default 0,
    foreign key(user_id) references user(id)
);
drop table recipeboard;
create table recipeboard(
	rbid int primary key auto_increment,
    user_id varchar(200),
    rbtitle varchar(200),
    rbcontent varchar(2000),
    rbcount int default 0,
    foreign key(user_id) references user(id)
);
select * from user;
insert into recipeboard (user_id, rbtitle, rbcontent)
values ('a@a.a','22','22');
create table upload_file(
	fileId int primary key auto_increment, 
    contentType varchar(100),
    fileName varchar(200),
    filePath varchar(200),
    regDate varchar(200),
    saveFileName varchar(300),
    size int
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
   
   create table board (
	bid int primary key auto_increment,
    user_id varchar(200) not null,
    btitle varchar(200),
    bcontent varchar(2000),
    bcount int default 0,
    foreign key (user_id) references user (id)
);

insert into notice (ntitle, ncontent) values ('제목2', '내용2');

create table intake (
	code int,
    id varchar(200),
    idate date,
    icount int default 0
);

alter table intake add constraint pk_intake primary key (code, id,idate);
alter table intake add constraint fk_intake_user foreign key (id) references user(id);
alter table intake add constraint fk_intake_food foreign key (code) references food(code);