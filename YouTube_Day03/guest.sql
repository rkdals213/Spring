-- no,writer,email,tel,pass,contents,wdate
-- 글번호, 작성자, 이메일, 전화번호, 비밀번호, 내용, 작성일자

-- guest.sql
drop table guest;

create table guest(
    no        int    primary key auto_increment,
    writer    varchar(20)  not null,
    email     varchar(30),
    tel       varchar(15),
    pass      varchar(20)  not null,
    contents  varchar(300) not null,
    wdate     date   
);



insert into guest (writer,email,tel,pass,contents,wdate) 
            values ('길동','gildong@naver.com','010-1123-4567','1234','내용',now());

insert into guest (writer,email,tel,pass,contents,wdate) 
            values ('길동','gildong@naver.com','010-1123-4567','1234','내용',now());
            
select * from guest;
