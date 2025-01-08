package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.ArticleMapper;
import com.only4.application.queries.article.CountArticleLikeByMemberIdAndDateQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * CountArticleLikeByMemberIdAndDateQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/27
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CountArticleLikeByMemberIdAndDateQryHandler implements Query<CountArticleLikeByMemberIdAndDateQry.Request, CountArticleLikeByMemberIdAndDateQry.Response> {
    private final ArticleMapper articleMapper;
    @Override
    public CountArticleLikeByMemberIdAndDateQry.Response exec(CountArticleLikeByMemberIdAndDateQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Integer counts = articleMapper.countArticleLikeByMemberIdAndDate(request.getMemberId(), request.getLikeTime());
        return CountArticleLikeByMemberIdAndDateQry.Response.builder()
                .counts(counts)
                .build();
    }
}