package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.MemberMapper;
import com.only4.application.queries.member.GetFavoriteByFavoritesIdQry;
import com.only4.domain.aggregates.member.Favorite;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * GetFavoritesByFavoritesIdQry查询请求适配实现 </br>
 * 根据 收藏夹ID 获取 收藏夹信息
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetFavoriteByFavoriteIdQryHandler implements Query<GetFavoriteByFavoritesIdQry.Request, GetFavoriteByFavoritesIdQry.Response> {
    private final MemberMapper memberMapper;
    @Override
    public GetFavoriteByFavoritesIdQry.Response exec(GetFavoriteByFavoritesIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Favorite favorite = memberMapper.getFavoriteByFavoriteId(request.getFavoriteId());
        return GetFavoriteByFavoritesIdQry.Response.builder()
                .favorite(favorite)
                .build();
    }
}
