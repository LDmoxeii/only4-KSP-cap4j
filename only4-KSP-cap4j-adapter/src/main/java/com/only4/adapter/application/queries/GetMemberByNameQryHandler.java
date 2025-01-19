package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.MemberMapper;
import com.only4.application.queries.member.GetMemberByNameQry;
import com.only4.domain.aggregates.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * GetMemberByNameQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetMemberByNameQryHandler implements Query<GetMemberByNameQry.Request, GetMemberByNameQry.Response> {
    private final MemberMapper memberMapper;
    @Override
    public GetMemberByNameQry.Response exec(GetMemberByNameQry.Request request) {
        Member member = memberMapper.getMemberByName(request.getName());
        // mybatis / jpa 哪个顺手就用哪个吧！
        return GetMemberByNameQry.Response.builder().member(member).build();
    }
}