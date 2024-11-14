package com.only4.application.commands.identity;

import com.only4.application.queries.identity.ExistedAdminUserByNameQryRequest;
import com.only4.domain.aggregates.admin_user.dto.AssignAdminUserRoleDto;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.var;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * CreateAminUserCmd命令请求参数
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAdminUserCmdRequest implements RequestParam<CreateAdminUserCmdResponse> {

  @Name
  @NotEmpty
  String name;

  @NotEmpty
  String phone;

  @NotEmpty
  String password;

  List<AssignAdminUserRoleDto> rolesToBeAssigned;

  @Retention(RetentionPolicy.RUNTIME)
  @Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR,
      ElementType.PARAMETER})
  @Constraint(validatedBy = {NameValidator.class})
  private @interface Name {

    String message() default "该用户已存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
  }

  public static class NameValidator implements ConstraintValidator<Name, String> {

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
      var response = Mediator.queries().send(
          ExistedAdminUserByNameQryRequest.builder()
              .name(name)
              .build()
      );
      return !response.getExisted();
    }
  }
}
