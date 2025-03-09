create table role
    (
    id          bigint               not null comment 'ID' primary key,
    name        varchar(255)         null comment '角色名',
    description varchar(255)         null comment '角色描述',
    created_at  timestamp            null comment '创建时间',
    del_flag    tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '角色表
 @Spe;
 @Fac;
 @DE=UpdatedRolePermissions|UpdatedRoleInfo;'
    row_format = DYNAMIC;

