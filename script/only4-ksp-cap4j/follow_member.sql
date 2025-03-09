create table follow_member
    (
    id         bigint               not null comment 'ID' primary key,
    member_id  bigint               not null comment '会员ID',
    other_id   bigint               not null comment '关注会员ID',
    other_name varchar(255)         null comment '关注会员名',
    del_flag   tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '关注会员
 @P=member;
 @L=true;'
    row_format = DYNAMIC;

