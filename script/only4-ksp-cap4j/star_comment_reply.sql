create table star_comment_reply
    (
    id              bigint               not null comment 'ID' primary key,
    star_comment_id bigint               not null comment '星球评论ID',
    author_id       bigint               not null comment '作者ID',
    author_name     varchar(50)          null comment '作者名',
    content         varchar(255)         not null comment '内容',
    create_at       timestamp            not null comment '创建时间',
    del_falg        tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '星球评论回复
 @Fac;'
    row_format = DYNAMIC;

create index star_comment_reply_id_index on star_comment_reply (id);

