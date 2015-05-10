# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table employee (
  id                        integer not null,
  name                      varchar(255),
  age                       integer,
  constraint pk_employee primary key (id))
;

create table person (
  id                        varchar(255) not null,
  name                      varchar(255),
  constraint pk_person primary key (id))
;

create sequence employee_seq;

create sequence person_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists employee;

drop table if exists person;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists employee_seq;

drop sequence if exists person_seq;

