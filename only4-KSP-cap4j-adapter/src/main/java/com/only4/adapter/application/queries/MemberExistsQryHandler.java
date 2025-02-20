package com.only4.adapter.application.queries;

import com.only4.application.queries.member.MemberExistsQry;
import com.only4.domain.aggregates.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * MemberExistsQry查询请求适配实现
 * 判断用户是否已存在
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/20
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MemberExistsQryHandler implements Query<MemberExistsQry.Request, MemberExistsQry.Response> {

    @Override
    public MemberExistsQry.Response exec(MemberExistsQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        return MemberExistsQry.Response.builder()
                .exists(Mediator.repositories().exists(JpaPredicate.byId(Member.class, request.getMemberId())))
                .build();
    }
}
