create table member_statistics
    (
    id              bigint               not null comment 'ID' primary key,
    member_id       bigint               not null comment '会员ID',
    `rank`          int        default 0 not null comment '等级分',
    like_count      int        default 0 not null comment '点赞数',
    fan_count       int        default 0 not null comment '粉丝数',
    report_count    int        default 0 not null comment '举报数',
    following_count int        default 0 not null comment '关注数',
    work_count      int        default 0 not null comment '作品数',
    view_count      int                  not null comment '播放量',
    del_flag        tinyint(1) default 0 not null comment '逻辑删除',
    stardust_count  int        default 0 not null comment '星尘数'
    ) comment '会员统计
 @P=member;
 @C=One;
 @L=true;'
    row_format = DYNAMIC;

