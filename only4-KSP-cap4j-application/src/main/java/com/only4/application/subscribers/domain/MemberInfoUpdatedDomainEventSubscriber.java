package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleAuthorInfoBatchCmd;
import com.only4.application.commands.article_comment.UpdateArticleCommentInfoBatchCmd;
import com.only4.application.commands.article_comment_reply.UpdateArticleCommentReplyInfoBatchCmd;
import com.only4.application.commands.member.UpdateBlackMemberInfoBatchCmd;
import com.only4.application.commands.member.UpdateFollowMemberInfoBatchCmd;
import com.only4.application.queries.article.GetArticlesByMemberIdQry;
import com.only4.application.queries.article_comment.GetArticleCommentsByMemberIdQry;
import com.only4.application.queries.article_comment_reply.GetArticleCommentRepliesByMemberIdQry;
import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article_comment.ArticleComment;
import com.only4.domain.aggregates.article_comment_reply.ArticleCommentReply;
import com.only4.domain.aggregates.member.Member;
import com.only4.domain.aggregates.member.events.MemberInfoUpdatedDomainEvent;
import com.only4.domain.aggregates.member.meta.MemberSchema;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Member.MemberInfoUpdatedDomainEvent领域事件订阅
 * 用户信息已更新
 */
@Service
@RequiredArgsConstructor
public class MemberInfoUpdatedDomainEventSubscriber {

    @EventListener(MemberInfoUpdatedDomainEvent.class)
    public void updateArticleAuthorInfo(MemberInfoUpdatedDomainEvent event) {
        val member = event.getEntity();

        Set<Long> ids = Mediator.queries().send(GetArticlesByMemberIdQry.Request.builder()
                        .memberId(member.getId())
                        .build()).getArticles().stream()
                .map(Article::getId)
                .collect(Collectors.toSet());

        Optional.of(UpdateArticleAuthorInfoBatchCmd.Request.builder()
                .articleIds(ids)
                .authorId(member.getId())
                .authorName(member.getNickName())
                .build()).ifPresent(Mediator.commands()::send);
    }

    @EventListener(MemberInfoUpdatedDomainEvent.class)
    public void UpdateArticleCommentInfo(MemberInfoUpdatedDomainEvent event) {
        val member = event.getEntity();

        Set<Long> ids = Mediator.queries().send(GetArticleCommentsByMemberIdQry.Request.builder()
                        .memberId(member.getId())
                        .build()).getComments().stream()
                .map(ArticleComment::getId)
                .collect(Collectors.toSet());

        Optional.of(UpdateArticleCommentInfoBatchCmd.Request.builder()
                .articleCommentIds(ids)
                .authorId(member.getId())
                .authorName(member.getNickName())
                .build()).ifPresent(Mediator.commands()::send);
    }

    @EventListener(MemberInfoUpdatedDomainEvent.class)
    public void UpdateArticleCommentReplyInfo(MemberInfoUpdatedDomainEvent event) {
        val member = event.getEntity();

        Set<Long> ids = Mediator.queries().send(GetArticleCommentRepliesByMemberIdQry.Request.builder()
                        .memberId(member.getId())
                        .build()).getReplies().stream()
                .map(ArticleCommentReply::getId)
                .collect(Collectors.toSet());

        Optional.of(UpdateArticleCommentReplyInfoBatchCmd.Request.builder()
                .articleCommentReplyIds(ids)
                .authorId(member.getId())
                .authorName(member.getNickName())
                .build()).ifPresent(Mediator.commands()::send);
    }

    @EventListener(MemberInfoUpdatedDomainEvent.class)
    public void updateBlackMemberInfo(MemberInfoUpdatedDomainEvent event) {
        val other = event.getEntity();

        Set<Long> ids = Mediator.repositories()
                .find(JpaPredicate.bySpecification(Member.class,
                        MemberSchema.specify(member ->
                                member.joinBlockMember(Schema.JoinType.INNER)
                                        .otherId().equal(other.getId())
                        ))).stream()
                .map(Member::getId)
                .collect(Collectors.toSet());

        Optional.of(UpdateBlackMemberInfoBatchCmd.Request.builder()
                .memberIds(ids)
                .otherId(other.getId())
                .otherName(other.getNickName())
                .build()).ifPresent(Mediator.commands()::send);
    }

    @EventListener(MemberInfoUpdatedDomainEvent.class)
    public void updateFollowMemberInfo(MemberInfoUpdatedDomainEvent event) {
        val other = event.getEntity();

        Set<Long> ids = Mediator.repositories()
                .find(JpaPredicate.bySpecification(Member.class,
                        MemberSchema.specify(member ->
                                member.joinFollowMember(Schema.JoinType.INNER)
                                        .otherId().equal(other.getId())
                        ))).stream()
                .map(Member::getId)
                .collect(Collectors.toSet());

        Optional.of(UpdateFollowMemberInfoBatchCmd.Request.builder()
                .memberIds(ids)
                .otherId(other.getId())
                .otherName(other.getNickName())
                .build()).ifPresent(Mediator.commands()::send);
    }
}
