package com.only4.domain.aggregates.star;

import com.only4.domain.aggregates.star.events.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Objects;

import static org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport.events;

/**
 * 星球
 * <p>
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/23
 */
@Aggregate(aggregate = "Star", name = "Star", root = true, type = Aggregate.TYPE_ENTITY, description = "星球")
@Entity
@Table(name = "`star`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update `star` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Star {

    // 【行为方法开始】
    public void create() {
        events().attach(new StarCreatedDomainEvent(this), this);
    }

    public void updateInfo(String newName, String newDescription) {
        this.name = newName;
        this.description = newDescription;
        events().attach(new StarInfoUpdatedDomainEvent(this), this);
    }

    public void updateAmount(Integer newAmount) {
        this.amount = newAmount;
    }

    public void updateStarCommentCount(Integer newComment) {
        this.getStarStatistic().comments = newComment;
    }

    public void updateStarLikeCount(Integer newLikeCount) {
        this.getStarStatistic().likes = newLikeCount;
        events().attach(new StarLikeCountUpdatedDomainEvent(this), this);
    }

    public void updateStardustCount(Integer newStardustCount) {
        this.getStarStatistic().stardust = newStardustCount;
    }

    public void delete() {
        events().attach(new StarDeletedDomainEvent(this), this);
    }

    public void joinStar(Stardust newStardust) {
        this.getStardusts().add(newStardust);
        events().attach(new JoinedStarDomainEvent(this), this);
    }

    public void leaveStar(Long stardustId) {
        this.getStardusts().stream()
                .filter(sd -> Objects.equals(sd.getId(), stardustId))
                .findFirst()
                .ifPresent(stardust -> this.getStardusts().remove(stardust));
        events().attach(new LeftStarDomainEvent(this), this);
    }

    public void likeStar(StarLike newStarLike) {
        this.getStarLikes().add(newStarLike);
        this.updateStarLikeCount(1);
        events().attach(new StarLikedDomainEvent(this), this);
    }

    public void unlikeStar(Long starLikeId) {
        this.getStarLikes().stream()
                .filter(sl -> Objects.equals(sl.getId(), starLikeId))
                .findFirst()
                .ifPresent(starLike -> this.getStarLikes().remove(starLike));
        this.updateStarLikeCount(-1);
        events().attach(new StarUnlikedDomainEvent(this), this);
    }

    public void createStarComment(StarComment newComment) {
        this.getStarComments().add(newComment);
        this.updateStarCommentCount(1);
        events().attach(new StarCommentCreatedDomainEvent(this), this);
    }

    public void deleteStarComment(Long starCommentId) {
        this.getStarComments().stream()
                .filter(sc -> Objects.equals(sc.getId(), starCommentId))
                .findFirst()
                .ifPresent(starComment -> this.getStarComments().remove(starComment));
        this.updateStarCommentCount(-1);
        events().attach(new StarCommentDeletedDomainEvent(this), this);
    }

    public void likeStarComment(Long starCommentId, StarCommentLike newStarCommentLike) {
        this.getStarComments().stream()
                .filter(sc -> Objects.equals(sc.getId(), starCommentId))
                .findFirst()
                .ifPresent(starComment -> starComment.likeStarComment(newStarCommentLike));
        events().attach(new StarCommentLikeCountUpdatedDomainEvent(this), this);
        events().attach(new StarCommentLikedDomainEvent(this), this);
    }

    public void unlikeStarComment(Long starCommentId, Long starCommentLikeId) {
        this.getStarComments().stream()
                .filter(sc -> Objects.equals(sc.getId(), starCommentId))
                .findFirst()
                .ifPresent(starComment -> starComment.unlikeStarComment(starCommentLikeId));
        events().attach(new StarCommentLikeCountUpdatedDomainEvent(this), this);
        events().attach(new StarCommentUnlikedDomainEvent(this), this);
    }

    // 【行为方法结束】


    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`star_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.star.Stardust> stardusts;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`star_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.star.StarComment> starComments;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`star_id`", nullable = false)
    @Getter(lombok.AccessLevel.PROTECTED)
    private java.util.List<com.only4.domain.aggregates.star.StarStatistic> starStatistics;

    public com.only4.domain.aggregates.star.StarStatistic getStarStatistic() {
        return starStatistics == null || starStatistics.size() == 0 ? null : starStatistics.get(0);
    }

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`star_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.star.StarLike> starLikes;

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
     * 星主ID
     * bigint
     */
    @Column(name = "`member_id`")
    Long memberId;

    /**
     * 星球名
     * varchar(50)
     */
    @Column(name = "`name`")
    String name;

    /**
     * 星球描述
     * varchar(255)
     */
    @Column(name = "`description`")
    String description;

    /**
     * 星球价格
     * int
     */
    @Column(name = "`amount`")
    Integer amount;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


