package com.only4.application.queries.member;

import com.only4.domain.aggregates.member.Favorite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
public class GetFavoritesByFavoritesIdQry {
    /**
     * GetFavoritesByFavoritesIdQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Long FavoritesId;
    }

    /**
     * GetFavoritesByFavoritesIdQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        Favorite favorite;
    }
}