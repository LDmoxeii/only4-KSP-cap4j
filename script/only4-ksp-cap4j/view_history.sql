create table view_history
    (
    id         bigint               not null comment 'ID' primary key,
    member_id  bigint               not null comment '会员ID',
    article_id bigint               not null comment '文章ID',
    del_flag   tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '会员历史记录
 @Fac;
 @VO;'
    row_format = DYNAMIC;

