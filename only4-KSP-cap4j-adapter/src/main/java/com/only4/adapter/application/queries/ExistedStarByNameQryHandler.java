package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.StarMapper;
import com.only4.adapter.infra.mybatis.mapper.TagMapper;
import com.only4.application.queries.star.ExistedStarByNameQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * ExistedStarByNameQry查询请求适配实现 </br>
 * 根据 星球名 判断星球是否存在
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExistedStarByNameQryHandler implements Query<ExistedStarByNameQry.Request, ExistedStarByNameQry.Response> {
    private final StarMapper starMapper;
    @Override
    public ExistedStarByNameQry.Response exec(ExistedStarByNameQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Boolean isExists = starMapper.existedStarByName(request.getName());
        return ExistedStarByNameQry.Response.builder()
                .existed(isExists)
                .build();
    }
}