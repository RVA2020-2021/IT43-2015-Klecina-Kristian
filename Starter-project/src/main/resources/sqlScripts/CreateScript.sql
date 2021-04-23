drop table if exists fakultet cascade;
drop table if exists status cascade;
drop table if exists student cascade;
drop table if exists departman cascade;

DROP SEQUENCE IF EXISTS fakultet_seq;
DROP SEQUENCE IF EXISTS status_seq;
DROP SEQUENCE IF EXISTS student_seq;
DROP SEQUENCE IF EXISTS departman_seq;


create table fakultet(
	id integer not null,
	naziv varchar(100),
	sediste varchar(50)
);

create table status(
	id integer not null,
	naziv varchar(100),
	oznaka varchar(10)
);

create table departman(
	id integer not null,
	naziv varchar(100),
	oznaka varchar(50),
	fakultet integer not null
);

create table student(
	id integer not null,
	ime varchar(50),
	prezime varchar(50),
	broj_indeksa varchar(20),
	status integer not null,
	departman integer not null
);

alter table fakultet add constraint pk_fakultet primary key(id);
alter table departman add constraint pk_departman primary key(id);
alter table status add constraint pk_status primary key(id);
alter table student add constraint pk_student primary key(id);

alter table departman add constraint fk_departman_fakultet foreign key(fakultet) REFERENCES fakultet(id);
alter table student add constraint fk_student_departman foreign key(departman) REFERENCES departman(id);
alter table student add constraint fk_student_status foreign key(status) REFERENCES status(id);

create index idxpk_fakultet on fakultet(id);
create index idxpk_departman on departman(id);
create index idxpk_status on status(id);
create index idxpk_student on student(id);

create index idxfk_departman_fakultet on departman(fakultet);
create index idxfk_student_departman on student(departman);
create index idxfk_student_status on student(status);


CREATE SEQUENCE fakultet_seq
INCREMENT 1;
CREATE SEQUENCE status_seq
INCREMENT 1;
CREATE SEQUENCE student_seq
INCREMENT 1;
CREATE SEQUENCE departman_seq
INCREMENT 1;


