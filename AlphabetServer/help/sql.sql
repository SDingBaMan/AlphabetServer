

CREATE DATABASE Alphabet DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE DATABASE Alphabet character set utf8;

create table UserLogin(
	ULId varchar(200) not null,
	ULpassword varchar(250),
	primary key (ULId),
	foreign key(ULId) references UserMan(UMId)
);

/*
成员表

  UMId varchar(200) not null;
  username varchar(200),

*/
create table UserMan(
	UMId varchar(200) not null,
	username varchar(200),
	nickName varchar(200),
	phone varchar(50),
	mail varchar(50),
	age varchar(10),
	sex int,
	state int,
	fifter int,
	primary key(UMId)
);

/**
 好友成员表
 userId varchar(200) not null,
 friendId varchar(200),
*/
create table FriendUser(
	FId int auto_increment,
	userId varchar(200) not null,
	friendId varchar(200),
	primary key(FId),
	foreign key(userId) references UserMan(UMId),
	foreign key(userId) references UserMan(UMId)
);

/*
   发送消息的表
  ReciveId varchar(200) not null,
	SendId varchar(200),
*/
create table Sendqq(
	SQId int auto_increment,
	ReciveId varchar(200) not null,
	SendId varchar(200),
	title varchar(100),
	datetime date,
	primary key (SQId),
	foreign key(ReciveId) references UserMan(UMId),
	foreign key(SendId) references UserMan(UMId)
) ;

/*
   好友留言表n
   ReciveId varchar(200) not null,
	 SendId varchar(200) ,
*/
create table SendMessage(
	SMId int auto_increment,
	ReciveId varchar(200) not null,
	SendId varchar(200) ,
	title varchar(100),
	content varchar(700),
	state bool,
	datetime date,
	primary key(SMId),
	foreign key(ReciveId) references UserMan(UMId),
	foreign key(SendId) references UserMan(UMId)
);

/*
   消息分享表
   Send  -->  UserId varchar(200)
*/
create table messageShare(
	MSId int auto_increment,

	UserId varchar(200),

	title varchar(100),
	content varchar(1000),
	datetime date,
	primary key(MSId),
	foreign key(UserId) references UserMan(UMId)
);

/*
  新闻数据表
*/
create table News(
	NId int auto_increment,
	title varchar(100),
	content varchar(700),
	datetime date,
	primary key(NId)
);

/*
  用户存储数据表

  List === UserId varchar(200) not null,

*/
create table UserData(
	UDId int auto_increment,
	UserId varchar(200) not null,
	dataNumber int,
	SurplusNumber int,
	datetime date,
	primary key(UDId),
	foreign key(UserId) references UserMan(UMId)
);

/*
 	TimeNum : 设定的戒烟时间
	设置表
	List===>UserId varchar(100),

*/
create table Settings(

  /*int -- setNumber  --> 第几次设置戒烟次数了。*/

	SId varchar(50),
	UserId varchar(100),
	TimeNum varchar(100) not null,
	setNumber varchar(20) not null,
	BeginDatetime date,
	EndDatetime date,
	primary key(SId),
	foreign key(UserId) references UserMan(UMId)
);


/*
   具体设置时间 分配 表
   List --> SetId varchar(50),
   SetNum --  》 第几次设置戒烟次数了。 对应settings的setNumber

*/
create table UUIDSetDate(
	UUIDId int auto_increment,
	SetId varchar(50),
	SetNum varchar(20),
	TimeCyc varchar(50),
	TimeOrder int,
	YanNumber varchar(50),
	primary key(UUIDId),
	foreign key(SetId) references Settings(sid)
);

/*
   平均数目表
   	Mouth varchar(10),
*/
create table AllDataAge(
	ADId int auto_increment,
	Mouth varchar(10),
	Day varchar(10),
	SurplusNumber varchar(30),
	primary key(ADId)
);
/*
   平均数目表
   	Mouth varchar(10),
*/
create table AllDataAge(
	ADId int auto_increment,
	Mouth varchar(10),
	SurplusNumber varchar(30),
	primary key(ADId)
);

/************************************************************************************************/
/************************************************************************************************/
/************************************************************************************************/
/************************************************************************************************/
/************************************************************************************************/





