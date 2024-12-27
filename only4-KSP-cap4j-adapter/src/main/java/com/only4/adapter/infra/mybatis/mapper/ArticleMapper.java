package com.only4.adapter.infra.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    Boolean existedCommentByArticleId(Long id);
    Boolean existedByCategoryId(Long categoryId);
    Boolean existedByTagId(Long tagId);
    Boolean existedCommentLikeByCommentIdAndMemberId(Long commentId, Long memberId);
    Integer countArticleLikeByMemberIdAndDate(Long memberId,java.time.LocalDateTime likeTime);
    Integer countCommentLikeByMemberIdAndDate(Long memberId,java.time.LocalDateTime createAt);
    Integer countCommentByMemberIdAndDate(Long authorId,java.time.LocalDateTime createAt);
}
