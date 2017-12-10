/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/11/27 22:39:36                          */
/*==============================================================*/


drop table if exists fgo_camp;

drop table if exists fgo_class;

drop table if exists fgo_material;

drop table if exists fgo_noble_phantasm_info;

drop table if exists fgo_servant;

drop table if exists fgo_servant_class_skill;

drop table if exists fgo_servant_material;

drop table if exists fgo_servant_noble_phantasm;

drop table if exists fgo_servant_skill;

drop table if exists fgo_servant_story;

drop table if exists fgo_servant_voice;

drop table if exists fgo_skill_info;

/*==============================================================*/
/* Table: fgo_camp                                              */
/*==============================================================*/
create table fgo_camp
(
   id                   int(1),
   name                 varchar(32)
);

alter table fgo_camp comment '阵营';

/*==============================================================*/
/* Table: fgo_class                                             */
/*==============================================================*/
create table fgo_class
(
   id                   int(1),
   name                 varchar(32),
   name_en              varchar(32)
);

alter table fgo_class comment '阶职';

/*==============================================================*/
/* Table: fgo_material                                          */
/*==============================================================*/
create table fgo_material
(
   id                   varchar(32),
   name                 varchar(32),
   type                 int,
   box                  int,
   description          varchar(32),
   location             varchar(32)
);

alter table fgo_material comment '材料表';

/*==============================================================*/
/* Table: fgo_noble_phantasm_info                               */
/*==============================================================*/
create table fgo_noble_phantasm_info
(
   id                   varchar(32),
   skill_id             varchar(32),
   description          varchar(256),
   STAGE1               decimal(6,2),
   STAGE2               decimal(6,2),
   STAGE3               decimal(6,2),
   STAGE4               decimal(6,2),
   STAGE5               decimal(6,2),
   type                 int
);

alter table fgo_noble_phantasm_info comment '宝具效果';

/*==============================================================*/
/* Table: fgo_servant                                           */
/*==============================================================*/
create table fgo_servant
(
   id                   int,
   name_zh              varchar(32),
   name_en              varchar(32),
   name_jp              varchar(32),
   class                int(1),
   camp                 int(1),
   star                 int(1),
   atk_stage0           int,
   hp_stage0            int,
   cards                varchar(5),
   atk_stage4           int,
   hp_stage4            int,
   atk_lv_90            int,
   hp_lv_90             int,
   atk_lv_100           int,
   hp_lv_100            int,
   art_hit              int(1),
   buster_hit           int(1),
   quick_hit            int(1),
   etxtra_hit           int(1),
   painter              varchar(32),
   cv                   varchar(32),
   Attributes           varchar(32),
   gender               int(1),
   region               varchar(32),
   height               int(3),
   weight               int(3),
   crit_star            decimal(4,2),
   crit                 int(3),
   np_rate_art          decimal(4,2),
   np_rate_buster       decimal(4,2),
   np_rate_quick        decimal(4,2),
   np_rate_extra        decimal(4,2),
   origin               varchar(32),
   np_rate_attacked     decimal(4,2),
   nickname             varchar(256)
);

alter table fgo_servant comment '英灵信息
';

/*==============================================================*/
/* Table: fgo_servant_class_skill                               */
/*==============================================================*/
create table fgo_servant_class_skill
(
   id                   varchar(32),
   servant_id           varchar(32),
   name                 varchar(32),
   level                varchar(8),
   info_id              varchar(32),
   sid                  int
);

alter table fgo_servant_class_skill comment '从者阶职技能';

/*==============================================================*/
/* Table: fgo_servant_material                                  */
/*==============================================================*/
create table fgo_servant_material
(
   id                   varchar(32),
   servant_id           varchar(32),
   sid                  int,
   material_id          varchar(32),
   level                int,
   count                int,
   qp                   int,
   type                 int
);

alter table fgo_servant_material comment '从者素材';

/*==============================================================*/
/* Table: fgo_servant_noble_phantasm                            */
/*==============================================================*/
create table fgo_servant_noble_phantasm
(
   id                   varchar(32),
   servant_id           varchar(32),
   name                 varchar(32),
   name_en              varchar(32),
   level                varchar(8),
   info_id              varchar(32)
);

alter table fgo_servant_noble_phantasm comment '从者宝具';

/*==============================================================*/
/* Table: fgo_servant_skill                                     */
/*==============================================================*/
create table fgo_servant_skill
(
   id                   varchar(32),
   servant_id           varchar(32),
   name                 varchar(32),
   level                varchar(8),
   info_id              varchar(32)
);

alter table fgo_servant_skill comment '从者技能';

/*==============================================================*/
/* Table: fgo_servant_story                                     */
/*==============================================================*/
create table fgo_servant_story
(
   id                   varchar(32),
   servant_id           varchar(32),
   sid                  int,
   name                 varchar(32),
   description          varchar(8)
);

alter table fgo_servant_story comment '从者故事';

/*==============================================================*/
/* Table: fgo_servant_voice                                     */
/*==============================================================*/
create table fgo_servant_voice
(
   id                   varchar(32),
   servant_id           varchar(32),
   sid                  int,
   name                 varchar(32),
   description          varchar(8),
   type                 char(10)
);

alter table fgo_servant_voice comment '从者语音';

/*==============================================================*/
/* Table: fgo_skill_info                                        */
/*==============================================================*/
create table fgo_skill_info
(
   id                   varchar(32),
   skill_id             varchar(32),
   description          varchar(256),
   value                decimal(6,2),
   growth               decimal(6,2)
);

alter table fgo_skill_info comment '技能效果';

alter table fgo_noble_phantasm_info add constraint FK_Reference_4 foreign key (skill_id)
      references fgo_servant_noble_phantasm (id) on delete restrict on update restrict;

alter table fgo_servant add constraint FK_Reference_10 foreign key (camp)
      references fgo_camp (id) on delete restrict on update restrict;

alter table fgo_servant add constraint FK_Reference_11 foreign key (class)
      references fgo_class (id) on delete restrict on update restrict;

alter table fgo_servant_class_skill add constraint FK_Reference_3 foreign key (servant_id)
      references fgo_servant (id) on delete restrict on update restrict;

alter table fgo_servant_material add constraint FK_Reference_8 foreign key (servant_id)
      references fgo_servant (id) on delete restrict on update restrict;

alter table fgo_servant_material add constraint FK_Reference_9 foreign key (material_id)
      references fgo_material (id) on delete restrict on update restrict;

alter table fgo_servant_noble_phantasm add constraint FK_Reference_5 foreign key (servant_id)
      references fgo_servant (id) on delete restrict on update restrict;

alter table fgo_servant_skill add constraint FK_Reference_2 foreign key (servant_id)
      references fgo_servant (id) on delete restrict on update restrict;

alter table fgo_servant_story add constraint FK_Reference_6 foreign key (servant_id)
      references fgo_servant (id) on delete restrict on update restrict;

alter table fgo_servant_voice add constraint FK_Reference_7 foreign key (servant_id)
      references fgo_servant (id) on delete restrict on update restrict;

alter table fgo_skill_info add constraint FK_FK_SKILL_INFO_SKILL foreign key (skill_id)
      references fgo_servant_skill (id) on delete restrict on update restrict;

