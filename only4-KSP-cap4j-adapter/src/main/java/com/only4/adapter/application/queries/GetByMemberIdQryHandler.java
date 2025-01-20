package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.StarMapper;
import com.only4.application.queries.star.GetByMemberIdQry;
import com.only4.domain.aggregates.star.Star;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GetByMemberIdQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetByMemberIdQryHandler implements Query<GetByMemberIdQry.Request, GetByMemberIdQry.Response> {
    private final StarMapper starMapper;
    @Override
    public GetByMemberIdQry.Response exec(GetByMemberIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        List<Star> stars = starMapper.getByMemberId(request.getMemberId());
        return GetByMemberIdQry.Response.builder().stars(stars).build();
    }
}