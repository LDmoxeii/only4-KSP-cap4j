create table star_statistic
    (
    id             bigint               not null comment 'ID' primary key,
    star_id        bigint               not null comment '星球ID',
    like_count     int        default 0 not null comment '星球点赞数',
    comment_count  int        default 0 not null comment '星球评论数',
    stardust_count int        default 0 not null comment '星尘数',
    del_flag       tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '星球统计
 @P=star;
 @C=One;
 @L=true;'
    row_format = DYNAMIC;

