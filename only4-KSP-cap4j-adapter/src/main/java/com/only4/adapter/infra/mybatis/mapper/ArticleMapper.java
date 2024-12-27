package com.only4.adapter.infra.mybatis.mapper;

import com.only4.domain.aggregates.article.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    Boolean existedCommentByArticleId(Long Id);
    Boolean existedByCategoryId(Long categoryId);
    Boolean existedByTagId(Long tagId);
    Boolean existedCommentLikeByCommentIdAndMemberId(Long CommentId, Long MemberId);
    Integer countArticleLikeByMemberIdAndDate(Long MemberId,java.time.LocalDateTime likeTime);
    Integer countCommentLikeByMemberIdAndDate(Long MemberId,java.time.LocalDateTime createAt);
    Integer countCommentByMemberIdAndDate(Long authorId,java.time.LocalDateTime createAt);
}
