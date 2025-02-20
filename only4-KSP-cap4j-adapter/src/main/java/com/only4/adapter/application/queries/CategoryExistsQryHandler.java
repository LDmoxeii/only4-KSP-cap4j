package com.only4.adapter.application.queries;

import com.only4.application.queries.category.CategoryExistsQry;
import com.only4.domain.aggregates.category.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * CategoryExistsQry查询请求适配实现
 * 判断分类是否存在
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/20
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryExistsQryHandler implements Query<CategoryExistsQry.Request, CategoryExistsQry.Response> {

    @Override
    public CategoryExistsQry.Response exec(CategoryExistsQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        return CategoryExistsQry.Response.builder()
                .exists(Mediator.repositories().exists(JpaPredicate.byId(Category.class,
                        request.getCategoryId())
                ))
                .build();
    }
}
