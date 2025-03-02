package com.only4.domain.aggregates.tag;

import com.only4.domain.aggregates.tag.events.UpdatedTagInfoDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import static org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport.events;


/**
 * 标签
 * <p>
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@Aggregate(aggregate = "Tag", name = "Tag", root = true, type = Aggregate.TYPE_ENTITY, description = "标签")
@Entity
@Table(name = "`tag`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `tag` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Tag {

    // 【行为方法开始】
    public void create() {

    }

    public void updateInfo(@NotBlank String name, @NotBlank String description, @NotBlank String icon) {
        this.name = name;
        this.description = description;
        this.icon = icon;

        events().attach(new UpdatedTagInfoDomainEvent(this), this);

    }

    public void updateRefCount(@NotNull Integer refCount) {
        this.refCount = this.getRefCount() + refCount;
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
     * 标签名
     * varchar(50)
     */
    @Column(name = "`name`")
    String name;

    /**
     * 标签描述
     * varchar(255)
     */
    @Column(name = "`description`")
    String description;

    /**
     * 标签图标
     * varchar(50)
     */
    @Column(name = "`icon`")
    String icon;

    /**
     * 引用次数
     * int
     */
    @Column(name = "`ref_count`")
    Integer refCount;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


