package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.MemberMapper;
import com.only4.application.queries.member.CountFavoriteRecordByMemberIdAndDateQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * CountFavoriteRecordByMemberIdAndDateQry查询请求适配实现 </br>
 * 根据 用户ID 统计用户 当天 的收藏文章数
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CountFavoriteRecordByMemberIdAndDateQryHandler implements Query<CountFavoriteRecordByMemberIdAndDateQry.Request, CountFavoriteRecordByMemberIdAndDateQry.Response> {
    private final MemberMapper memberMapper;
    @Override
    public CountFavoriteRecordByMemberIdAndDateQry.Response exec(CountFavoriteRecordByMemberIdAndDateQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Integer counts = memberMapper.countFavoriteRecordByMemberIdAndDate(request.getMemberId());
        return CountFavoriteRecordByMemberIdAndDateQry.Response.builder().counts(counts).build();
    }
}