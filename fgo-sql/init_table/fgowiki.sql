/*==============================================================*/
/* Table: FGO_CAMP                                              */
/*==============================================================*/
CREATE TABLE FGO_CAMP
(
  ID                 INTEGER              NOT NULL,
  NAME                 VARCHAR2(32)
);

COMMENT ON TABLE FGO_CAMP IS
'阵营';

ALTER TABLE FGO_CAMP
  ADD CONSTRAINT PK_FGO_CAMP PRIMARY KEY (ID);

/*==============================================================*/
/* Table: FGO_CLASS                                             */
/*==============================================================*/
CREATE TABLE FGO_CLASS
(
  ID                 INTEGER              NOT NULL,
  NAME                 VARCHAR2(32),
  NAME_EN              VARCHAR2(32)
);

COMMENT ON TABLE FGO_CLASS IS
'阶职';

ALTER TABLE FGO_CLASS
  ADD CONSTRAINT PK_FGO_CLASS PRIMARY KEY (ID);

/*==============================================================*/
/* Table: FGO_MATERIAL                                          */
/*==============================================================*/
CREATE TABLE FGO_MATERIAL
(
  ID                   INTEGER         NOT NULL,
  NAME                 VARCHAR2(64),
  TYPE                 INTEGER,
  BOX                  INTEGER,
  DESCRIPTION          VARCHAR2(512),
  LOCATION             VARCHAR2(512)
);

COMMENT ON TABLE FGO_MATERIAL IS
'材料表';

ALTER TABLE FGO_MATERIAL
  ADD CONSTRAINT PK_FGO_MATERIAL PRIMARY KEY (ID);

/*==============================================================*/
/* Table: FGO_NOBLE_PHANTASM_INFO                               */
/*==============================================================*/
CREATE TABLE FGO_NOBLE_PHANTASM_INFO
(
  ID                 VARCHAR2(32)         NOT NULL,
  SKILL_ID             VARCHAR2(32),
  DESCRIPTION          VARCHAR2(256),
  STAGE1               NUMBER(6,2),
  STAGE2               NUMBER(6,2),
  STAGE3               NUMBER(6,2),
  STAGE4               NUMBER(6,2),
  STAGE5               NUMBER(6,2),
  TYPE                 INTEGER
);

COMMENT ON TABLE FGO_NOBLE_PHANTASM_INFO IS
'宝具效果';

ALTER TABLE FGO_NOBLE_PHANTASM_INFO
  ADD CONSTRAINT PK_FGO_NOBLE_PHANTASM_INFO PRIMARY KEY (ID);

/*==============================================================*/
/* Table: FGO_SERVANT                                           */
/*==============================================================*/
CREATE TABLE FGO_SERVANT
(
  ID                 INTEGER              NOT NULL,
  NAME_ZH              VARCHAR2(64),
  NAME_EN              VARCHAR2(64),
  NAME_JP              VARCHAR2(64),
  CLASS                INTEGER,
  CAMP                 INTEGER,
  STAR                 INTEGER,
  ATK_STAGE0           INTEGER,
  HP_STAGE0            INTEGER,
  CARDS                VARCHAR2(5),
  ATK_STAGE4           INTEGER,
  HP_STAGE4            INTEGER,
  ATK_LV_90            INTEGER,
  HP_LV_90             INTEGER,
  ATK_LV_100           INTEGER,
  HP_LV_100            INTEGER,
  ART_HIT              INTEGER,
  BUSTER_HIT           INTEGER,
  QUICK_HIT            INTEGER,
  ETXTRA_HIT           INTEGER,
  PAINTER              VARCHAR2(64),
  CV                   VARCHAR2(64),
  ATTRIBUTES           VARCHAR2(64),
  GENDER               INTEGER,
  REGION               VARCHAR2(64),
  HEIGHT               INTEGER,
  WEIGHT               INTEGER,
  CRIT_STAR            NUMBER(4,2),
  CRIT                 INTEGER,
  NP_RATE_ART          NUMBER(4,2),
  NP_RATE_BUSTER       NUMBER(4,2),
  NP_RATE_QUICK        NUMBER(4,2),
  NP_RATE_EXTRA        NUMBER(4,2),
  ORIGIN               VARCHAR2(64),
  NP_RATE_ATTACKED     NUMBER(4,2),
  NICKNAME             VARCHAR2(256)
);

COMMENT ON TABLE FGO_SERVANT IS
'英灵信息';

ALTER TABLE FGO_SERVANT
  ADD CONSTRAINT PK_FGO_SERVANT PRIMARY KEY (ID);

/*==============================================================*/
/* Table: FGO_SERVANT_CLASS_SKILL                               */
/*==============================================================*/
CREATE TABLE FGO_SERVANT_CLASS_SKILL
(
  ID                   VARCHAR2(32)         NOT NULL,
  SERVANT_ID           INTEGER,
  NAME                 VARCHAR2(32),
  LV                   VARCHAR2(8),
  INFO_ID              VARCHAR2(32),
  SID                  INTEGER
);

COMMENT ON TABLE FGO_SERVANT_CLASS_SKILL IS
'从者阶职技能';

ALTER TABLE FGO_SERVANT_CLASS_SKILL
  ADD CONSTRAINT PK_FGO_SERVANT_CLASS_SKILL PRIMARY KEY (ID);

/*==============================================================*/
/* Table: FGO_SERVANT_MATERIAL                                  */
/*==============================================================*/
CREATE TABLE FGO_SERVANT_MATERIAL
(
  SERVANT_ID           INTEGER,
  ID                 VARCHAR2(32)         NOT NULL,
  SID                  INTEGER,
  MATERIAL_ID          VARCHAR2(32),
  "LEVEL"              INTEGER,
  COUNT                INTEGER,
  QP                   INTEGER,
  TYPE                 INTEGER
);

COMMENT ON TABLE FGO_SERVANT_MATERIAL IS
'从者素材';

ALTER TABLE FGO_SERVANT_MATERIAL
  ADD CONSTRAINT PK_FGO_SERVANT_MATERIAL PRIMARY KEY (ID);

/*==============================================================*/
/* Table: FGO_SERVANT_NOBLE_PHANTASM                            */
/*==============================================================*/
CREATE TABLE FGO_SERVANT_NOBLE_PHANTASM
(
  ID                   VARCHAR2(32)         NOT NULL,
  SERVANT_ID           INTEGER,
  NAME                 VARCHAR2(32),
  NAME_EN              VARCHAR2(32),
  "LEVEL"              VARCHAR2(8),
  INFO_ID              VARCHAR2(32)
);

COMMENT ON TABLE FGO_SERVANT_NOBLE_PHANTASM IS
'从者宝具';

ALTER TABLE FGO_SERVANT_NOBLE_PHANTASM
  ADD CONSTRAINT PK_FGO_SERVANT_NOBLE_PHANTASM PRIMARY KEY (ID);

/*==============================================================*/
/* Table: FGO_SERVANT_SKILL                                     */
/*==============================================================*/
CREATE TABLE FGO_SERVANT_SKILL
(
  ID                 VARCHAR2(32)         NOT NULL,
  SERVANT_ID           INTEGER,
  NAME                 VARCHAR2(32),
  "LEVEL"              VARCHAR2(8),
  INFO_ID              VARCHAR2(32)
);

COMMENT ON TABLE FGO_SERVANT_SKILL IS
'从者技能';

ALTER TABLE FGO_SERVANT_SKILL
  ADD CONSTRAINT PK_FGO_SERVANT_SKILL PRIMARY KEY (ID);

/*==============================================================*/
/* Table: FGO_SERVANT_STORY                                     */
/*==============================================================*/
CREATE TABLE FGO_SERVANT_STORY
(
  ID                 VARCHAR2(32)         NOT NULL,
  SERVANT_ID           INTEGER,
  SID                  INTEGER,
  NAME                 VARCHAR2(32),
  DESCRIPTION          VARCHAR2(8)
);

COMMENT ON TABLE FGO_SERVANT_STORY IS
'从者故事';

ALTER TABLE FGO_SERVANT_STORY
  ADD CONSTRAINT PK_FGO_SERVANT_STORY PRIMARY KEY (ID);

/*==============================================================*/
/* Table: FGO_SERVANT_VOICE                                     */
/*==============================================================*/
CREATE TABLE FGO_SERVANT_VOICE
(
  ID                 VARCHAR2(32)         NOT NULL,
  SERVANT_ID           INTEGER,
  SID                  INTEGER,
  NAME                 VARCHAR2(32),
  DESCRIPTION          VARCHAR2(8),
  TYPE                 CHAR(10)
);

COMMENT ON TABLE FGO_SERVANT_VOICE IS
'从者语音';

ALTER TABLE FGO_SERVANT_VOICE
  ADD CONSTRAINT PK_FGO_SERVANT_VOICE PRIMARY KEY (ID);

/*==============================================================*/
/* Table: FGO_SKILL_INFO                                        */
/*==============================================================*/
CREATE TABLE FGO_SKILL_INFO
(
  ID                 VARCHAR2(32)         NOT NULL,
  SKILL_ID             VARCHAR2(32),
  DESCRIPTION          VARCHAR2(256),
  VALUE                NUMBER(6,2),
  GROWTH               NUMBER(6,2)
);

COMMENT ON TABLE FGO_SKILL_INFO IS
'技能效果';

ALTER TABLE FGO_SKILL_INFO
  ADD CONSTRAINT PK_FGO_SKILL_INFO PRIMARY KEY (ID);

ALTER TABLE FGO_NOBLE_PHANTASM_INFO
  ADD CONSTRAINT FK_REFERENCE_4 FOREIGN KEY (SKILL_ID)
REFERENCES FGO_SERVANT_NOBLE_PHANTASM (ID);

ALTER TABLE FGO_SERVANT
  ADD CONSTRAINT FK_REFERENCE_10 FOREIGN KEY (CAMP)
REFERENCES FGO_CAMP (ID);

ALTER TABLE FGO_SERVANT
  ADD CONSTRAINT FK_REFERENCE_11 FOREIGN KEY (CLASS)
REFERENCES FGO_CLASS (ID);

ALTER TABLE FGO_SERVANT_CLASS_SKILL
  ADD CONSTRAINT FK_REFERENCE_3 FOREIGN KEY (SERVANT_ID)
REFERENCES FGO_SERVANT (ID);

ALTER TABLE FGO_SERVANT_MATERIAL
  ADD CONSTRAINT FK_REFERENCE_8 FOREIGN KEY (SERVANT_ID)
REFERENCES FGO_SERVANT (ID);

ALTER TABLE FGO_SERVANT_MATERIAL
  ADD CONSTRAINT FK_REFERENCE_9 FOREIGN KEY (MATERIAL_ID)
REFERENCES FGO_MATERIAL (ID);

ALTER TABLE FGO_SERVANT_NOBLE_PHANTASM
  ADD CONSTRAINT FK_REFERENCE_5 FOREIGN KEY (SERVANT_ID)
REFERENCES FGO_SERVANT (ID);

ALTER TABLE FGO_SERVANT_SKILL
  ADD CONSTRAINT FK_REFERENCE_2 FOREIGN KEY (SERVANT_ID)
REFERENCES FGO_SERVANT (ID);

ALTER TABLE FGO_SERVANT_STORY
  ADD CONSTRAINT FK_REFERENCE_6 FOREIGN KEY (SERVANT_ID)
REFERENCES FGO_SERVANT (ID);

ALTER TABLE FGO_SERVANT_VOICE
  ADD CONSTRAINT FK_REFERENCE_7 FOREIGN KEY (SERVANT_ID)
REFERENCES FGO_SERVANT (ID);

ALTER TABLE FGO_SKILL_INFO
  ADD CONSTRAINT FK_FK_SKILL_INFO_SKILL FOREIGN KEY (SKILL_ID)
REFERENCES FGO_SERVANT_SKILL (ID);

