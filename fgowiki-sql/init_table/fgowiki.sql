/*==============================================================*/
/* dbms name:      mysql 5.0                                    */
/* created on:     2018/1/14 16:00:14                           */
/*==============================================================*/


alter table fgo_attribute
   drop primary key;

drop table if exists fgo_attribute;

alter table fgo_camp
   drop primary key;

drop table if exists fgo_camp;

alter table fgo_class
   drop primary key;

drop table if exists fgo_class;

alter table fgo_material
   drop primary key;

drop table if exists fgo_material;

alter table fgo_noble_phantasm_info
   drop primary key;

drop table if exists fgo_noble_phantasm_info;

alter table fgo_servant
   drop primary key;

drop table if exists fgo_servant;

alter table fgo_servant_class_skill
   drop primary key;

drop table if exists fgo_servant_class_skill;

alter table fgo_servant_material
   drop primary key;

drop table if exists fgo_servant_material;

alter table fgo_servant_noble_phantasm
   drop primary key;

drop table if exists fgo_servant_noble_phantasm;

alter table fgo_servant_skill
   drop primary key;

drop table if exists fgo_servant_skill;

alter table fgo_servant_story
   drop primary key;

drop table if exists fgo_servant_story;

alter table fgo_servant_voice
   drop primary key;

drop table if exists fgo_servant_voice;

alter table fgo_skill_info
   drop primary key;

drop table if exists fgo_skill_info;

/*==============================================================*/
/* table: fgo_attribute                                         */
/*==============================================================*/
create table fgo_attribute
(
   id                   varchar(2) not null comment 'id',
   name                 varchar(64) comment '名称'
);

alter table fgo_attribute comment '属性九宫格';

alter table fgo_attribute
   add primary key (id);

/*==============================================================*/
/* table: fgo_camp                                              */
/*==============================================================*/
create table fgo_camp
(
   id                   int not null comment 'id',
   name                 varchar(32) comment '名称'
);

alter table fgo_camp comment '阵营';

alter table fgo_camp
   add primary key (id);

/*==============================================================*/
/* table: fgo_class                                             */
/*==============================================================*/
create table fgo_class
(
   id                   int not null comment 'id',
   name                 varchar(32) comment '名称',
   name_en              varchar(32) comment '英文名称'
);

alter table fgo_class comment '阶职';

alter table fgo_class
   add primary key (id);

/*==============================================================*/
/* table: fgo_material                                          */
/*==============================================================*/
create table fgo_material
(
   id                   int not null comment 'id',
   name                 varchar(64) comment '名称',
   type                 int comment '类型',
   box                  int comment '箱子类型',
   description          varchar(512) comment '描述',
   location             varchar(512) comment '掉落地点'
);

alter table fgo_material comment '材料表';

alter table fgo_material
   add primary key (id);

/*==============================================================*/
/* table: fgo_noble_phantasm_info                               */
/*==============================================================*/
create table fgo_noble_phantasm_info
(
   id                   varchar(32) not null comment 'id',
   description          varchar(256) comment '描述',
   stage1               numeric(6,2) comment 'stage1',
   stage2               numeric(6,2) comment 'stage2',
   stage3               numeric(6,2) comment 'stage3',
   stage4               numeric(6,2) comment 'stage4',
   stage5               numeric(6,2) comment 'stage5',
   type                 int comment '类型'
);

alter table fgo_noble_phantasm_info comment '宝具效果';

alter table fgo_noble_phantasm_info
   add primary key (id);

/*==============================================================*/
/* table: fgo_servant                                           */
/*==============================================================*/
create table fgo_servant
(
   id                   int not null comment 'id',
   name_zh              varchar(64) comment '中文名',
   name_en              varchar(64) comment '英文名',
   name_jp              varchar(64) comment '日文名',
   nickname             varchar(256) comment '昵称',
   class                int comment '阶职',
   star                 int comment '星级',
   camp                 int comment '阵营',
   atk_stage0           int comment '基础atk',
   hp_stage0            int comment '基础hp',
   cards                varchar(5) comment '配卡',
   atk_stage4           int comment '灵基4阶段atk',
   hp_stage4            int comment '灵基4阶段hp',
   atk_lv90             int comment '90级atk',
   hp_lv90              int comment '90级hp',
   atk_lv100            int comment '100级_atk',
   hp_lv100             int comment '100级_hp',
   art_hit              int comment 'art攻击次数',
   buster_hit           int comment 'buster攻击次数',
   quick_hit            int comment 'quick攻击次数',
   extra_hit            int comment 'extra攻击次数',
   crit                 int comment '暴击权重',
   crit_star            decimal(5,4) comment '暴击星掉落',
   np_rate_art          decimal(5,4) comment 'np率art',
   np_rate_buster       decimal(5,4) comment 'np率buster',
   np_rate_quick        decimal(5,4) comment 'np率quick',
   np_rate_extra        decimal(5,4) comment 'np率ex',
   np_rate_attacked     decimal(5,4) comment 'np率被攻击',
   gender               int comment '性别',
   region               varchar(64) comment '地域',
   attributes           varchar(64) comment '属性',
   painter              varchar(64) comment '画师',
   cv                   varchar(64) comment 'cv',
   height               varchar(32) comment '身高',
   weight               varchar(32) comment '体重',
   origin               varchar(128) comment '出处'
);

alter table fgo_servant comment '英灵信息';

alter table fgo_servant
   add primary key (id);

/*==============================================================*/
/* table: fgo_servant_class_skill                               */
/*==============================================================*/
create table fgo_servant_class_skill
(
   id                   varchar(32) not null comment 'id',
   servant_id           int comment 'id',
   name                 varchar(32) comment '名称',
   level                varchar(8) comment '固有等级',
   info_id              varchar(32) comment '技能描述',
   sid                  int comment '序号'
);

alter table fgo_servant_class_skill comment '阶职技能';

alter table fgo_servant_class_skill
   add primary key (id);

/*==============================================================*/
/* table: fgo_servant_material                                  */
/*==============================================================*/
create table fgo_servant_material
(
   id                   varchar(32) not null comment 'id',
   servant_id           int comment 'id',
   sid                  int comment '序号',
   level                int comment '等级',
   count                int comment '数量',
   qp                   int comment '量子',
   type                 int comment '类型'
);

alter table fgo_servant_material comment '从者素材';

alter table fgo_servant_material
   add primary key (id);

/*==============================================================*/
/* table: fgo_servant_noble_phantasm                            */
/*==============================================================*/
create table fgo_servant_noble_phantasm
(
   id                   varchar(32) not null comment 'id',
   servant_id           int comment 'id',
   name                 varchar(32) comment '名称',
   name_en              varchar(32) comment '英文名',
   level                varchar(8) comment '固有等级',
   info_id              varchar(32) comment '技能效果'
);

alter table fgo_servant_noble_phantasm comment '从者宝具';

alter table fgo_servant_noble_phantasm
   add primary key (id);

/*==============================================================*/
/* table: fgo_servant_skill                                     */
/*==============================================================*/
create table fgo_servant_skill
(
   id                   varchar(32) not null comment 'id',
   servant_id           int comment 'id',
   name                 varchar(32) comment '名称',
   level                varchar(8) comment '固有等级',
   info_id              varchar(32) comment '技能效果'
);

alter table fgo_servant_skill comment '从者技能';

alter table fgo_servant_skill
   add primary key (id);

/*==============================================================*/
/* table: fgo_servant_story                                     */
/*==============================================================*/
create table fgo_servant_story
(
   id                   varchar(32) not null comment 'id',
   servant_id           int comment 'id',
   sid                  int comment '序号',
   name                 varchar(32) comment '名称',
   description          varchar(8) comment '描述'
);

alter table fgo_servant_story comment '从者故事';

alter table fgo_servant_story
   add primary key (id);

/*==============================================================*/
/* table: fgo_servant_voice                                     */
/*==============================================================*/
create table fgo_servant_voice
(
   id                   varchar(32) not null comment 'id',
   servant_id           int comment 'id',
   sid                  int comment '序号',
   name                 varchar(32) comment '名称',
   description          varchar(8) comment '描述',
   type                 int comment 'type'
);

alter table fgo_servant_voice comment '从者语音';

alter table fgo_servant_voice
   add primary key (id);

/*==============================================================*/
/* table: fgo_skill_info                                        */
/*==============================================================*/
create table fgo_skill_info
(
   id                   varchar(32) not null comment 'id',
   description          varchar(256) comment '描述',
   value                numeric(6,2) comment '初始数值',
   growth               numeric(6,2) comment '成长'
);

alter table fgo_skill_info comment '技能效果';

alter table fgo_skill_info
   add primary key (id);

alter table fgo_noble_phantasm_info add constraint fk_reference_5 foreign key (id)
      references fgo_servant_noble_phantasm (id) on delete restrict on update restrict;

alter table fgo_servant_class_skill add constraint fk_servant_class foreign key (servant_id)
      references fgo_servant (id) on delete restrict on update restrict;

alter table fgo_servant_material add constraint fk_servant_material foreign key (servant_id)
      references fgo_servant (id) on delete restrict on update restrict;

alter table fgo_servant_noble_phantasm add constraint fk_servant_noble_phantasm foreign key (servant_id)
      references fgo_servant (id) on delete restrict on update restrict;

alter table fgo_servant_skill add constraint fk_servant_skill foreign key (servant_id)
      references fgo_servant (id) on delete restrict on update restrict;

alter table fgo_servant_story add constraint fk_servant_story foreign key (servant_id)
      references fgo_servant (id) on delete restrict on update restrict;

alter table fgo_servant_voice add constraint fk_servant_voice foreign key (servant_id)
      references fgo_servant (id) on delete restrict on update restrict;

alter table fgo_skill_info add constraint fk_reference_6 foreign key (id)
      references fgo_servant_skill (id) on delete restrict on update restrict;

