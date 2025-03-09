create table member
    (
    id           bigint                  not null comment 'ID' primary key,
    name         varchar(50)             not null comment '帐号',
    password     varchar(50)  default '' not null comment '密码',
    phone        varchar(20)  default '' not null comment '手机号',
    nick_name    varchar(255) default '' not null comment '昵称',
    signature    varchar(255) default '' not null comment '个性签名',
    level        int          default 0  not null comment '等级',
    balance      bigint       default 0  not null comment '余额',
    ban_flag     tinyint(1)   default 0  not null comment '封禁标识',
    banned_at    timestamp               null comment '封禁时间',
    ban_duration int          default 0  not null comment '封禁时长',
    del_flag     tinyint(1)   default 0  not null comment '逻辑删除'
    ) comment '会员
 @Fac;'
    row_format = DYNAMIC;

