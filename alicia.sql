drop table if exists article;

drop table if exists article_assist;

drop table if exists article_comment;

drop table if exists article_group;

drop table if exists article_img;

drop table if exists attention;

drop table if exists baby_img;

drop table if exists baby_info;

drop table if exists chatting_record;

drop table if exists friend;

drop table if exists friend_group;

drop table if exists head_img;

drop table if exists info;

drop table if exists level;

drop table if exists login_info;

drop table if exists photo_album;

drop table if exists photo_album_group;

drop table if exists say;

drop table if exists say_assist;

drop table if exists say_comment;

drop table if exists say_img;

drop table if exists source;

drop table if exists star;

drop table if exists user;

drop table if exists user_exception;

drop table if exists web_statistics;

/*==============================================================*/
/* Table: article                                               */
/*==============================================================*/
create table article
(
   article_id           int not null auto_increment,
   host_id              int,
   source_id            int,
   article_group_id     int,
   parent_article_id    int,
   article_title        varchar(30),
   article_content      varchar(3000),
   create_date          date,
   weather              varchar(20),
   article_state        int,
   public_or_private    int,
   primary key (article_id)
);

/*==============================================================*/
/* Table: article_assist                                        */
/*==============================================================*/
create table article_assist
(
   article_assist       int not null auto_increment,
   article_id           int,
   user_id              int,
   create_date          datetime,
   primary key (article_assist)
);

/*==============================================================*/
/* Table: article_comment                                       */
/*==============================================================*/
create table article_comment
(
   article_comment_id   int not null auto_increment,
   article_id           int,
   user_id              int,
   article_comment_content varchar(300),
   create_time          datetime,
   primary key (article_comment_id)
);

/*==============================================================*/
/* Table: article_group                                         */
/*==============================================================*/
create table article_group
(
   article_group_id     int not null auto_increment,
   article_group_name   varchar(30),
   primary key (article_group_id)
);

/*==============================================================*/
/* Table: article_img                                           */
/*==============================================================*/
create table article_img
(
   article_img_id       int not null auto_increment,
   photo_album_id       int,
   article_id           int,
   primary key (article_img_id)
);

/*==============================================================*/
/* Table: attention                                             */
/*==============================================================*/
create table attention
(
   attention_id         int not null auto_increment,
   host_id              int,
   host_attention_id    int,
   create_date          date,
   primary key (attention_id)
);

/*==============================================================*/
/* Table: baby_img                                              */
/*==============================================================*/
create table baby_img
(
   baby_img_id          int not null auto_increment,
   baby_info_id         int,
   baby_img_content     varchar(300),
   create_date          date,
   primary key (baby_img_id)
);

/*==============================================================*/
/* Table: baby_info                                             */
/*==============================================================*/
create table baby_info
(
   baby_info_id         int not null auto_increment,
   parent_id            int,
   star_id              int,
   baby_nick_name       varchar(20),
   baby_sex             int,
   baby_birthday        date,
   baby_introduction    varchar(300),
   primary key (baby_info_id)
);

/*==============================================================*/
/* Table: chatting_record                                       */
/*==============================================================*/
create table chatting_record
(
   chatting_record_id   int not null auto_increment,
   send_user_id         int,
   receive_user_id      int,
   chatting_record_content varchar(300),
   send_time            datetime,
   read_flag            bit,
   primary key (chatting_record_id)
);

/*==============================================================*/
/* Table: friend                                                */
/*==============================================================*/
create table friend
(
   friend_id            int not null auto_increment,
   host_id              int,
   host_friend_id       int,
   friend_group_id      int,
   create_date          date,
   primary key (friend_id)
);

/*==============================================================*/
/* Table: friend_group                                          */
/*==============================================================*/
create table friend_group
(
   friend_group_id      int not null auto_increment,
   friend_group_name    varchar(30),
   primary key (friend_group_id)
);

/*==============================================================*/
/* Table: head_img                                              */
/*==============================================================*/
create table head_img
(
   head_img_id          int not null auto_increment,
   user_id              int,
   head_img             varchar(300),
   create_date          date,
   state                int,
   primary key (head_img_id)
);

/*==============================================================*/
/* Table: info                                                  */
/*==============================================================*/
create table info
(
   info_id              int not null auto_increment,
   user_id              int,
   real_name            varchar(20),
   sex                  int,
   birthday             date,
   address              varchar(50),
   mail                 varchar(40),
   QQ                   varchar(20),
   wechat_url           varchar(300),
   introduce            varchar(300),
   telphone             varchar(20),
   primary key (info_id)
);

/*==============================================================*/
/* Table: level                                                 */
/*==============================================================*/
create table level
(
   level_id             int not null auto_increment,
   level_name           varchar(20),
   primary key (level_id)
);

/*==============================================================*/
/* Table: login_info                                            */
/*==============================================================*/
create table login_info
(
   login_info_id        int not null auto_increment,
   level_id             int,
   user_id              int,
   login_time           double,
   last_login_time      date,
   primary key (login_info_id)
);

/*==============================================================*/
/* Table: photo_album                                           */
/*==============================================================*/
create table photo_album
(
   photo_album_id       int not null auto_increment,
   img_menu_id          int,
   photo_remark         text,
   photo_content        varchar(300),
   primary key (photo_album_id)
);

/*==============================================================*/
/* Table: photo_album_group                                     */
/*==============================================================*/
create table photo_album_group
(
   photo_album_group_id int not null auto_increment,
   photo_album_group_name varchar(30),
   primary key (photo_album_group_id)
);

/*==============================================================*/
/* Table: say                                                   */
/*==============================================================*/
create table say
(
   say_id               int not null auto_increment,
   user_id              int,
   source_id            int,
   parent_id            int,
   say_name             varchar(30),
   say_content          varchar(500),
   create_date          date,
   say_position         varchar(30),
   say_weather          varchar(30),
   say_state            int,
   primary key (say_id)
);

/*==============================================================*/
/* Table: say_assist                                            */
/*==============================================================*/
create table say_assist
(
   say_assist_id        int not null auto_increment,
   say_id               int,
   user_id              int,
   create_date          datetime,
   primary key (say_assist_id)
);

/*==============================================================*/
/* Table: say_comment                                           */
/*==============================================================*/
create table say_comment
(
   say_comment_id       int not null auto_increment,
   say_id               int,
   user_id              int,
   say_comment_content  varchar(300),
   create_time          date,
   primary key (say_comment_id)
);

/*==============================================================*/
/* Table: say_img                                               */
/*==============================================================*/
create table say_img
(
   say_img_id           int not null auto_increment,
   photo_album_id       int,
   say_id               int,
   primary key (say_img_id)
);

/*==============================================================*/
/* Table: source                                                */
/*==============================================================*/
create table source
(
   source_id            int not null auto_increment,
   source_name          varchar(10),
   primary key (source_id)
);

/*==============================================================*/
/* Table: star                                                  */
/*==============================================================*/
create table star
(
   star_id              int not null auto_increment,
   name                 varchar(20),
   start_time           varchar(20),
   end_time             varchar(20),
   star_fortune         varchar(300),
   star_character       varchar(300),
   primary key (star_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              int not null auto_increment,
   star_id              int,
   login_name           varchar(20),
   login_password       varchar(30),
   create_time          date,
   nick_name            varchar(20),
   user_state           int,
   title                varchar(300),
   second_title         varchar(300),
   public_or_private    int,
   primary key (user_id)
);

/*==============================================================*/
/* Table: user_exception                                        */
/*==============================================================*/
create table user_exception
(
   exception_id         int not null auto_increment,
   exception_name       varchar(50),
   exception_content    varchar(1000),
   exception_parent_position varchar(30),
   exception_child_position varchar(30),
   exception_ip         varchar(20),
   exception_date       date,
   primary key (exception_id)
);

/*==============================================================*/
/* Table: web_statistics                                        */
/*==============================================================*/
create table web_statistics
(
   web_statistics_id    int not null auto_increment,
   user_id              int,
   ip                   varchar(20),
   login_date           date,
   primary key (web_statistics_id)
);

alter table article add constraint FK_Reference_15 foreign key (host_id)
      references user (user_id) on delete restrict on update restrict;

alter table article add constraint FK_Reference_26 foreign key (source_id)
      references source (source_id) on delete restrict on update restrict;

alter table article add constraint FK_Reference_33 foreign key (article_group_id)
      references article_group (article_group_id) on delete restrict on update restrict;

alter table article_assist add constraint FK_Reference_37 foreign key (article_id)
      references article (article_id) on delete restrict on update restrict;

alter table article_assist add constraint FK_Reference_38 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table article_comment add constraint FK_Reference_23 foreign key (article_id)
      references article (article_id) on delete restrict on update restrict;

alter table article_comment add constraint FK_Reference_24 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table article_img add constraint FK_Reference_28 foreign key (photo_album_id)
      references photo_album (photo_album_id) on delete restrict on update restrict;

alter table article_img add constraint FK_Reference_30 foreign key (article_id)
      references article (article_id) on delete restrict on update restrict;

alter table attention add constraint FK_Reference_13 foreign key (host_id)
      references user (user_id) on delete restrict on update restrict;

alter table attention add constraint FK_Reference_14 foreign key (host_attention_id)
      references user (user_id) on delete restrict on update restrict;

alter table baby_img add constraint FK_Reference_19 foreign key (baby_info_id)
      references baby_info (baby_info_id) on delete restrict on update restrict;

alter table baby_info add constraint FK_Reference_18 foreign key (parent_id)
      references user (user_id) on delete restrict on update restrict;

alter table baby_info add constraint FK_Reference_20 foreign key (star_id)
      references star (star_id) on delete restrict on update restrict;

alter table chatting_record add constraint FK_Reference_35 foreign key (send_user_id)
      references user (user_id) on delete restrict on update restrict;

alter table chatting_record add constraint FK_Reference_36 foreign key (receive_user_id)
      references user (user_id) on delete restrict on update restrict;

alter table friend add constraint FK_Reference_32 foreign key (friend_group_id)
      references friend_group (friend_group_id) on delete restrict on update restrict;

alter table friend add constraint FK_Reference_5 foreign key (host_id)
      references user (user_id) on delete restrict on update restrict;

alter table friend add constraint FK_Reference_6 foreign key (host_friend_id)
      references user (user_id) on delete restrict on update restrict;

alter table head_img add constraint FK_Reference_10 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table info add constraint FK_Reference_11 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table login_info add constraint FK_Reference_12 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table login_info add constraint FK_Reference_9 foreign key (level_id)
      references level (level_id) on delete restrict on update restrict;

alter table photo_album add constraint FK_Reference_31 foreign key (img_menu_id)
      references photo_album_group (photo_album_group_id) on delete restrict on update restrict;

alter table say add constraint FK_Reference_25 foreign key (source_id)
      references source (source_id) on delete restrict on update restrict;

alter table say add constraint FK_Reference_7 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table say_assist add constraint FK_Reference_39 foreign key (say_id)
      references say (say_id) on delete restrict on update restrict;

alter table say_assist add constraint FK_Reference_40 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table say_comment add constraint FK_Reference_21 foreign key (say_id)
      references say (say_id) on delete restrict on update restrict;

alter table say_comment add constraint FK_Reference_22 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table say_img add constraint FK_Reference_27 foreign key (photo_album_id)
      references photo_album (photo_album_id) on delete restrict on update restrict;

alter table say_img add constraint FK_Reference_29 foreign key (say_id)
      references say (say_id) on delete restrict on update restrict;

alter table user add constraint FK_Reference_1 foreign key (star_id)
      references star (star_id) on delete restrict on update restrict;

alter table web_statistics add constraint FK_Reference_34 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;
