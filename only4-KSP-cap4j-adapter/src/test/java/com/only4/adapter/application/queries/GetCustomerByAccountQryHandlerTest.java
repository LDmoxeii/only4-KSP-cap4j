package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.CustomerMapper;
import com.only4.application.queries.customer.GetCustomerByAccountQry;
import com.only4.domain.aggregates.customer.Customer;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetCustomerByAccountQryHandlerTest {
  @InjectMocks
  GetCustomerByAccountQryHandler handler;

  @Mock
  GetCustomerByAccountQry.Request request;

  @Mock
  Customer customer;

  @Mock
  CustomerMapper mapper;

  @Test
  void exec() {
    when(mapper.getByAccount(any())).thenReturn(customer);
    var result = handler.exec(request);
    verify(mapper).getByAccount(any());
    assertEquals(result.getCustomer(), customer);
  }
}
