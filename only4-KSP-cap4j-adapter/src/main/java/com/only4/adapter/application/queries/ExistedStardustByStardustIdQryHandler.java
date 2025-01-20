package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.StarMapper;
import com.only4.application.queries.star.ExistedStardustByStardustIdQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * ExistedStardustByStardustIdQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExistedStardustByStardustIdQryHandler implements Query<ExistedStardustByStardustIdQry.Request, ExistedStardustByStardustIdQry.Response> {
    private final StarMapper starMapper;
    @Override
    public ExistedStardustByStardustIdQry.Response exec(ExistedStardustByStardustIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Boolean isExists = starMapper.existedStardustByStardustId(request.getStardustId());
        return ExistedStardustByStardustIdQry.Response.builder()
                .existed(isExists)
                .build();
    }
}