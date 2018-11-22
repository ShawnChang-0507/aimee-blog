drop table if exists action;

drop table if exists address;

drop table if exists article;

drop table if exists article_group;

drop table if exists article_public;

drop table if exists article_state;

drop table if exists assist;

drop table if exists attention;

drop table if exists blog_level;

drop table if exists discuss;

drop table if exists info;

drop table if exists integral;

drop table if exists level_group;

drop table if exists login_info;

drop table if exists read_log;

drop table if exists read_state;

drop table if exists role;

drop table if exists role_action;

drop table if exists source;

drop table if exists visitor;

drop table if exists visitor_role;

drop table if exists visitor_state;

/*==============================================================*/
/* Table: action                                                */
/*==============================================================*/
create table action
(
   action_id            int not null auto_increment,
   name                 varchar(15),
   primary key (action_id)
);

/*==============================================================*/
/* Table: address                                               */
/*==============================================================*/
create table address
(
   address_id           int not null auto_increment,
   parent_address_id    int,
   address              varchar(20),
   primary key (address_id)
);

/*==============================================================*/
/* Table: article                                               */
/*==============================================================*/
create table article
(
   article_id           int not null auto_increment,
   article_state_id     int,
   article_public_id    int,
   author_id            int,
   source_id            int,
   article_group_id     int,
   article_title        varchar(30),
   article_content      text,
   create_date          datetime,
   second_title         varchar(30),
   primary key (article_id)
);

/*==============================================================*/
/* Table: article_group                                         */
/*==============================================================*/
create table article_group
(
   article_group_id     int not null auto_increment,
   visitor_id           int,
   name                 varchar(20),
   create_date          datetime,
   primary key (article_group_id)
);

/*==============================================================*/
/* Table: article_public                                        */
/*==============================================================*/
create table article_public
(
   article_public_id    int not null auto_increment,
   name                 varchar(10),
   primary key (article_public_id)
);

/*==============================================================*/
/* Table: article_state                                         */
/*==============================================================*/
create table article_state
(
   article_state_id     int not null auto_increment,
   name                 varchar(10),
   primary key (article_state_id)
);

/*==============================================================*/
/* Table: assist                                                */
/*==============================================================*/
create table assist
(
   assist_id            int not null auto_increment,
   article_id           int,
   discuss_id           int,
   visitor_id           int,
   create_date          datetime,
   primary key (assist_id)
);

/*==============================================================*/
/* Table: attention                                             */
/*==============================================================*/
create table attention
(
   attention_id         int not null auto_increment,
   owner_visitor_id     int,
   attention_visiton_id int,
   create_date          datetime,
   primary key (attention_id)
);

/*==============================================================*/
/* Table: blog_level                                            */
/*==============================================================*/
create table blog_level
(
   blog_level_id        int not null auto_increment,
   level_group_id       int,
   name                 varchar(15),
   integral             char(10),
   primary key (blog_level_id)
);

/*==============================================================*/
/* Table: discuss                                               */
/*==============================================================*/
create table discuss
(
   discuss_id           int not null auto_increment,
   visitor_id           int,
   article_id           int,
   parent_discuss_id    int,
   read_state_id        int,
   content              varchar(250),
   primary key (discuss_id)
);

/*==============================================================*/
/* Table: info                                                  */
/*==============================================================*/
create table info
(
   info_id              int not null auto_increment,
   visitor_id           int,
   address_id           int,
   real_name            varchar(20),
   sex                  int,
   birthday             datetime,
   email                varchar(40),
   QQ                   varchar(20),
   wechar_pay           varchar(300),
   wechar_friend        varchar(300),
   ali_pay              varchar(300),
   ali_friend           varchar(300),
   telphone             varchar(20),
   primary key (info_id)
);

/*==============================================================*/
/* Table: integral                                              */
/*==============================================================*/
create table integral
(
   integral_id          int not null auto_increment,
   visitor_id           int,
   level_group_id       int,
   value                int,
   primary key (integral_id)
);

/*==============================================================*/
/* Table: level_group                                           */
/*==============================================================*/
create table level_group
(
   level_group_id       int not null auto_increment,
   name                 varchar(20),
   primary key (level_group_id)
);

/*==============================================================*/
/* Table: login_info                                            */
/*==============================================================*/
create table login_info
(
   login_info_id        int not null auto_increment,
   visitor_id           int,
   login_time           datetime,
   ip                   varchar(15),
   primary key (login_info_id)
);

/*==============================================================*/
/* Table: read_log                                              */
/*==============================================================*/
create table read_log
(
   read_log_id          int not null auto_increment,
   article_id           int,
   visitor_id           int,
   create_date          datetime,
   primary key (read_log_id)
);

/*==============================================================*/
/* Table: read_state                                            */
/*==============================================================*/
create table read_state
(
   read_state_id        int not null auto_increment,
   name                 varchar(8),
   primary key (read_state_id)
);

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   role_id              int not null auto_increment,
   name                 varchar(15),
   primary key (role_id)
);

/*==============================================================*/
/* Table: role_action                                           */
/*==============================================================*/
create table role_action
(
   role_action_id       int not null auto_increment,
   role_id              int,
   action_id            int,
   primary key (role_action_id)
);

/*==============================================================*/
/* Table: source                                                */
/*==============================================================*/
create table source
(
   source_id            int not null auto_increment,
   name                 varchar(10),
   primary key (source_id)
);

/*==============================================================*/
/* Table: visitor                                               */
/*==============================================================*/
create table visitor
(
   visitor_id           int not null auto_increment,
   visitor_state_id     int,
   login_name           varchar(20),
   login_password       varchar(20),
   salt                 varchar(100),
   nick_name            varchar(20),
   create_date          datetime,
   manifesto            varchar(300),
   introduction         varchar(300),
   primary key (visitor_id)
);

/*==============================================================*/
/* Table: visitor_role                                          */
/*==============================================================*/
create table visitor_role
(
   visitor_role_id      int not null auto_increment,
   visitor_id           int,
   role_id              int,
   primary key (visitor_role_id)
);

/*==============================================================*/
/* Table: visitor_state                                         */
/*==============================================================*/
create table visitor_state
(
   visitor_state_id     int not null auto_increment,
   name                 varchar(10),
   primary key (visitor_state_id)
);

alter table address add constraint FK_Reference_4 foreign key (parent_address_id)
      references address (address_id);

alter table article add constraint FK_Reference_12 foreign key (author_id)
      references visitor (visitor_id);

alter table article add constraint FK_Reference_22 foreign key (source_id)
      references source (source_id);

alter table article add constraint FK_Reference_24 foreign key (article_group_id)
      references article_group (article_group_id);

alter table article add constraint FK_Reference_6 foreign key (article_state_id)
      references article_state (article_state_id);

alter table article add constraint FK_Reference_7 foreign key (article_public_id)
      references article_public (article_public_id);

alter table article_group add constraint FK_Reference_23 foreign key (visitor_id)
      references visitor (visitor_id);

alter table assist add constraint FK_Reference_19 foreign key (article_id)
      references article (article_id);

alter table assist add constraint FK_Reference_20 foreign key (discuss_id)
      references discuss (discuss_id);

alter table assist add constraint FK_Reference_21 foreign key (visitor_id)
      references visitor (visitor_id);

alter table attention add constraint FK_Reference_25 foreign key (owner_visitor_id)
      references visitor (visitor_id);

alter table attention add constraint FK_Reference_26 foreign key (attention_visiton_id)
      references visitor (visitor_id);

alter table blog_level add constraint FK_Reference_31 foreign key (level_group_id)
      references level_group (level_group_id);

alter table discuss add constraint FK_Reference_15 foreign key (visitor_id)
      references visitor (visitor_id);

alter table discuss add constraint FK_Reference_16 foreign key (article_id)
      references article (article_id);

alter table discuss add constraint FK_Reference_17 foreign key (parent_discuss_id)
      references discuss (discuss_id);

alter table discuss add constraint FK_Reference_18 foreign key (read_state_id)
      references read_state (read_state_id);

alter table info add constraint FK_Reference_3 foreign key (visitor_id)
      references visitor (visitor_id);

alter table info add constraint FK_Reference_5 foreign key (address_id)
      references address (address_id);

alter table integral add constraint FK_Reference_29 foreign key (visitor_id)
      references visitor (visitor_id);

alter table integral add constraint FK_Reference_30 foreign key (level_group_id)
      references level_group (level_group_id);

alter table login_info add constraint FK_Reference_2 foreign key (visitor_id)
      references visitor (visitor_id);

alter table read_log add constraint FK_Reference_27 foreign key (article_id)
      references article (article_id);

alter table read_log add constraint FK_Reference_28 foreign key (visitor_id)
      references visitor (visitor_id);

alter table role_action add constraint FK_Reference_10 foreign key (role_id)
      references role (role_id);

alter table role_action add constraint FK_Reference_11 foreign key (action_id)
      references action (action_id);

alter table visitor add constraint FK_Reference_1 foreign key (visitor_state_id)
      references visitor_state (visitor_state_id);

alter table visitor_role add constraint FK_Reference_8 foreign key (visitor_id)
      references visitor (visitor_id);

alter table visitor_role add constraint FK_Reference_9 foreign key (role_id)
      references role (role_id);
