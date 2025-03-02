package com.only4.domain.aggregates.star_comment_reply;

import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.star_comment_reply.events.StarCommentReplyCreatedDomainEvent;
import com.only4.domain.aggregates.star_comment_reply.events.StarCommentReplyDeletedDomainEvent;
import com.only4.domain.aggregates.star_comment_reply.events.StarCommentReplyLikeCountUpdatedDomainEvent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.Objects;

import static org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport.events;

/**
 * 星球评论回复
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2025/02/23
 */
@Aggregate(aggregate = "StarCommentReply", name = "StarCommentReply", root = true, type = Aggregate.TYPE_ENTITY, description = "星球评论回复")
@Entity
@Table(name = "`star_comment_reply`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `star_comment_reply` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class StarCommentReply {

    // 【行为方法开始】

    public void create() {
        events().attach(new StarCommentReplyCreatedDomainEvent(this), this);
    }
    public void delete() {
        events().attach(new StarCommentReplyDeletedDomainEvent(this), this);
    }

    public void updateInfo(@Positive Long memberId, @NotBlank(message = "评论人名称不能为空") String memberName) {
        if(this.isAuthor(memberId)) {
            throw new KnownException("不是作者，不能修改");
        }

        this.authorName = memberName;
    }

    public boolean isAuthor(@Positive Long memberId) {
        return Objects.equals(this.getAuthorId(), memberId);
    }

    public void updateLikeCount(@NotNull Integer likeCount) {
        this.getStarCommentReplyStatistics().updateLikeCount(likeCount);
        events().attach(new StarCommentReplyLikeCountUpdatedDomainEvent(this, likeCount), this);
    }

    public void updateReportCount(@NotNull Integer reportCount) {
        this.getStarCommentReplyStatistics().updateReportCount(reportCount);
    }

    // 【行为方法结束】



    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`star_comment_reply_id`", nullable = false)
    @Getter(lombok.AccessLevel.PROTECTED)
    private java.util.List<com.only4.domain.aggregates.star_comment_reply.StarCommentReplyStatistics> starCommentReplyStatistics;

    public com.only4.domain.aggregates.star_comment_reply.StarCommentReplyStatistics getStarCommentReplyStatistics() {
        return starCommentReplyStatistics == null || starCommentReplyStatistics.size() == 0 ? null : starCommentReplyStatistics.get(0);
    }

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
     * 星球评论ID
     * bigint
     */
    @Column(name = "`star_comment_id`")
    Long starCommentId;

    /**
     * 作者ID
     * bigint
     */
    @Column(name = "`author_id`")
    Long authorId;

    /**
     * 作者名
     * varchar(50)
     */
    @Column(name = "`author_name`")
    String authorName;

    /**
     * 内容
     * varchar(255)
     */
    @Column(name = "`content`")
    String content;

    /**
     * 创建时间
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


