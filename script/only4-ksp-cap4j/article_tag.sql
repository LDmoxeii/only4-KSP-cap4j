create table article_tag
    (
    id         bigint               not null comment 'ID' primary key,
    article_id bigint               not null comment '文章ID',
    tag_id     bigint               not null comment '标签ID',
    tag_name   varchar(50)          not null comment '标签名',
    del_flag   tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '文章标签
 @P=article;
 @L=true;'
    row_format = DYNAMIC;

