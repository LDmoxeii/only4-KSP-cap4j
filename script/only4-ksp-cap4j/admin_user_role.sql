create table admin_user_role
    (
    id            bigint               not null comment 'ID' primary key,
    admin_user_id bigint               not null comment '用户ID',
    role_id       bigint               not null comment '角色ID',
    role_name     varchar(255)         not null comment '角色名',
    del_flag      tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '用户角色表
 @P=admin_user;
 @L=true;'
    row_format = DYNAMIC;

