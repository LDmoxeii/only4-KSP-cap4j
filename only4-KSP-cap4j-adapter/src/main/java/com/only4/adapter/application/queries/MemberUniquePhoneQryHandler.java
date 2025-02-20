package com.only4.adapter.application.queries;

import com.only4.application.queries.member.MemberUniquePhoneQry;
import com.only4.domain.aggregates.member.Member;
import com.only4.domain.aggregates.member.meta.MemberSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * MemberUniquePhoneQry查询请求适配实现
 * 判断手机号是否已绑定用户
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/20
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MemberUniquePhoneQryHandler implements Query<MemberUniquePhoneQry.Request, MemberUniquePhoneQry.Response> {

    @Override
    public MemberUniquePhoneQry.Response exec(MemberUniquePhoneQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        return MemberUniquePhoneQry.Response.builder()
                .exists(Mediator.repositories().exists(JpaPredicate.bySpecification(Member.class,
                        MemberSchema.specify(member ->
                                member.phone().equal(request.getMemberPhone())
                        ))
                ))
                .build();
    }
}
