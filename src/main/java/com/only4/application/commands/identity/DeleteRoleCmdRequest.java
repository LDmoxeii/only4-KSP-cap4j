package com.only4.application.commands.identity;

import com.only4.application.queries.identity.ExistedAdminUserByRoleIdQryRequest;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.var;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * DeleteRoleCmd命令请求参数
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteRoleCmdRequest implements RequestParam<DeleteRoleCmdResponse> {

  @RoleId
  Long roleId;

  @Retention(RetentionPolicy.RUNTIME)
  @Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR,
      ElementType.PARAMETER})
  @Constraint(validatedBy = {RoleNameValidator.class})
  private @interface RoleId {

    String message() default "该角色已经分配用户，无法删除";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
  }

  public static class RoleNameValidator implements ConstraintValidator<RoleId, Long> {

    @Override
    public boolean isValid(Long roleId, ConstraintValidatorContext constraintValidatorContext) {
      var send = Mediator.queries().send(
          ExistedAdminUserByRoleIdQryRequest.builder()
              .roleId(roleId)
              .build());
      return !send.getExisted();
    }
  }

}
