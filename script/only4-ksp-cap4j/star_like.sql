create table star_like
    (
    id          bigint               not null comment 'ID' primary key,
    star_id     bigint               not null comment '星球ID',
    stardust_id bigint               not null comment '星尘ID',
    create_at   timestamp            not null comment '点赞时间',
    del_flag    tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '星球点赞
 @Fac;
 @VO;'
    row_format = DYNAMIC;

