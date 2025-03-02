package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.ArticleMapper;
import com.only4.application.queries.article.ExistedArticleByArticleCategoryIdQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * ExistedArticleByArticleCategoryIdQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/22
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExistedArticleByArticleCategoryIdQryHandler implements Query<ExistedArticleByArticleCategoryIdQry.Request, ExistedArticleByArticleCategoryIdQry.Response> {
    private final ArticleMapper articleMapper;
    @Override
    public ExistedArticleByArticleCategoryIdQry.Response exec(ExistedArticleByArticleCategoryIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Boolean isExists = articleMapper.existedByCategoryId(request.getCategoryId());
        return ExistedArticleByArticleCategoryIdQry.Response.builder()
                .existed(isExists)
                .build();
    }
}