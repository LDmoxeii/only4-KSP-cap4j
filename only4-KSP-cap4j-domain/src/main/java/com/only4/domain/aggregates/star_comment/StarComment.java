package com.only4.domain.aggregates.star_comment;

import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.star_comment.events.StarCommentCreatedDomainEvent;
import com.only4.domain.aggregates.star_comment.events.StarCommentLikeCountUpdatedDomainEvent;
import com.only4.domain.aggregates.star_comment.events.StarCommentReplyCountUpdatedDomainEvent;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import java.util.Objects;

import static org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport.events;

/**
 * 星球评论
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2025/02/23
 */
@Aggregate(aggregate = "StarComment", name = "StarComment", root = true, type = Aggregate.TYPE_ENTITY, description = "星球评论")
@Entity
@Table(name = "`star_comment`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `star_comment` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class StarComment {

    // 【行为方法开始】

    public void create() {
        events().attach(new StarCommentCreatedDomainEvent(this), this);
    }

    public void delete() {
        events().attach(new StarCommentCreatedDomainEvent(this), this);
    }

    public void updateLikeCount(@NotNull Integer likeCount) {
        this.getStarCommentStatistics().updateLikeCount(likeCount);

        events().attach(new StarCommentLikeCountUpdatedDomainEvent(this), this);
    }

    public void updateReportCount(@NotNull Integer reportCount) {
        this.getStarCommentStatistics().updateReportCount(reportCount);

        events().attach(new StarCommentReplyCountUpdatedDomainEvent(this), this);
    }

    public void updateReplyCount(@NotNull Integer replyCount) {
        this.getStarCommentStatistics().updateReplyCount(replyCount);
    }

    public void pin() {
        if (this.isPin()) {
            throw new KnownException("评论已置顶");
        }

        this.pinFlag = false;
    }

    private boolean isPin() {
        return this.pinFlag;
    }

    public void unpin() {
        if (!this.isPin()) {
            throw new KnownException("评论未置顶");
        }

        this.pinFlag = true;
    }

    public void updateInfo(@Positive Long memberId, @NotBlank(message = "用户名不能为空") String memberName) {
        if (this.isAuthor(memberId)) {
            throw new KnownException("不是作者，不能修改");
        }

        this.authorName = memberName;
    }

    private boolean isAuthor(@Positive Long memberId) {
        return Objects.equals(this.getAuthorId(), memberId);
    }

    // 【行为方法结束】



    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`star_comment_id`", nullable = false)
    @Getter(lombok.AccessLevel.PROTECTED)
    private java.util.List<com.only4.domain.aggregates.star_comment.StarCommentStatistics> starCommentStatistics;

    public com.only4.domain.aggregates.star_comment.StarCommentStatistics getStarCommentStatistics() {
        return starCommentStatistics == null || starCommentStatistics.size() == 0 ? null : starCommentStatistics.get(0);
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
     * 星球ID
     * bigint
     */
    @Column(name = "`star_id`")
    Long starId;

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
     * 置顶标识
     * tinyint(1)
     */
    @Column(name = "`pin_flag`")
    Boolean pinFlag;

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
