package com.only4.domain.aggregates.admin_user;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import static org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport.events;

/**
 * 用户角色表
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Aggregate(aggregate = "admin_user", name = "AdminUserRole", root = false, type = Aggregate.TYPE_ENTITY, relevant = { "AdminUser" }, description = "用户角色表")
@Entity
@Table(name = "`admin_user_role`")
@DynamicInsert
@DynamicUpdate

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class AdminUserRole {

    // 【行为方法开始】

    public void updateRoleInfo(String  roleName) {
        this.roleName = roleName;
    }


    // 【行为方法结束】



    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @Id
    @GeneratedValue(generator = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator")
    @GenericGenerator(name = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator", strategy = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator")
    @Column(name = "`id`")
    Long id;

    /**
     * 角色ID
     * bigint
     */
    @Column(name = "`role_id`")
    Long roleId;

    /**
     * 角色名
     * varchar(255)
     */
    @Column(name = "`role_name`")
    String roleName;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


