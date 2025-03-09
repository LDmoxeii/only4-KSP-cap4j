create table article_comment_statistics
    (
    id                 bigint               not null comment 'ID' primary key,
    article_comment_id bigint               not null comment '文章评论ID',
    like_count         int        default 0 not null comment '点赞数',
    reply_count        int        default 0 not null comment '评论回复数',
    del_flag           tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '文章评论
 @P=article_comment;
 @C=One;
 @L=true;'
    row_format = DYNAMIC;

