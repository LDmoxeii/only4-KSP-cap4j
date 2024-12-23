package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.ExistedAdminUserByNameQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * ExistsAdminUserByNameQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExistedAdminUserByNameQryHandler implements Query<ExistedAdminUserByNameQry.Request, ExistedAdminUserByNameQry.Response> {
  private final AdminUserMapper adminUserMapper;

  @Override
  public ExistedAdminUserByNameQry.Response exec(ExistedAdminUserByNameQry.Request request) {
    Boolean isExists = adminUserMapper.existedByName(request.getName());
//    val isExists = Mediator.repositories().exists(JpaPredicate.bySpecification(
//            AdminUser.class,
//            AdminUserSchema.specify(adminUser ->
//                    adminUser.name().eq(request.getName())
//            )
//    ));
    // mybatis / jpa 哪个顺手就用哪个吧！
    return ExistedAdminUserByNameQry.Response.builder()
        .existed(isExists)
        .build();
  }
}
