package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleAuthorInfoCmd;
import com.only4.application.commands.article_comment.UpdateArticleCommentInfoCmd;
import com.only4.application.commands.article_comment_reply.UpdateArticleCommentReplyInfoCmd;
import com.only4.application.commands.member.UpdateBlackMemberInfoCmd;
import com.only4.application.commands.member.UpdateFollowMemberInfoCmd;
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

import java.util.List;
import java.util.Optional;

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

        List<Article> articles = Mediator.queries().send(GetArticlesByMemberIdQry.Request.builder()
                .memberId(member.getId())
                .build()).getArticles();

        articles.forEach(article -> Optional.of(UpdateArticleAuthorInfoCmd.Request.builder()
                        .articleId(article.getId())
                        .memberId(member.getId())
                        .memberName(member.getNickName())
                        .build())
                .ifPresent(Mediator.commands()::send)
        );
    }

    @EventListener(MemberInfoUpdatedDomainEvent.class)
    public void UpdateArticleCommentInfo(MemberInfoUpdatedDomainEvent event) {
        val member = event.getEntity();

        List<ArticleComment> comments = Mediator.queries().send(GetArticleCommentsByMemberIdQry.Request.builder()
                .memberId(member.getId())
                .build()).getComments();

        comments.forEach(comment -> Optional.of(UpdateArticleCommentInfoCmd.Request.builder()
                        .commentId(comment.getId())
                        .memberId(member.getId())
                        .memberName(member.getNickName())
                        .build())
                .ifPresent(Mediator.commands()::send));
    }

    @EventListener(MemberInfoUpdatedDomainEvent.class)
    public void UpdateArticleCommentReply(MemberInfoUpdatedDomainEvent event) {
        val member = event.getEntity();

        List<ArticleCommentReply> replies = Mediator.queries().send(GetArticleCommentRepliesByMemberIdQry.Request.builder()
                .memberId(member.getId())
                .build()).getReplies();

        replies.forEach(reply -> Optional.of(UpdateArticleCommentReplyInfoCmd.Request.builder()
                        .replyId(reply.getId())
                        .memberId(member.getId())
                        .memberName(member.getNickName())
                        .build())
                .ifPresent(Mediator.commands()::send));
    }

    @EventListener(MemberInfoUpdatedDomainEvent.class)
    public void updateBlackMemberInfo(MemberInfoUpdatedDomainEvent event) {
        val other = event.getEntity();

        Mediator.repositories()
                .find(JpaPredicate.bySpecification(Member.class,
                        MemberSchema.specify(member ->
                                member.joinBlockMember(Schema.JoinType.INNER)
                                        .otherId().equal(other.getId())
                        )))
                .forEach(member -> Optional.of(UpdateBlackMemberInfoCmd.Request.builder()
                                .memberId(member.getId())
                                .otherId(other.getId())
                                .otherName(other.getNickName())
                                .build())
                        .ifPresent(Mediator.commands()::send));
    }

    @EventListener(MemberInfoUpdatedDomainEvent.class)
    public void updateFollowMemberInfo(MemberInfoUpdatedDomainEvent event) {
        val other = event.getEntity();

        Mediator.repositories()
                .find(JpaPredicate.bySpecification(Member.class,
                        MemberSchema.specify(member ->
                                member.joinFollowMember(Schema.JoinType.INNER)
                                        .otherId().equal(other.getId())
                        )))
                .forEach(member -> Optional.of(UpdateFollowMemberInfoCmd.Request.builder()
                                .memberId(member.getId())
                                .otherId(other.getId())
                                .otherName(other.getNickName())
                                .build())
                        .ifPresent(Mediator.commands()::send)
                );
    }
}
