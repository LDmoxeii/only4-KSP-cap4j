create table article_statistics
    (
    id             bigint               not null comment 'ID' primary key,
    article_id     bigint               not null comment '文章ID',
    like_count     int        default 0 not null comment '点赞数',
    favorite_count int        default 0 not null comment '文章收藏数',
    comment_count  int        default 0 not null comment '评论数',
    view_count     int        default 0 not null comment '文章浏览量',
    del_flag       tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '文章统计
 @P=article;
 @C=One;
 @L=true;'
    row_format = DYNAMIC;

