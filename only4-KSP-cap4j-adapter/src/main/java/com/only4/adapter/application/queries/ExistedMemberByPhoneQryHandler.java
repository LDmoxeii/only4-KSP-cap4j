package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.MemberMapper;
import com.only4.application.queries.member.ExistedMemberByNameQry;
import com.only4.application.queries.member.ExistedMemberByPhoneQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * ExistedMemberByPhoneQry查询请求适配实现 </br>
 * 根据 手机号 判断用户是否存在,返回一个Boolean
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExistedMemberByPhoneQryHandler implements Query<ExistedMemberByPhoneQry.Request, ExistedMemberByPhoneQry.Response> {
    private final MemberMapper memberMapper;
    @Override
    public ExistedMemberByPhoneQry.Response exec(ExistedMemberByPhoneQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Boolean isExists = memberMapper.existedMemberByPhone(request.getPhone());
        return ExistedMemberByPhoneQry.Response.builder()
                .existed(isExists)
                .build();
    }
}