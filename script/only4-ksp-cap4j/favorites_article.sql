create table favorites_article
    (
    id           bigint               not null comment 'ID' primary key,
    favorites_id bigint               not null comment '收藏夹ID',
    article_id   bigint               not null comment '文章ID',
    create_at    timestamp            not null comment '收藏时间',
    del_flag     tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '会员收藏记录
 @P=favorites;
 @L=true;'
    row_format = DYNAMIC;

