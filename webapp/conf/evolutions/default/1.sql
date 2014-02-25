# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table client (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  phone                     varchar(255),
  address                   varchar(255),
  create_at                 datetime,
  tax_nr                    integer,
  support_name              varchar(255),
  support_pass              varchar(255),
  chef_name                 varchar(255),
  chef_email                varchar(255),
  chef_phone                varchar(255),
  constraint pk_client primary key (id))
;

create table project (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  client_id                 bigint,
  start_at                  datetime,
  end_at                    datetime,
  is_active                 tinyint(1) default 0,
  is_deleted                tinyint(1) default 0,
  constraint pk_project primary key (id))
;

create table task (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  is_done                   tinyint(1) default 0,
  due_date                  datetime,
  assign_to_email           varchar(255),
  project_id                bigint,
  folder                    varchar(255),
  constraint pk_task primary key (id))
;

create table account (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  is_active                 tinyint(1) default 0,
  avatar                    varchar(255),
  constraint pk_account primary key (email))
;

alter table project add constraint fk_project_client_1 foreign key (client_id) references client (id) on delete restrict on update restrict;
create index ix_project_client_1 on project (client_id);
alter table task add constraint fk_task_assignTo_2 foreign key (assign_to_email) references account (email) on delete restrict on update restrict;
create index ix_task_assignTo_2 on task (assign_to_email);
alter table task add constraint fk_task_project_3 foreign key (project_id) references project (id) on delete restrict on update restrict;
create index ix_task_project_3 on task (project_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table client;

drop table project;

drop table task;

drop table account;

SET FOREIGN_KEY_CHECKS=1;

