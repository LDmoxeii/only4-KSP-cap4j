create table article_category
    (
    id            bigint               not null comment 'ID' primary key,
    article_id    bigint               not null comment '文章ID',
    category_id   bigint               not null comment '分类ID',
    category_name varchar(50)          not null comment '分类名',
    del_flag      tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '文章分类
 @P=article;
 @L=true;'
    row_format = DYNAMIC;

