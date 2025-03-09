create table article_comment_like
    (
    id                 bigint               not null comment 'ID' primary key,
    article_comment_id bigint               not null comment '评论ID',
    member_id          bigint               not null comment '点赞用户ID',
    create_at          timestamp            not null comment '点赞时间',
    del_flag           tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '文章评论点赞
 @Fac;
 @VO;'
    row_format = DYNAMIC;

