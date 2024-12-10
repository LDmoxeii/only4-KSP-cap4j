package com.only4.domain.aggregates.favorites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

/**
 * 收藏夹
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@Aggregate(aggregate = "Favorites", name = "Favorites", root = true, type = Aggregate.TYPE_ENTITY, description = "收藏夹")
@Entity
@Table(name = "`favorites`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `favorites` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Favorites {

    // 【行为方法开始】

    public void create() {

    }

    public void updateInfo(String newTitle, String newDescription) {
        this.title = newTitle;
        this.description = newDescription;
    }

    public void delete() {

    }

    // 【行为方法结束】



    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    /**
     * ID
     * bigint
     */
    @Id
    @GeneratedValue(generator = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator")
    @GenericGenerator(name = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator", strategy = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator")
    @Column(name = "`id`")
    Long id;

    /**
     * 消费者ID
     * bigint
     */
    @Column(name = "`customer_id`")
    Long customerId;

    /**
     * 标题
     * varchar(20)
     */
    @Column(name = "`title`")
    String title;

    /**
     * 描述
     * varchar(255)
     */
    @Column(name = "`description`")
    String description;

    /**
     * 收藏夹状态
     * 0:INIT:INIT
     * int
     */
    @Convert(converter = com.only4.domain.aggregates.favorites.enums.FavoritesState.Converter.class)
    @Column(name = "`state`")
    com.only4.domain.aggregates.favorites.enums.FavoritesState state;

    /**
     * 默认标识
     * tinyint(1)
     */
    @Column(name = "`def`")
    Boolean def;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


