package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.StarMapper;
import com.only4.application.queries.star.GetStarListByMemberIdQry;
import com.only4.domain.aggregates.star.Star;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GetByMemberIdQry查询请求适配实现 </br>
 * 根据 MemberID 获取 星球列表——List<Star>
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetStarListByMemberIdQryHandler implements Query<GetStarListByMemberIdQry.Request, GetStarListByMemberIdQry.Response> {
    private final StarMapper starMapper;
    @Override
    public GetStarListByMemberIdQry.Response exec(GetStarListByMemberIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        List<Star> stars = starMapper.GetStarListByMemberIdQry(request.getMemberId());
        return GetStarListByMemberIdQry.Response.builder().stars(stars).build();
    }
}