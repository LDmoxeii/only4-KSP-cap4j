create table __achrived_event
    (
    id            bigint auto_increment primary key,
    event_uuid    varchar(64)  default ''                    not null comment '事件uuid',
    svc_name      varchar(255) default ''                    not null comment '服务',
    event_type    varchar(255) default ''                    not null comment '事件类型',
    data          text                                       null comment '事件数据',
    data_type     varchar(255) default ''                    not null comment '事件数据类型',
    exception     text                                       null comment '事件发送异常',
    expire_at     datetime     default CURRENT_TIMESTAMP     not null comment '过期时间',
    create_at     datetime     default CURRENT_TIMESTAMP     not null comment '创建时间',
    event_state   int          default 0                     not null comment '分发状态',
    last_try_time datetime     default CURRENT_TIMESTAMP     not null comment '上次尝试时间',
    next_try_time datetime     default '0001-01-01 00:00:00' not null comment '下次尝试时间',
    tried_times   int          default 0                     not null comment '已尝试次数',
    try_times     int          default 0                     not null comment '尝试次数',
    version       int          default 0                     not null,
    db_created_at datetime     default CURRENT_TIMESTAMP     not null comment '创建时间',
    db_updated_at datetime     default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '更新时间'
    ) comment '事件发件箱存档 support by cap4j
@I;'
    charset = utf8mb3
    row_format = DYNAMIC;

create index idx_create_at on __achrived_event (create_at);

create index idx_db_created_at on __achrived_event (db_created_at);

create index idx_db_updated_at on __achrived_event (db_updated_at);

create index idx_event_type on __achrived_event (event_type, svc_name);

create index idx_event_uuid on __achrived_event (event_uuid);

create index idx_expire_at on __achrived_event (expire_at);

create index idx_next_try_time on __achrived_event (next_try_time);

