create table __locker
    (
    id            int unsigned auto_increment primary key,
    name          varchar(100)    default ''                    not null comment '锁名称',
    pwd           varchar(100)    default ''                    not null comment '锁密码',
    lock_at       datetime        default '1970-01-01 00:00:00' not null comment '锁获取时间',
    unlock_at     datetime        default '1970-01-01 00:00:00' not null comment '锁释放时间',
    version       bigint unsigned default '0'                   not null,
    db_created_at timestamp       default CURRENT_TIMESTAMP     not null comment '创建时间',
    db_updated_at timestamp       default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '更新时间',
    constraint uniq_name unique (name)
    ) comment '锁 support by cap4j
@I;'
    row_format = DYNAMIC;

create index idx_db_created_at on __locker (db_created_at);

create index idx_db_updated_at on __locker (db_updated_at);

