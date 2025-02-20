package com.only4.adapter.application.queries;

import com.only4.application.queries.category.CategoryUniqueNameQry;
import com.only4.domain.aggregates.category.Category;
import com.only4.domain.aggregates.category.meta.CategorySchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * CategoryUniqueNameQry查询请求适配实现
 * 判断是否存在同名分类
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/20
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryUniqueNameQryHandler implements Query<CategoryUniqueNameQry.Request, CategoryUniqueNameQry.Response> {

    @Override
    public CategoryUniqueNameQry.Response exec(CategoryUniqueNameQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        return CategoryUniqueNameQry.Response.builder().exists(Mediator.repositories().exists(JpaPredicate.bySpecification(Category.class,
                CategorySchema.specify(category ->
                        category.name().equal(request.getCategoryName())
                ))
        )).build();
    }
}
