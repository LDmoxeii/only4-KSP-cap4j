package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.ExistedAdminUserByNameQryRequest;
import com.only4.application.queries.admin_user.ExistedAdminUserByNameQryResponse;
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
public class ExistedAdminUserByNameQryHandler implements Query<ExistedAdminUserByNameQryRequest, ExistedAdminUserByNameQryResponse> {
  private final AdminUserMapper adminUserMapper;

  @Override
  public ExistedAdminUserByNameQryResponse exec(ExistedAdminUserByNameQryRequest request) {
    Long existed = adminUserMapper.existedByName(request.getName());
    // mybatis / jpa 哪个顺手就用哪个吧！
    return ExistedAdminUserByNameQryResponse.builder()
        .existed(existed != 0L)
        .build();
  }
}
