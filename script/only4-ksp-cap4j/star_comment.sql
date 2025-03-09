create table star_comment
    (
    id          bigint               not null comment 'ID' primary key,
    star_id     bigint               not null comment '星球ID',
    author_id   bigint               not null comment '作者ID',
    author_name varchar(50)          not null comment '作者名',
    content     varchar(255)         not null comment '内容',
    pin_flag    tinyint(1) default 0 not null comment '置顶标识',
    create_at   timestamp            not null comment '创建时间',
    del_flag    tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '星球评论
 @Fac;'
    row_format = DYNAMIC;

