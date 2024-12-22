package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.CategoryMapper;
import com.only4.application.queries.Category.ExistedCategoryByNameQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * ExistedCategoryByNameQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/22
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExistedCategoryByNameQryHandler implements Query<ExistedCategoryByNameQry.Request, ExistedCategoryByNameQry.Response> {
    private final CategoryMapper categoryMapper;
    @Override
    public ExistedCategoryByNameQry.Response exec(ExistedCategoryByNameQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Boolean isExists = categoryMapper.existedByName(request.getName());
        return ExistedCategoryByNameQry.Response.builder()
                .existed(isExists)
                .build();
    }
}