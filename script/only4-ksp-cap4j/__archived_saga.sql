create table __archived_saga
    (
    id            bigint auto_increment primary key,
    saga_uuid     varchar(64)  default ''                    not null comment 'SAGA uuid',
    svc_name      varchar(255) default ''                    not null comment '服务',
    saga_type     varchar(255) default ''                    not null comment 'SAGA类型',
    param         text                                       null comment '参数',
    param_type    varchar(255) default ''                    not null comment '参数类型',
    result        text                                       null comment '结果',
    result_type   varchar(255) default ''                    not null comment '结果类型',
    exception     text                                       null comment '执行异常',
    expire_at     datetime     default CURRENT_TIMESTAMP     not null comment '过期时间',
    create_at     datetime     default CURRENT_TIMESTAMP     not null comment '创建时间',
    saga_state    int          default 0                     not null comment '执行状态@E=0:INIT:init|-1:EXECUTING:executing|-2:CANCEL:cancel|-3:EXPIRED:expired|-4:EXHAUSTED:exhausted|-9:EXCEPTION:exception|1:EXECUTED:executed;@T=SagaState;',
    last_try_time datetime     default CURRENT_TIMESTAMP     not null comment '上次尝试时间',
    next_try_time datetime     default '0001-01-01 00:00:00' not null comment '下次尝试时间',
    tried_times   int          default 0                     not null comment '已尝试次数',
    try_times     int          default 0                     not null comment '尝试次数',
    version       int          default 0                     not null,
    db_created_at datetime     default CURRENT_TIMESTAMP     not null comment '创建时间',
    db_updated_at datetime     default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '更新时间'
    ) comment 'SAGA事务(存档) support by cap4j
@I;'
    charset = utf8mb4
    row_format = DYNAMIC;

create index idx_create_at on __archived_saga (create_at);

create index idx_db_created_at on __archived_saga (db_created_at);

create index idx_db_updated_at on __archived_saga (db_updated_at);

create index idx_expire_at on __archived_saga (expire_at);

create index idx_next_try_time on __archived_saga (next_try_time);

create index idx_saga_type on __archived_saga (saga_type, svc_name);

create index idx_saga_uuid on __archived_saga (saga_uuid);

