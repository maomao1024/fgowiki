CREATE TABLE `fgo_attribute` (
  `id`          VARCHAR(2) CHARACTER SET utf8
  COLLATE utf8_general_ci NOT NULL
  COMMENT 'id',
  `name`        VARCHAR(64) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '名称',
  `create_time` DATETIME  NULL DEFAULT NULL,
  `update_time` DATETIME  NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  COMMENT = '属性九宫格'
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;
CREATE TABLE `fgo_attribute Copy 1` (
  `id`          VARCHAR(2) CHARACTER SET utf8
  COLLATE utf8_general_ci NOT NULL
  COMMENT 'id',
  `name`        VARCHAR(64) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '名称',
  `create_time` DATETIME  NULL DEFAULT NULL,
  `update_time` DATETIME  NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  COMMENT = '属性九宫格'
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;
CREATE TABLE `fgo_camp` (
  `id`          INT(11)   NOT NULL
  COMMENT 'id',
  `name`        VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '名称',
  `create_time` DATETIME  NULL DEFAULT NULL,
  `update_time` DATETIME  NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  COMMENT = '阵营'
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;
CREATE TABLE `fgo_class` (
  `id`          INT(11)   NOT NULL
  COMMENT 'id',
  `name`        VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '名称',
  `name_en`     VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '英文名称',
  `create_time` DATETIME  NULL DEFAULT NULL,
  `update_time` DATETIME  NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  COMMENT = '阶职'
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;
CREATE TABLE `fgo_material` (
  `id`          INT(11)   NOT NULL
  COMMENT 'id',
  `name`        VARCHAR(64) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '名称',
  `type`        INT(11)   NULL DEFAULT NULL
  COMMENT '类型',
  `box`         INT(11)   NULL DEFAULT NULL
  COMMENT '箱子类型',
  `description` VARCHAR(512) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '描述',
  `location`    VARCHAR(512) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '掉落地点',
  `create_time` DATETIME  NULL DEFAULT NULL,
  `update_time` DATETIME  NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  COMMENT = '材料表'
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;
CREATE TABLE `fgo_noble_phantasm_info` (
  `id`          VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci     NOT NULL
  COMMENT 'id',
  `description` VARCHAR(256) CHARACTER SET utf8
  COLLATE utf8_general_ci     NULL DEFAULT NULL
  COMMENT '描述',
  `stage1`      DECIMAL(6, 2) NULL DEFAULT NULL
  COMMENT 'stage1',
  `stage2`      DECIMAL(6, 2) NULL DEFAULT NULL
  COMMENT 'stage2',
  `stage3`      DECIMAL(6, 2) NULL DEFAULT NULL
  COMMENT 'stage3',
  `stage4`      DECIMAL(6, 2) NULL DEFAULT NULL
  COMMENT 'stage4',
  `stage5`      DECIMAL(6, 2) NULL DEFAULT NULL
  COMMENT 'stage5',
  `type`        INT(11)       NULL DEFAULT NULL
  COMMENT '类型',
  `create_time` DATETIME      NULL DEFAULT NULL,
  `update_time` DATETIME      NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  COMMENT = '宝具效果'
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;
CREATE TABLE `fgo_role` (
  `id`          INT(11)   NOT NULL
  COMMENT 'id',
  `role`        VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '角色',
  `name`        VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '角色名',
  `create_time` DATETIME  NULL DEFAULT NULL,
  `update_time` DATETIME  NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `ak_key_2` (`role` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  COMMENT = '角色表'
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;
CREATE TABLE `fgo_servant` (
  `id`               INT(11)       NOT NULL
  COMMENT 'id',
  `name_zh`          VARCHAR(64) CHARACTER SET utf8
  COLLATE utf8_general_ci          NULL DEFAULT NULL
  COMMENT '中文名',
  `name_en`          VARCHAR(64) CHARACTER SET utf8
  COLLATE utf8_general_ci          NULL DEFAULT NULL
  COMMENT '英文名',
  `name_jp`          VARCHAR(64) CHARACTER SET utf8
  COLLATE utf8_general_ci          NULL DEFAULT NULL
  COMMENT '日文名',
  `nickname`         VARCHAR(256) CHARACTER SET utf8
  COLLATE utf8_general_ci          NULL DEFAULT NULL
  COMMENT '昵称',
  `class`            INT(11)       NULL DEFAULT NULL
  COMMENT '阶职',
  `star`             INT(11)       NULL DEFAULT NULL
  COMMENT '星级',
  `camp`             INT(11)       NULL DEFAULT NULL
  COMMENT '阵营',
  `atk_stage0`       INT(11)       NULL DEFAULT NULL
  COMMENT '基础atk',
  `hp_stage0`        INT(11)       NULL DEFAULT NULL
  COMMENT '基础hp',
  `cards`            VARCHAR(5) CHARACTER SET utf8
  COLLATE utf8_general_ci          NULL DEFAULT NULL
  COMMENT '配卡',
  `atk_stage4`       INT(11)       NULL DEFAULT NULL
  COMMENT '灵基4阶段atk',
  `hp_stage4`        INT(11)       NULL DEFAULT NULL
  COMMENT '灵基4阶段hp',
  `atk_lv90`         INT(11)       NULL DEFAULT NULL
  COMMENT '90级atk',
  `hp_lv90`          INT(11)       NULL DEFAULT NULL
  COMMENT '90级hp',
  `atk_lv100`        INT(11)       NULL DEFAULT NULL
  COMMENT '100级_atk',
  `hp_lv100`         INT(11)       NULL DEFAULT NULL
  COMMENT '100级_hp',
  `art_hit`          INT(11)       NULL DEFAULT NULL
  COMMENT 'art攻击次数',
  `buster_hit`       INT(11)       NULL DEFAULT NULL
  COMMENT 'buster攻击次数',
  `quick_hit`        INT(11)       NULL DEFAULT NULL
  COMMENT 'quick攻击次数',
  `extra_hit`        INT(11)       NULL DEFAULT NULL
  COMMENT 'extra攻击次数',
  `crit`             INT(11)       NULL DEFAULT NULL
  COMMENT '暴击权重',
  `crit_star`        DECIMAL(5, 4) NULL DEFAULT NULL
  COMMENT '暴击星掉落',
  `np_rate_art`      DECIMAL(5, 4) NULL DEFAULT NULL
  COMMENT 'np率art',
  `np_rate_buster`   DECIMAL(5, 4) NULL DEFAULT NULL
  COMMENT 'np率buster',
  `np_rate_quick`    DECIMAL(5, 4) NULL DEFAULT NULL
  COMMENT 'np率quick',
  `np_rate_extra`    DECIMAL(5, 4) NULL DEFAULT NULL
  COMMENT 'np率ex',
  `np_rate_attacked` DECIMAL(5, 4) NULL DEFAULT NULL
  COMMENT 'np率被攻击',
  `gender`           INT(11)       NULL DEFAULT NULL
  COMMENT '性别',
  `region`           VARCHAR(64) CHARACTER SET utf8
  COLLATE utf8_general_ci          NULL DEFAULT NULL
  COMMENT '地域',
  `attributes`       VARCHAR(64) CHARACTER SET utf8
  COLLATE utf8_general_ci          NULL DEFAULT NULL
  COMMENT '属性',
  `painter`          VARCHAR(64) CHARACTER SET utf8
  COLLATE utf8_general_ci          NULL DEFAULT NULL
  COMMENT '画师',
  `cv`               VARCHAR(64) CHARACTER SET utf8
  COLLATE utf8_general_ci          NULL DEFAULT NULL
  COMMENT 'cv',
  `height`           VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci          NULL DEFAULT NULL
  COMMENT '身高',
  `weight`           VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci          NULL DEFAULT NULL
  COMMENT '体重',
  `origin`           VARCHAR(128) CHARACTER SET utf8
  COLLATE utf8_general_ci          NULL DEFAULT NULL
  COMMENT '出处',
  `create_time`      DATETIME      NULL DEFAULT NULL,
  `update_time`      DATETIME      NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  COMMENT = '英灵信息'
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;
CREATE TABLE `fgo_servant_class_skill` (
  `id`          VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NOT NULL
  COMMENT 'id',
  `servant_id`  INT(11)   NULL DEFAULT NULL
  COMMENT 'id',
  `name`        VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '名称',
  `level`       VARCHAR(8) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '固有等级',
  `info_id`     VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '技能描述',
  `sid`         INT(11)   NULL DEFAULT NULL
  COMMENT '序号',
  `create_time` DATETIME  NULL DEFAULT NULL,
  `update_time` DATETIME  NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_servant_class` (`servant_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  COMMENT = '阶职技能'
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;
CREATE TABLE `fgo_servant_material` (
  `id`          VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NOT NULL
  COMMENT 'id',
  `servant_id`  INT(11)   NULL DEFAULT NULL
  COMMENT 'id',
  `sid`         INT(11)   NULL DEFAULT NULL
  COMMENT '序号',
  `level`       INT(11)   NULL DEFAULT NULL
  COMMENT '等级',
  `count`       INT(11)   NULL DEFAULT NULL
  COMMENT '数量',
  `qp`          INT(11)   NULL DEFAULT NULL
  COMMENT '量子',
  `type`        INT(11)   NULL DEFAULT NULL
  COMMENT '类型',
  `create_time` DATETIME  NULL DEFAULT NULL,
  `update_time` DATETIME  NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_servant_material` (`servant_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  COMMENT = '从者素材'
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;
CREATE TABLE `fgo_servant_noble_phantasm` (
  `id`          VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NOT NULL
  COMMENT 'id',
  `servant_id`  INT(11)   NULL DEFAULT NULL
  COMMENT 'id',
  `name`        VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '名称',
  `name_en`     VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '英文名',
  `level`       VARCHAR(8) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '固有等级',
  `info_id`     VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '技能效果',
  `create_time` DATETIME  NULL DEFAULT NULL,
  `update_time` DATETIME  NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_servant_noble_phantasm` (`servant_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  COMMENT = '从者宝具'
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;
CREATE TABLE `fgo_servant_skill` (
  `id`          VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NOT NULL
  COMMENT 'id',
  `servant_id`  INT(11)   NULL DEFAULT NULL
  COMMENT 'id',
  `name`        VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '名称',
  `level`       VARCHAR(8) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '固有等级',
  `info_id`     VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '技能效果',
  `create_time` DATETIME  NULL DEFAULT NULL,
  `update_time` DATETIME  NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_servant_skill` (`servant_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  COMMENT = '从者技能'
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;
CREATE TABLE `fgo_servant_story` (
  `id`          VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NOT NULL
  COMMENT 'id',
  `servant_id`  INT(11)   NULL DEFAULT NULL
  COMMENT 'id',
  `sid`         INT(11)   NULL DEFAULT NULL
  COMMENT '序号',
  `name`        VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '名称',
  `description` VARCHAR(8) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '描述',
  `create_time` DATETIME  NULL DEFAULT NULL,
  `update_time` DATETIME  NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_servant_story` (`servant_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  COMMENT = '从者故事'
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;
CREATE TABLE `fgo_servant_voice` (
  `id`          VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NOT NULL
  COMMENT 'id',
  `servant_id`  INT(11)   NULL DEFAULT NULL
  COMMENT 'id',
  `sid`         INT(11)   NULL DEFAULT NULL
  COMMENT '序号',
  `name`        VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '名称',
  `description` VARCHAR(8) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL DEFAULT NULL
  COMMENT '描述',
  `type`        INT(11)   NULL DEFAULT NULL
  COMMENT 'type',
  `create_time` DATETIME  NULL DEFAULT NULL,
  `update_time` DATETIME  NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_servant_voice` (`servant_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  COMMENT = '从者语音'
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;
CREATE TABLE `fgo_skill_info` (
  `id`          VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci     NOT NULL
  COMMENT 'id',
  `description` VARCHAR(256) CHARACTER SET utf8
  COLLATE utf8_general_ci     NULL DEFAULT NULL
  COMMENT '描述',
  `value`       DECIMAL(6, 2) NULL DEFAULT NULL
  COMMENT '初始数值',
  `growth`      DECIMAL(6, 2) NULL DEFAULT NULL
  COMMENT '成长',
  `create_time` DATETIME      NULL DEFAULT NULL,
  `update_time` DATETIME      NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  COMMENT = '技能效果'
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;
CREATE TABLE `fgo_user` (
  `uid`         INT(11)   NOT NULL
  COMMENT 'uid',
  `username`    VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL     DEFAULT NULL
  COMMENT '用户名',
  `password`    VARCHAR(128) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL     DEFAULT NULL
  COMMENT '密码',
  `head`        VARCHAR(128) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL     DEFAULT NULL
  COMMENT '头像url',
  `login_time`  DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '登录时间',
  `login_ip`    VARCHAR(32) CHARACTER SET utf8
  COLLATE utf8_general_ci NULL     DEFAULT NULL
  COMMENT '登录ip',
  `create_time` DATETIME  NULL     DEFAULT NULL,
  `update_time` DATETIME  NULL     DEFAULT NULL,
  PRIMARY KEY (`uid`),
  INDEX `ak_key_2` (`username` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  COMMENT = '用户表'
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;
CREATE TABLE `fgo_user_role` (
  `user_id`     INT(11)  NOT NULL
  COMMENT '用户id',
  `role_id`     INT(11)  NOT NULL
  COMMENT '角色id',
  `create_time` DATETIME NULL DEFAULT NULL,
  `update_time` DATETIME NULL DEFAULT NULL,
  INDEX `fk_reference_10` (`user_id` ASC) USING BTREE,
  INDEX `fk_reference_11` (`role_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  AVG_ROW_LENGTH = 0
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  KEY_BLOCK_SIZE = 0
  MAX_ROWS = 0
  MIN_ROWS = 0
  ROW_FORMAT = DYNAMIC;

ALTER TABLE `fgo_noble_phantasm_info`
  ADD CONSTRAINT `fk_reference_5` FOREIGN KEY (`id`) REFERENCES `fgo_servant_noble_phantasm` (`id`)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;
ALTER TABLE `fgo_servant_class_skill`
  ADD CONSTRAINT `fk_servant_class` FOREIGN KEY (`servant_id`) REFERENCES `fgo_servant` (`id`)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;
ALTER TABLE `fgo_servant_material`
  ADD CONSTRAINT `fk_servant_material` FOREIGN KEY (`servant_id`) REFERENCES `fgo_servant` (`id`)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;
ALTER TABLE `fgo_servant_noble_phantasm`
  ADD CONSTRAINT `fk_servant_noble_phantasm` FOREIGN KEY (`servant_id`) REFERENCES `fgo_servant` (`id`)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;
ALTER TABLE `fgo_servant_skill`
  ADD CONSTRAINT `fk_servant_skill` FOREIGN KEY (`servant_id`) REFERENCES `fgo_servant` (`id`)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;
ALTER TABLE `fgo_servant_story`
  ADD CONSTRAINT `fk_servant_story` FOREIGN KEY (`servant_id`) REFERENCES `fgo_servant` (`id`)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;
ALTER TABLE `fgo_servant_voice`
  ADD CONSTRAINT `fk_servant_voice` FOREIGN KEY (`servant_id`) REFERENCES `fgo_servant` (`id`)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;
ALTER TABLE `fgo_skill_info`
  ADD CONSTRAINT `fk_reference_6` FOREIGN KEY (`id`) REFERENCES `fgo_servant_skill` (`id`)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;
ALTER TABLE `fgo_user_role`
  ADD CONSTRAINT `fk_reference_10` FOREIGN KEY (`user_id`) REFERENCES `fgo_user` (`uid`)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;
ALTER TABLE `fgo_user_role`
  ADD CONSTRAINT `fk_reference_11` FOREIGN KEY (`role_id`) REFERENCES `fgo_role` (`id`)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

