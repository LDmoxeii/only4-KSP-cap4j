package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.MemberMapper;
import com.only4.application.queries.member.GetFavoritesByFavoritesIdQry;
import com.only4.domain.aggregates.member.Favorite;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * GetFavoritesByFavoritesIdQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetFavoritesByFavoritesIdQryHandler implements Query<GetFavoritesByFavoritesIdQry.Request, GetFavoritesByFavoritesIdQry.Response> {
    private final MemberMapper memberMapper;
    @Override
    public GetFavoritesByFavoritesIdQry.Response exec(GetFavoritesByFavoritesIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Favorite favorite = memberMapper.getFavoritesByFavoritesId(request.getFavoritesId());
        return GetFavoritesByFavoritesIdQry.Response.builder()
                .favorite(favorite)
                .build();
    }
}