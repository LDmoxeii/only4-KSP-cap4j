package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.CategoryMapper;
import com.only4.application.queries.category.ExistedCategoryByIdQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * ExistedCategoryByIdQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/22
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExistedCategoryByIdQryHandler implements Query<ExistedCategoryByIdQry.Request, ExistedCategoryByIdQry.Response> {
    private final CategoryMapper categoryMapper;
    @Override
    public ExistedCategoryByIdQry.Response exec(ExistedCategoryByIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Boolean isExists = categoryMapper.existedById(request.getId());
        return ExistedCategoryByIdQry.Response.builder()
                .existed(isExists)
                .build();
    }
}
