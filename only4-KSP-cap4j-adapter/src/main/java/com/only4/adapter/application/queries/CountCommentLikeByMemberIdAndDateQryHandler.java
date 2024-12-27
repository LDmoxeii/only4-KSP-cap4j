package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.ArticleMapper;
import com.only4.application.queries.article.CountCommentLikeByMemberIdAndDateQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * CountCommentLikeByMemberIdAndDateQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/27
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CountCommentLikeByMemberIdAndDateQryHandler implements Query<CountCommentLikeByMemberIdAndDateQry.Request, CountCommentLikeByMemberIdAndDateQry.Response> {
    private final ArticleMapper articleMapper;
    @Override
    public CountCommentLikeByMemberIdAndDateQry.Response exec(CountCommentLikeByMemberIdAndDateQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Integer counts = articleMapper.countCommentLikeByMemberIdAndDate(request.getMemberId(), request.getCreateAt());
        return CountCommentLikeByMemberIdAndDateQry.Response.builder()
                .counts(counts)
                .build();
    }
}