create table article_comment_reply
    (
    id                 bigint               not null comment 'ID' primary key,
    article_comment_id bigint               not null comment '文章评论ID',
    author_id          bigint               not null comment '作者ID',
    author_name        varchar(50)          not null comment '作者名',
    content            varchar(255)         not null comment '内容',
    create_at          timestamp            not null comment '创建时间',
    del_flag           tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '文章评论回复
 @Fac;'
    row_format = DYNAMIC;

create index article_comment_reply_id_index on article_comment_reply (id);

