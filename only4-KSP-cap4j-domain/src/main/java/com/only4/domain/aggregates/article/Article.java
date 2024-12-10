package com.only4.domain.aggregates.article;

import com.only4.domain.aggregates.article.enums.ArticleState;
import com.only4.domain.aggregates.article.events.ArticleCreatedDomainEvent;
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
 * 文章
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@Aggregate(aggregate = "Article", name = "Article", root = true, type = Aggregate.TYPE_ENTITY, description = "文章")
@Entity
@Table(name = "`article`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update article set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Article {

    // 【行为方法开始】

    public void create() {
        events().attach(new ArticleCreatedDomainEvent(this), this);
    }

    public void privatization() {
        this.state = ArticleState.PRIVATE;
    }

    public void publish() {
        this.state = ArticleState.PUBLISH;

    }

    public void changeArticleInfo(String newTitle, String newDescription) {
        this.title = newTitle;
        this.description = newDescription;
    }

    public void ban() {
        this.state = ArticleState.BANNED;

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
     * 作者ID
     * bigint
     */
    @Column(name = "`author_id`")
    Long authorId;

    /**
     * 文章状态
     * 0:PRIVATE:PRIVATE
     * 1:PUBLISH:PUBLISH
     * 2:BANNED:BANNED
     * int
     */
    @Convert(converter = ArticleState.Converter.class)
    @Column(name = "`state`")
    ArticleState state;

    /**
     * 内容
     * varchar(255)
     */
    @Column(name = "`content`")
    String content;

    /**
     * 标题
     * varchar(255)
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
     * 价格
     * bigint
     */
    @Column(name = "`price`")
    Long price;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}

