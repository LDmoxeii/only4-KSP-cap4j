create table star_comment_statistics
    (
    id              bigint               not null comment 'ID' primary key,
    star_comment_id bigint               not null comment '星球评论ID',
    like_count      int        default 0 not null comment '点赞数',
    report_count    int        default 0 not null comment '举报数',
    reply_count     int        default 0 not null comment '回复数',
    del_flag        tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '星球评论统计
 @P=star_comment;
 @C=One;
 @L=true;'
    row_format = DYNAMIC;

