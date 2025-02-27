package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.StarMapper;
import com.only4.application.queries.star.GetStarStatisticsByMemberIdQry;
import com.only4.domain.aggregates.star.StarStatistic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GetStarStatisticByMemberIdQry查询请求适配实现 </br>
 * 根据 MemberId 获取星球统计
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetStarStatisticsByMemberIdQryHandler implements Query<GetStarStatisticsByMemberIdQry.Request, GetStarStatisticsByMemberIdQry.Response> {
    private final StarMapper starMapper;
    @Override
    public GetStarStatisticsByMemberIdQry.Response exec(GetStarStatisticsByMemberIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        List<StarStatistic> starStatistics = starMapper.getStarStatisticsByMemberId(request.getMemberId());
        return GetStarStatisticsByMemberIdQry.Response.builder()
                .starStatistics(starStatistics)
                .build();
    }
}