package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.MemberMapper;
import com.only4.application.queries.member.GetFavoriteByMemberIdQry;
import com.only4.domain.aggregates.member.Favorite;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * GetFavoriteByMemberIdQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetFavoriteByMemberIdQryHandler implements Query<GetFavoriteByMemberIdQry.Request, GetFavoriteByMemberIdQry.Response> {
    private final MemberMapper memberMapper;
    @Override
    public GetFavoriteByMemberIdQry.Response exec(GetFavoriteByMemberIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Favorite favorite = memberMapper.getFavoriteByMemberId(request.getMemberId());
        return GetFavoriteByMemberIdQry.Response.builder()
                .favorite(favorite)
                .build();
    }
}