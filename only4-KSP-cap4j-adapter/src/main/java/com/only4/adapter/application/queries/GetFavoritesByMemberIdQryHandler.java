package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.MemberMapper;
import com.only4.application.queries.member.GetFavoritesByMemberIdQry;
import com.only4.domain.aggregates.member.Favorites;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GetFavoriteListByMemberIdQryHandler查询请求适配实现 </br>
 * 根据 用户ID 获取收藏夹列表，返回 List<Favorite>
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetFavoritesByMemberIdQryHandler implements Query<GetFavoritesByMemberIdQry.Request, GetFavoritesByMemberIdQry.Response> {
    private final MemberMapper memberMapper;
    @Override
    public GetFavoritesByMemberIdQry.Response exec(GetFavoritesByMemberIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        List<Favorites> favorites = memberMapper.getFavoritesByMemberId(request.getMemberId());
        return GetFavoritesByMemberIdQry.Response.builder()
                .favorites(favorites)
                .build();
    }
}
