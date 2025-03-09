create table star
    (
    id          bigint               not null comment 'ID' primary key,
    member_id   bigint               not null comment '星主ID',
    name        varchar(50)          not null comment '星球名',
    description varchar(255)         not null comment '星球描述',
    amount      bigint     default 0 not null comment '星球价格',
    del_flag    tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '星球
 @Fac;'
    row_format = DYNAMIC;

