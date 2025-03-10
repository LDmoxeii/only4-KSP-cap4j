-- Create syntax for TABLE '__event'
CREATE TABLE `__event`
(
    `id`            bigint(20)   NOT NULL AUTO_INCREMENT,
    `event_uuid`    varchar(64)  NOT NULL DEFAULT '' COMMENT '事件uuid',
    `svc_name`      varchar(255) NOT NULL DEFAULT '' COMMENT '服务',
    `event_type`    varchar(255) NOT NULL DEFAULT '' COMMENT '事件类型',
    `data`          text COMMENT '事件数据',
    `data_type`     varchar(255) NOT NULL DEFAULT '' COMMENT '事件数据类型',
    `exception`     text COMMENT '事件发送异常',
    `expire_at`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
    `create_at`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `event_state`   int(11)      NOT NULL DEFAULT '0' COMMENT '分发状态',
    `last_try_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上次尝试时间',
    `next_try_time` datetime     NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '下次尝试时间',
    `tried_times`   int(11)      NOT NULL DEFAULT '0' COMMENT '已尝试次数',
    `try_times`     int(11)      NOT NULL DEFAULT '0' COMMENT '尝试次数',
    `version`       int(11)      NOT NULL DEFAULT '0',
    `db_created_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `db_updated_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`
#   , `db_created_at`
        ),
    KEY `idx_db_created_at` (`db_created_at`),
    KEY `idx_db_updated_at` (`db_updated_at`),
    KEY `idx_event_uuid` (`event_uuid`),
    KEY `idx_event_type` (`event_type`, `svc_name`),
    KEY `idx_create_at` (`create_at`),
    KEY `idx_expire_at` (`expire_at`),
    KEY `idx_next_try_time` (`next_try_time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='事件发件箱 support by cap4j\n@I;'
# partition by range(to_days(db_created_at))
# (partition p202201 values less than (to_days('2022-02-01')) ENGINE=InnoDB)
;
-- Create syntax for TABLE '__achrived_event'
CREATE TABLE `__achrived_event`
(
    `id`            bigint(20)   NOT NULL AUTO_INCREMENT,
    `event_uuid`    varchar(64)  NOT NULL DEFAULT '' COMMENT '事件uuid',
    `svc_name`      varchar(255) NOT NULL DEFAULT '' COMMENT '服务',
    `event_type`    varchar(255) NOT NULL DEFAULT '' COMMENT '事件类型',
    `data`          text COMMENT '事件数据',
    `data_type`     varchar(255) NOT NULL DEFAULT '' COMMENT '事件数据类型',
    `exception`     text COMMENT '事件发送异常',
    `expire_at`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
    `create_at`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `event_state`   int(11)      NOT NULL DEFAULT '0' COMMENT '分发状态',
    `last_try_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上次尝试时间',
    `next_try_time` datetime     NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '下次尝试时间',
    `tried_times`   int(11)      NOT NULL DEFAULT '0' COMMENT '已尝试次数',
    `try_times`     int(11)      NOT NULL DEFAULT '0' COMMENT '尝试次数',
    `version`       int(11)      NOT NULL DEFAULT '0',
    `db_created_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `db_updated_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`
#   , `db_created_at`
        ),
    KEY `idx_db_created_at` (`db_created_at`),
    KEY `idx_db_updated_at` (`db_updated_at`),
    KEY `idx_event_uuid` (`event_uuid`),
    KEY `idx_event_type` (`event_type`, `svc_name`),
    KEY `idx_create_at` (`create_at`),
    KEY `idx_expire_at` (`expire_at`),
    KEY `idx_next_try_time` (`next_try_time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='事件发件箱存档 support by cap4j\n@I;'
# partition by range(to_days(db_created_at))
# (partition p202201 values less than (to_days('2022-02-01')) ENGINE=InnoDB)
;

-- Create syntax for TABLE '__saga'
CREATE TABLE `__saga`
(
    `id`            bigint       NOT NULL AUTO_INCREMENT,
    `saga_uuid`     varchar(64)  NOT NULL DEFAULT '' COMMENT 'SAGA uuid',
    `svc_name`      varchar(255) NOT NULL DEFAULT '' COMMENT '服务',
    `saga_type`     varchar(255) NOT NULL DEFAULT '' COMMENT 'SAGA类型',
    `param`         text COMMENT '参数',
    `param_type`    varchar(255) NOT NULL DEFAULT '' COMMENT '参数类型',
    `result`        text COMMENT '结果',
    `result_type`   varchar(255) NOT NULL DEFAULT '' COMMENT '结果类型',
    `exception`     text COMMENT '执行异常',
    `expire_at`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
    `create_at`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `saga_state`    int          NOT NULL DEFAULT '0' COMMENT '执行状态@E=0:INIT:init|-1:EXECUTING:executing|-2:CANCEL:cancel|-3:EXPIRED:expired|-4:EXHAUSTED:exhausted|-9:EXCEPTION:exception|1:EXECUTED:executed;@T=SagaState;',
    `last_try_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上次尝试时间',
    `next_try_time` datetime     NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '下次尝试时间',
    `tried_times`   int(11)      NOT NULL DEFAULT '0' COMMENT '已尝试次数',
    `try_times`     int(11)      NOT NULL DEFAULT '0' COMMENT '尝试次数',
    `version`       int          NOT NULL DEFAULT '0',
    `db_created_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `db_updated_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`
#   , `db_created_at`
        ),
    KEY `idx_db_created_at` (`db_created_at`),
    KEY `idx_db_updated_at` (`db_updated_at`),
    KEY `idx_saga_uuid` (`saga_uuid`),
    KEY `idx_saga_type` (`saga_type`, `svc_name`),
    KEY `idx_create_at` (`create_at`),
    KEY `idx_expire_at` (`expire_at`),
    KEY `idx_next_try_time` (`next_try_time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='SAGA事务 support by cap4j\n@I;'
# partition by range(to_days(db_created_at))
# (partition p202201 values less than (to_days('2022-02-01')) ENGINE=InnoDB)
;

-- Create syntax for TABLE '__saga_process'
CREATE TABLE `__saga_process`
(
    `id`            bigint       NOT NULL AUTO_INCREMENT,
    `saga_id`       bigint       NOT NULL DEFAULT '0',
    `process_code`  varchar(255) NOT NULL DEFAULT '' COMMENT 'SAGA处理环节代码',
    `param`         text COMMENT '参数',
    `param_type`    varchar(255) NOT NULL DEFAULT '' COMMENT '参数类型',
    `result`        text COMMENT '结果',
    `result_type`   varchar(255) NOT NULL DEFAULT '' COMMENT '结果类型',
    `exception`     text COMMENT '执行异常',
    `process_state` int          NOT NULL DEFAULT '0' COMMENT '执行状态@E=0:INIT:init|-1:EXECUTING:executing|-9:EXCEPTION:exception|1:EXECUTED:executed;@T=SagaProcessState;',
    `create_at`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_try_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上次尝试时间',
    `tried_times`   int          NOT NULL DEFAULT '0' COMMENT '尝试次数',
    `db_created_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `db_updated_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`
#   , `db_created_at`
        ),
    KEY `idx_db_created_at` (`db_created_at`),
    KEY `idx_db_updated_at` (`db_updated_at`),
    KEY `idx_saga_id` (`saga_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='SAGA事务-子环节 support by cap4j\n@I;'
# partition by range(to_days(db_created_at))
# (partition p202201 values less than (to_days('2022-02-01')) ENGINE=InnoDB)
;

-- Create syntax for TABLE '__archived_saga'
CREATE TABLE `__archived_saga`
(
    `id`            bigint       NOT NULL AUTO_INCREMENT,
    `saga_uuid`     varchar(64)  NOT NULL DEFAULT '' COMMENT 'SAGA uuid',
    `svc_name`      varchar(255) NOT NULL DEFAULT '' COMMENT '服务',
    `saga_type`     varchar(255) NOT NULL DEFAULT '' COMMENT 'SAGA类型',
    `param`         text COMMENT '参数',
    `param_type`    varchar(255) NOT NULL DEFAULT '' COMMENT '参数类型',
    `result`        text COMMENT '结果',
    `result_type`   varchar(255) NOT NULL DEFAULT '' COMMENT '结果类型',
    `exception`     text COMMENT '执行异常',
    `expire_at`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
    `create_at`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `saga_state`    int          NOT NULL DEFAULT '0' COMMENT '执行状态@E=0:INIT:init|-1:EXECUTING:executing|-2:CANCEL:cancel|-3:EXPIRED:expired|-4:EXHAUSTED:exhausted|-9:EXCEPTION:exception|1:EXECUTED:executed;@T=SagaState;',
    `last_try_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上次尝试时间',
    `next_try_time` datetime     NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '下次尝试时间',
    `tried_times`   int(11)      NOT NULL DEFAULT '0' COMMENT '已尝试次数',
    `try_times`     int(11)      NOT NULL DEFAULT '0' COMMENT '尝试次数',
    `version`       int          NOT NULL DEFAULT '0',
    `db_created_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `db_updated_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`
#   , `db_created_at`
        ),
    KEY `idx_db_created_at` (`db_created_at`),
    KEY `idx_db_updated_at` (`db_updated_at`),
    KEY `idx_saga_uuid` (`saga_uuid`),
    KEY `idx_saga_type` (`saga_type`, `svc_name`),
    KEY `idx_create_at` (`create_at`),
    KEY `idx_expire_at` (`expire_at`),
    KEY `idx_next_try_time` (`next_try_time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='SAGA事务(存档) support by cap4j\n@I;'
# partition by range(to_days(db_created_at))
# (partition p202201 values less than (to_days('2022-02-01')) ENGINE=InnoDB)
;

-- Create syntax for TABLE '__archived_saga_process'
CREATE TABLE `__archived_saga_process`
(
    `id`            bigint       NOT NULL AUTO_INCREMENT,
    `saga_id`       bigint       NOT NULL DEFAULT '0',
    `process_code`  varchar(255) NOT NULL DEFAULT '' COMMENT 'SAGA处理环节代码',
    `param`         text COMMENT '参数',
    `param_type`    varchar(255) NOT NULL DEFAULT '' COMMENT '参数类型',
    `result`        text COMMENT '结果',
    `result_type`   varchar(255) NOT NULL DEFAULT '' COMMENT '结果类型',
    `exception`     text COMMENT '执行异常',
    `process_state` int          NOT NULL DEFAULT '0' COMMENT '执行状态@E=0:INIT:init|-1:EXECUTING:executing|-9:EXCEPTION:exception|1:EXECUTED:executed;@T=SagaProcessState;',
    `create_at`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_try_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上次尝试时间',
    `tried_times`   int          NOT NULL DEFAULT '0' COMMENT '尝试次数',
    `db_created_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `db_updated_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`
#   , `db_created_at`
        ),
    KEY `idx_db_created_at` (`db_created_at`),
    KEY `idx_db_updated_at` (`db_updated_at`),
    KEY `idx_saga_id` (`saga_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='SAGA事务-子环节(存档) support by cap4j\n@I;'
# partition by range(to_days(db_created_at))
# (partition p202201 values less than (to_days('2022-02-01')) ENGINE=InnoDB)
;

CREATE TABLE `__locker`
(
    `id`            int(11) unsigned    NOT NULL AUTO_INCREMENT,
    `name`          varchar(100)        NOT NULL DEFAULT '' COMMENT '锁名称',
    `pwd`           varchar(100)        NOT NULL DEFAULT '' COMMENT '锁密码',
    `lock_at`       datetime            NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '锁获取时间',
    `unlock_at`     datetime            NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '锁释放时间',
    `version`       bigint(20) unsigned NOT NULL DEFAULT '0',
    `db_created_at` timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `db_updated_at` timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_db_created_at` (`db_created_at`),
    KEY `idx_db_updated_at` (`db_updated_at`),
    UNIQUE `uniq_name` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='锁 support by cap4j\n@I;';
