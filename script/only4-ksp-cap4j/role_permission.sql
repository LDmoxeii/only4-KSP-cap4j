create table role_permission
    (
    id                bigint               not null comment 'ID' primary key,
    role_id           bigint               null comment '角色ID',
    permission_code   varchar(255)         null comment '权限编码',
    permission_remark varchar(255)         null comment '权限备注',
    del_flag          tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '角色权限表
 @P=role;'
    row_format = DYNAMIC;

