create table category
    (
    id        bigint               not null comment 'ID' primary key,
    name      varchar(50)          not null comment '名称',
    ref_count int        default 0 not null comment '引用次数',
    del_flag  tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '分类   
 @Fac;'
    row_format = DYNAMIC;

