create table admin_user
    (
    id                bigint               not null comment 'ID' primary key,
    name              varchar(255)         null comment '用户名',
    phone             varchar(255)         null comment '手机号',
    password          varchar(255)         null comment '密码',
    refresh_token     varchar(255)         null comment '刷新令牌',
    login_expiry_date timestamp            null on update CURRENT_TIMESTAMP comment '过期时间',
    created_at        timestamp            null comment '创建时间',
    del_flag          tinyint(1) default 0 null comment '逻辑删除'
    ) comment '用户表
 @Fac;'
    row_format = DYNAMIC;

