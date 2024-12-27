package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.CategoryMapper;
import com.only4.application.queries.category.GetCategoryByIdQry;
import com.only4.domain.aggregates.category.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * GetCategoryByIdQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/22
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetCategoryByIdQryHandler implements Query<GetCategoryByIdQry.Request, GetCategoryByIdQry.Response> {
    private final CategoryMapper categoryMapper;
    @Override
    public GetCategoryByIdQry.Response exec(GetCategoryByIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Category category = categoryMapper.getById(request.getId());
        return GetCategoryByIdQry.Response.builder()
                .category(category)
                .build();
    }
}