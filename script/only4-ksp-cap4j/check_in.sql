create table check_in
    (
    id        bigint               not null comment 'ID' primary key,
    member_id bigint               not null comment '用户ID',
    create_at timestamp            not null comment '创建时间',
    del_flag  tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '会员签到记录 
 @Fac;
 @VO;'
    row_format = DYNAMIC;

