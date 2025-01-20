package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.MemberMapper;
import com.only4.application.queries.member.ExistedMemberByNameQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * ExistedMemberByNameQry查询请求适配实现
 * todo: 查询描述：根据 用户名 判断用户是否存在,返回一个Boolean
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExistedMemberByNameQryHandler implements Query<ExistedMemberByNameQry.Request, ExistedMemberByNameQry.Response> {
    private final MemberMapper memberMapper;
    @Override
    public ExistedMemberByNameQry.Response exec(ExistedMemberByNameQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Boolean isExists = memberMapper.existedMemberByName(request.getName());
        return ExistedMemberByNameQry.Response.builder()
                .existed(isExists)
                .build();
    }
}