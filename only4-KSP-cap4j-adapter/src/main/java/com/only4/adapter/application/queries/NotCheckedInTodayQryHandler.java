package com.only4.adapter.application.queries;

import com.only4.application.queries.check_in.NotCheckedInTodayQry;
import com.only4.domain.aggregates.check_in.CheckIn;
import com.only4.domain.aggregates.check_in.meta.CheckInSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * NotCheckedInTodayQry查询请求适配实现
 * 判断今天是否已签到
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/20
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NotCheckedInTodayQryHandler implements Query<NotCheckedInTodayQry.Request, NotCheckedInTodayQry.Response> {

    @Override
    public NotCheckedInTodayQry.Response exec(NotCheckedInTodayQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        return NotCheckedInTodayQry.Response.builder()
                .exists(Mediator.repositories().exists(JpaPredicate.bySpecification(CheckIn.class,
                        CheckInSchema.specify(schema ->
                                schema.memberId().equal(request.getMemberId())
                        ))
                ))
                .build();
    }
}
