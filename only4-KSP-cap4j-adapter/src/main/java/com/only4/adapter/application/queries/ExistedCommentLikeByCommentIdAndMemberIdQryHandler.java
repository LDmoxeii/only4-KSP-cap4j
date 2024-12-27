package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.ArticleMapper;
import com.only4.application.queries.article.ExistedCommentLikeByCommentIdAndMemberIdQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * ExistedCommentLikeByCommentIdAndMemberIdQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/27
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExistedCommentLikeByCommentIdAndMemberIdQryHandler implements Query<ExistedCommentLikeByCommentIdAndMemberIdQry.Request, ExistedCommentLikeByCommentIdAndMemberIdQry.Response> {
    private final ArticleMapper articleMapper;
    @Override
    public ExistedCommentLikeByCommentIdAndMemberIdQry.Response exec(ExistedCommentLikeByCommentIdAndMemberIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Boolean isExists = articleMapper.existedCommentLikeByCommentIdAndMemberId(request.getCommentId(), request.getMemberId());
        return ExistedCommentLikeByCommentIdAndMemberIdQry.Response.builder()
                .existed(isExists)
                .build();
    }
}