create table favorites_statistics
    (
    id            bigint               not null comment 'ID' primary key,
    favorites_id  bigint               not null comment '收藏夹ID',
    article_count int        default 0 not null comment '文章数',
    del_flag      tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '收藏夹统计
 @P=favorites;
 @C=One;
 @L=true;'
    row_format = DYNAMIC;

