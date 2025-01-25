package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.StarMapper;
import com.only4.application.queries.star.ExistedStarLikeByStardustIdQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * ExistedStarLikeByStardustIdQry查询请求适配实现 </br>
 * 根据 星尘ID 判断星球点赞是否存在
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExistedStarLikeByStardustIdQryHandler implements Query<ExistedStarLikeByStardustIdQry.Request, ExistedStarLikeByStardustIdQry.Response> {
    private final StarMapper starMapper;
    @Override
    public ExistedStarLikeByStardustIdQry.Response exec(ExistedStarLikeByStardustIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Boolean isExists = starMapper.existedStarLikeByStardustId(request.getStardustId());
        return ExistedStarLikeByStardustIdQry.Response.builder()
                .existed(isExists)
                .build();
    }
}