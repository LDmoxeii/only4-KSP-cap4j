create table favorites
    (
    id           bigint                            not null comment 'ID' primary key,
    member_id    bigint                            not null comment '会员ID',
    name         varchar(50)  default '默认收藏夹' not null comment '收藏夹名',
    description  varchar(255) default ''           not null comment '描述',
    default_flag tinyint(1)   default 0            not null comment '默认标识',
    del_flag     tinyint(1)   default 0            not null comment '逻辑删除'
    ) comment '会员收藏夹
 @P=member;
 @L=true;'
    row_format = DYNAMIC;

