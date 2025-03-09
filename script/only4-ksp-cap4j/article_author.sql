create table article_author
    (
    id          bigint               not null comment 'ID' primary key,
    article_id  bigint               not null comment '文章ID',
    author_id   bigint               not null comment '作者ID',
    author_name varchar(50)          not null comment '作者名',
    del_flag    tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '文章作者
 @P=article;
 @L=true;'
    row_format = DYNAMIC;

