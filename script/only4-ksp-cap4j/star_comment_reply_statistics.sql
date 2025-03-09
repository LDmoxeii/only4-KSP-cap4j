create table star_comment_reply_statistics
    (
    id                    bigint               not null comment 'ID' primary key,
    star_comment_reply_id bigint               not null comment '星球评论回复ID',
    like_count            int        default 0 not null comment '点赞数',
    report_count          int        default 0 not null comment '举报数',
    del_flag              tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '星球评论回复统计
 @P=star_comment_reply;
 @L=true;'
    row_format = DYNAMIC;

create index star_comment_reply_statistics_id_index on star_comment_reply_statistics (id);

