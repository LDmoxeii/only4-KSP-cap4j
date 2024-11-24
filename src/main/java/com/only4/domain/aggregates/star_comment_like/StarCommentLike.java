package com.only4.domain.aggregates.star_comment_like;

import com.only4.domain.aggregates.star_comment_like.events.StarCommentLikedDomainEvent;
import com.only4.domain.aggregates.star_comment_like.events.StarCommentUnLikedDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

import static org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport.events;

/**
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@Aggregate(aggregate = "star_comment_like", name = "StarCommentLike", root = true, type = Aggregate.TYPE_ENTITY, description = "")
@Entity
@Table(name = "`star_comment_like`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `star_comment_like` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class StarCommentLike {

    // 【行为方法开始】

    public void create() {
        events().attach(new StarCommentLikedDomainEvent(this), this);
    }

    public void delete() {
        events().attach(new StarCommentUnLikedDomainEvent(this), this);
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
     * 评论ID
     * bigint
     */
    @Column(name = "`comment_id`")
    Long commentId;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


