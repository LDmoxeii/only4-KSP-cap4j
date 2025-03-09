create table article_comment_reply_statistics
    (
    id                       bigint               not null comment 'ID' primary key,
    article_comment_reply_id bigint               not null comment '文章评论回复ID',
    like_count               int                  not null comment '点赞数',
    del_flag                 tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '文章评论回复统计
 @P=article_comment_reply;
 @L=true;
 @C=One;'
    row_format = DYNAMIC;

create index article_comment_reply_statistics_id_index on article_comment_reply_statistics (id);

