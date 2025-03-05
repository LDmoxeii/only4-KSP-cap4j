package com.only4.domain.aggregates.star;

import com.only4.domain.aggregates.star.events.CreatedStarDomainEvent;
import com.only4.domain.aggregates.star.events.StarCommentCountUpdatedDomainEvent;
import com.only4.domain.aggregates.star.events.StarDustCountUpdatedDomainEvent;
import com.only4.domain.aggregates.star.events.StarLikeCountUpdatedDomainEvent;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

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
//    public void create() {
//        events().attach(new CreatedStarDomainEvent(this), this);
//    }
    public void create() {
        events().attach(new CreatedStarDomainEvent(this), this);
    }

    public void updateInfo(String newName, String newDescription, Long newPrice) {

    }
    public void delete() {
        this.delFlag = true;
    }
    public void updateStarCommentCount(@NotBlank(message = "评论数不能为空") Integer commentCount) {
            this.getStarStatistic().updateCommentCount(commentCount);
            events().attach(new StarCommentCountUpdatedDomainEvent(this, commentCount),this);
    }
    public void updateStardustCount(@NotBlank(message = "星尘数不能为空") Integer stardustCount) {
        this.getStarStatistic().updateStarDustCount(stardustCount);
        events().attach(new StarDustCountUpdatedDomainEvent(this, stardustCount),this);
    }
    public void updateStarLikeCount(@NotBlank(message = "点赞数不能为空") Integer likeCount) {
        this.getStarStatistic().updateLikeCount(likeCount);
        events().attach(new StarLikeCountUpdatedDomainEvent(this, likeCount),this);
    }
    // 【行为方法结束】


    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`star_id`", nullable = false)
    @Getter(lombok.AccessLevel.PROTECTED)
    private java.util.List<com.only4.domain.aggregates.star.StarStatistic> starStatistics;

    public com.only4.domain.aggregates.star.StarStatistic getStarStatistic() {
        return starStatistics == null || starStatistics.size() == 0 ? null : starStatistics.get(0);
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
     * bigint
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


