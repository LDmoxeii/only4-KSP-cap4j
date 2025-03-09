create table __saga_process
    (
    id            bigint auto_increment primary key,
    saga_id       bigint       default 0                 not null,
    process_code  varchar(255) default ''                not null comment 'SAGA处理环节代码',
    param         text                                   null comment '参数',
    param_type    varchar(255) default ''                not null comment '参数类型',
    result        text                                   null comment '结果',
    result_type   varchar(255) default ''                not null comment '结果类型',
    exception     text                                   null comment '执行异常',
    process_state int          default 0                 not null comment '执行状态@E=0:INIT:init|-1:EXECUTING:executing|-9:EXCEPTION:exception|1:EXECUTED:executed;@T=SagaProcessState;',
    create_at     datetime     default CURRENT_TIMESTAMP not null,
    last_try_time datetime     default CURRENT_TIMESTAMP not null comment '上次尝试时间',
    tried_times   int          default 0                 not null comment '尝试次数',
    db_created_at datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    db_updated_at datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
    ) comment 'SAGA事务-子环节 support by cap4j
@I;'
    charset = utf8mb4
    row_format = DYNAMIC;

create index idx_db_created_at on __saga_process (db_created_at);

create index idx_db_updated_at on __saga_process (db_updated_at);

create index idx_saga_id on __saga_process (saga_id);

