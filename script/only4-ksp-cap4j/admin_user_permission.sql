create table admin_user_permission
    (
    id                bigint               not null comment 'ID' primary key,
    admin_user_id     bigint               not null comment '用户ID',
    permission_code   varchar(255)         not null comment '权限编码',
    permission_remark varchar(255)         not null comment '权限备注',
    del_flag          tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '用户权限表
 @P=admin_user;
 @L=true;'
    row_format = DYNAMIC;

