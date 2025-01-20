package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.OrderMapper;
import com.only4.adapter.infra.mybatis.mapper.TagMapper;
import com.only4.application.queries.tag.ExistedByNameQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * ExistedByNameQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExistedByNameQryHandler implements Query<ExistedByNameQry.Request, ExistedByNameQry.Response> {
    private final TagMapper tagMapper;
    @Override
    public ExistedByNameQry.Response exec(ExistedByNameQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Boolean isExists = tagMapper.existedByName(request.getName());
        return ExistedByNameQry.Response.builder()
                .existed(isExists)
                .build();
    }
}