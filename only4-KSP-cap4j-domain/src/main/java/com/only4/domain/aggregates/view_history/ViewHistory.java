package com.only4.domain.aggregates.view_history;

import com.only4.domain.aggregates.view_history.events.ViewHistoryCreatedDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.ValueObject;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import static org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport.events;

/**
 * 会员历史记录
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2025/02/18
 */
@Aggregate(aggregate = "ViewHistory", name = "ViewHistory", root = true, type = Aggregate.TYPE_VALUE_OBJECT, description = "会员历史记录")
@Entity
@Table(name = "`view_history`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `view_history` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ViewHistory implements ValueObject<Long> {

    // 【行为方法开始】

    public void create() {
        events().attach(new ViewHistoryCreatedDomainEvent(this), this);
    }

    // 【行为方法结束】



    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @Override
    public Long hash() {
        if(null == id) {
            id = (Long) org.netcorepal.cap4j.ddd.domain.repo.Md5HashIdentifierGenerator.hash(this, "id");
        }
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (null == o) {
            return false;
        }
        if (!(o instanceof ViewHistory)) {
            return false;
        }
        return hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        return hash().hashCode();
    }


    /**
     * ID
     * bigint
     */
    @Id
    @GeneratedValue(generator = "org.netcorepal.cap4j.ddd.domain.repo.Md5HashIdentifierGenerator")
    @GenericGenerator(name = "org.netcorepal.cap4j.ddd.domain.repo.Md5HashIdentifierGenerator", strategy = "org.netcorepal.cap4j.ddd.domain.repo.Md5HashIdentifierGenerator")
    @Column(name = "`id`")
    Long id;

    /**
     * 会员ID
     * bigint
     */
    @Column(name = "`member_id`")
    Long memberId;

    /**
     * 文章ID
     * bigint
     */
    @Column(name = "`article_id`")
    Long articleId;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


