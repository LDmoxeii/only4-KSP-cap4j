package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.ArticleMapper;
import com.only4.application.queries.article.CountCommentByMemberIdAndDateQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * CountCommentByMemberIdAndDateQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/27
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CountCommentByMemberIdAndDateQryHandler implements Query<CountCommentByMemberIdAndDateQry.Request, CountCommentByMemberIdAndDateQry.Response> {
    private final ArticleMapper articleMapper;
    @Override
    public CountCommentByMemberIdAndDateQry.Response exec(CountCommentByMemberIdAndDateQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Integer counts = articleMapper.countCommentByMemberIdAndDate(request.getAuthorId(), request.getCreateAt());
        return CountCommentByMemberIdAndDateQry.Response.builder()
                .counts(counts)
                .build();
    }
}