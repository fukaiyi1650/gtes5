/*==============================================================*/
/* Table: cus_customer                                          */
/*==============================================================*/
create table cus_customer
(
   customer_id          int(11) not null auto_increment comment '顾客ID',
   name                 varchar(100) comment '姓名',
   password             varchar(100) comment '密码',
   phone                varchar(20) comment '电话',
   email                varchar(100) comment '邮箱',
   sex                  varchar(100) comment '性别(1男, 2女, 3保密)',
   status               bit comment '状态(0禁用，1启用)',
   address              varchar(255) comment '地址',
   created              datetime comment '创建时间',
   updated              datetime comment '修改时间',
   version              int(11) comment '版本',
   del                  bit comment '删除状态',
   primary key (customer_id)
);

alter table cus_customer comment '顾客';
