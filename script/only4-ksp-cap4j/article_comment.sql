create table article_comment
    (
    id          bigint               not null comment 'ID' primary key,
    article_id  bigint               not null comment '文章ID',
    author_id   bigint               not null comment '作者ID',
    author_name varchar(50)          not null comment '作者名',
    content     varchar(255)         not null comment '内容',
    sticky_flag tinyint(1) default 0 not null comment '置顶标识',
    create_at   timestamp            not null comment '评论时间',
    del_flag    tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '文章评论
 @Fac;'
    row_format = DYNAMIC;

