create table stardust
    (
    id        bigint                                   not null comment 'ID' primary key,
    star_id   bigint                                   not null comment '星球ID',
    name      varchar(50)                              not null comment '星尘名',
    create_at timestamp                                not null comment '吸引时间',
    del_at    timestamp  default '1970-01-01 00:00:01' not null comment '逃逸时间',
    del_flag  tinyint(1) default 0                     not null comment '逻辑删除'
    ) comment '星尘
 @P=star;
 @L=true;'
    row_format = DYNAMIC;

