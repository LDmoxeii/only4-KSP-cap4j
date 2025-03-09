create table article
    (
    id           bigint                  not null comment 'ID' primary key,
    title        varchar(255)            not null comment '标题',
    description  varchar(255)            not null comment '描述',
    content      varchar(255)            not null comment '内容',
    cover        varchar(255) default '' not null comment '文章封面',
    appendix     varchar(255) default '' not null comment '文章附件',
    price        bigint       default 0  not null comment '文章价格',
    visibility   tinyint      default 0  not null comment '文章状态@T=ArticleVisibility;@E=0:PRIVATE|1:PUBLISH|2:BANNED;',
    sticky_flag  tinyint(1)   default 0  not null comment '置顶标识',
    comment_flag tinyint(1)   default 1  not null comment '评论功能标识',
    banned_at    timestamp               null comment '封禁时间',
    ban_duration int          default 0  not null comment '封禁时间',
    del_flag     tinyint(1)   default 0  not null comment '逻辑删除'
    ) comment '文章
 @Fac;'
    row_format = DYNAMIC;

