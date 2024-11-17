package com.only4.application.commands.role;

import com.only4.application.queries.role.ExistedRoleByNameQryRequest;
import com.only4.domain.aggregates.role.RolePermission;
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
 * CreateRoleCmd命令请求参数
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRoleCmdRequest implements RequestParam<CreateRoleCmdResponse> {

  @NotEmpty
  @RoleName
  String name;

  @NotEmpty
  String description;

  List<RolePermission> permissions;

  @Retention(RetentionPolicy.RUNTIME)
  @Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR,
      ElementType.PARAMETER})
  @Constraint(validatedBy = {RoleNameValidator.class})
  private @interface RoleName {

    String message() default "角色名重复";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
  }

  public static class RoleNameValidator implements
      ConstraintValidator<CreateRoleCmdRequest.RoleName, String> {

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
      var send = Mediator.queries().send(
          ExistedRoleByNameQryRequest.builder()
              .name(name)
              .build()
      );
      return !send.getExisted();
    }
  }

}
