create table `order`
    (
    id       bigint               not null comment 'ID' primary key,
    amount   int                  not null comment '订单金额',
    price    int                  not null comment '实付金额',
    state    tinyint    default 0 not null comment '状态',
    del_flag tinyint(1) default 0 not null comment '逻辑删除'
    ) comment '订单
 @Fac;'
    row_format = DYNAMIC;

