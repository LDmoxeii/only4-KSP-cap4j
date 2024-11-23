package com.only4.adapter.infra.mybatis.mapper;

import com.only4.domain.aggregates.customer.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMapper {

  Customer getByAccount(@Param("account") String account);
}
