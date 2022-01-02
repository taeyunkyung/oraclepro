-- phonedb 계정/비번/권한 만들기
create user phonedb identified by phonedb;
grant resource, connect to phonedb;

-- 테이블 삭제
drop table person;

-- 시퀀스 삭제
drop sequence seq_person_id;

-- 테이블 생성 
create table person(
    person_id   number(5),
    name        varchar2(30) not null,
    hp          varchar2(20),
    company     varchar2(20),
    primary key(person_id)
);

-- 시퀀스 생성
create sequence seq_person_id
increment by 1
start with 1
nocache;

-- insert문
insert into person
values(seq_person_id.nextval, '이효리', '010-1111-1111', '02-1111-1111');

-- select문
select  person_id,
        name,
        hp,
        company
from person
order by person_id asc;

select  person_id,
        name,
        hp,
        company
from person
where (name || hp || company) like '%유%'
order by person_id asc;

-- update문
update person
set name = '이정재',
    hp = '010-9999-9999',
    company = '02-9999-9999'
where person_id = 4;

-- delete문
delete from person
where person_id = 5;