package com.only4.domain.aggregates.article_comment_like;

import apache.rocketmq.v2.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.ValueObject;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

/**
 * 文章评论点赞
 * <p>
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/17
 */
@Aggregate(aggregate = "ArticleCommentLike", name = "ArticleCommentLike", root = true, type = Aggregate.TYPE_VALUE_OBJECT, description = "文章评论点赞")
@Entity
@Table(name = "`article_comment_like`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `article_comment_like` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ArticleCommentLike implements ValueObject<Long> {

    // 【行为方法开始】


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
        if (!(o instanceof Address)) {
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
     * 评论ID
     * bigint
     */
    @Column(name = "`article_comment_id`")
    Long articleCommentId;

    /**
     * 点赞用户ID
     * bigint
     */
    @Column(name = "`member_id`")
    Long memberId;

    /**
     * 点赞时间
     * timestamp
     */
    @Column(name = "`create_at`")
    java.time.LocalDateTime createAt;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


