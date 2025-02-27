package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.MemberMapper;
import com.only4.application.queries.member.ExistedSignInRecordByDateQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * ExistedSignInRecordByDateQry查询请求适配实现 </br>
 * 根据 日期 判断用户 当天 是否签到，返回一个Boolean
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExistedSignInRecordByDateQryHandler implements Query<ExistedSignInRecordByDateQry.Request, ExistedSignInRecordByDateQry.Response> {
    private final MemberMapper memberMapper;
    @Override
    public ExistedSignInRecordByDateQry.Response exec(ExistedSignInRecordByDateQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Boolean isExists = memberMapper.existedSignInRecordByDate(request.getId());
        return ExistedSignInRecordByDateQry.Response.builder()
                .existed(isExists)
                .build();
    }
}