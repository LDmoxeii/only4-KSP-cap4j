create table tag
    (
    id          bigint                 not null comment 'ID' primary key,
    name        varchar(50)            not null comment '标签名',
    description varchar(255)           not null comment '标签描述',
    icon        varchar(50) default '' not null comment '标签图标',
    ref_count   int         default 0  not null comment '引用次数',
    del_flag    tinyint(1)  default 0  not null comment '逻辑删除'
    ) comment '标签
 @Fac;'
    row_format = DYNAMIC;

