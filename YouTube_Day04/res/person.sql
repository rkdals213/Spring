-- no,name,age,job
-- 번호, 이름, 나이, 직업

-- person.sql
drop table person;

create table person(
    no        int    primary key auto_increment,
    name      varchar(20)  not null,
    age       int          not null,
    job       varchar(30)  not null
);



