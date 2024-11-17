package com.only4.application.commands.admin_user;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.only4.domain.aggregates.admin_user.AdminUser;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.domain.repo.RepositorySupervisor;

@ExtendWith(MockitoExtension.class)
class AdminUserLoginSuccessfullyCmdHandlerTest {

  @InjectMocks
  private AdminUserLoginSuccessfullyCmdHandler handler;

  @Mock
  private RepositorySupervisor repositorySupervisor;

  @Mock
  AdminUser adminUser;

  private MockedStatic<Mediator> mediatorMockedStatic;

  @BeforeEach
  void setUp() {
    mediatorMockedStatic = mockStatic(Mediator.class);
    when(Mediator.repositories()).thenReturn(repositorySupervisor);
  }

  @Test
  void exec() {
    AdminUserLoginSuccessfullyCmdRequest request = AdminUserLoginSuccessfullyCmdRequest.builder()
        .build();
    AdminUserLoginSuccessfullyCmdResponse response = AdminUserLoginSuccessfullyCmdResponse.builder()
        .success(true).build();

    when(repositorySupervisor.findOne(any())).thenReturn(Optional.of(adminUser));

    AdminUserLoginSuccessfullyCmdResponse result = handler.exec(request);

    verify(adminUser).loginSuccessful(any(),any());
    Assertions.assertEquals(response, result);
  }

  @AfterEach
  void tearDown() {
    mediatorMockedStatic.close();
  }
}
