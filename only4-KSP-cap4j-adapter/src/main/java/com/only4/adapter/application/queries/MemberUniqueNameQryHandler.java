package com.only4.adapter.application.queries;

import com.only4.application.queries.member.MemberUniqueNameQry;
import com.only4.domain.aggregates.member.Member;
import com.only4.domain.aggregates.member.meta.MemberSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * MemberUniqueNameQry查询请求适配实现
 * 判断是否有同帐号用户
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/20
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MemberUniqueNameQryHandler implements Query<MemberUniqueNameQry.Request, MemberUniqueNameQry.Response> {

    @Override
    public MemberUniqueNameQry.Response exec(MemberUniqueNameQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        return MemberUniqueNameQry.Response.builder()
                .exists(Mediator.repositories().exists(JpaPredicate.bySpecification(Member.class,
                        MemberSchema.specify(member ->
                                member.name().equal(request.getMemberName())
                        ))
                ))
                .build();
    }
}
