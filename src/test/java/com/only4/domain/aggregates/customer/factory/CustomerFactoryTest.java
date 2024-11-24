package com.only4.domain.aggregates.customer.factory;

import com.only4.domain.aggregates.customer.Customer;
import com.only4.domain.aggregates.customer.CustomerPermission;
import com.only4.domain.aggregates.customer.dto.AssignCustomerRoleDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CustomerFactoryTest {

    @InjectMocks
    private CustomerFactory customerFactory;

    @Test
    void create() {
        // 创建一个示例的 CustomerPayload 对象
        AssignCustomerRoleDto roleDto = AssignCustomerRoleDto.builder()
                .roleId(10086L)
                .roleName("Admin")
                .permissions(Arrays.asList(
                                CustomerPermission.builder()
                                        .id(11086L)
                                        .permissionCode("admin:*")
                                        .permissionRemark("Admin Permission")
                                        .build(),
                                CustomerPermission.builder()
                                        .id(12086L)
                                        .permissionCode("user:*")
                                        .permissionRemark("User permission")
                                        .build()
                        )
                ).build();

        CustomerPayload payload = CustomerPayload.builder()
                .account("user123")
                .password("password123")
                .rolesToBeAssigned(Collections.singletonList(roleDto))
                .build();

        // 调用 create 方法
        Customer result = customerFactory.create(payload);

        // 验证结果
        assertNotNull(result);
        assertEquals("user123", result.getAccount());
        assertEquals("password123", result.getPassword());

    }
}
