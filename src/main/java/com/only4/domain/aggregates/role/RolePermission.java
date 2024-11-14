package com.only4.domain.aggregates.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import static org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport.events;

import javax.persistence.*;

/**
 * 角色权限表
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Aggregate(aggregate = "role", name = "RolePermission", root = false, type = Aggregate.TYPE_ENTITY, relevant = { "Role" }, description = "角色权限表")
@Entity
@Table(name = "`role_permission`")
@DynamicInsert
@DynamicUpdate

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class RolePermission {

    // 【行为方法开始】

    // 【行为方法结束】



    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @Id
    @GeneratedValue(generator = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator")
    @GenericGenerator(name = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator", strategy = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator")
    @Column(name = "`id`")
    Long id;

    /**
     * 权限编码
     * varchar(255)
     */
    @Column(name = "`permission_code`")
    String permissionCode;

    /**
     * 权限备注
     * varchar(255)
     */
    @Column(name = "`permission_remark`")
    String permissionRemark;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


