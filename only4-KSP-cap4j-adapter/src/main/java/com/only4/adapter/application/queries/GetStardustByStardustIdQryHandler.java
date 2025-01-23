package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.StarMapper;
import com.only4.application.queries.star.GetStardustByStardustIdQry;
import com.only4.domain.aggregates.star.Stardust;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * GetStardustByStardustIdQry查询请求适配实现 </br>
 * 根据 星尘ID 获取星尘
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetStardustByStardustIdQryHandler implements Query<GetStardustByStardustIdQry.Request, GetStardustByStardustIdQry.Response> {
    private final StarMapper starMapper;
    @Override
    public GetStardustByStardustIdQry.Response exec(GetStardustByStardustIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Stardust stardust = starMapper.getStardustByStardustId(request.getStardustId());
        return GetStardustByStardustIdQry.Response.builder().stardust(stardust).build();
    }
}