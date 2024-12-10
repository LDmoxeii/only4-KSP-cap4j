package com.only4.domain.aggregates.role;

import com.only4.domain.aggregates.role.events.RoleInfoChangedDomainEvent;
import com.only4.domain.aggregates.role.events.RolePermissionChangedDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport.events;

/**
 * 角色表
 * <p>
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Aggregate(aggregate = "Role", name = "Role", root = true, type = Aggregate.TYPE_ENTITY, description = "角色表")
@Entity
@Table(name = "`role`")
@DynamicInsert
@DynamicUpdate

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Role {

    // 【行为方法开始】

    public void updateRoleInfo(String name, String description) {
        this.name = name;
        this.description = description;
        events().attach(new RoleInfoChangedDomainEvent(this), this);
    }

    public void updateRolePermission(List<RolePermission> newPermissions) {
        Map<String, RolePermission> currentPermissionMap = this.getRolePermissions().stream()
                .collect(Collectors.toMap(RolePermission::getPermissionCode, rolePermission -> rolePermission));
        Map<String, RolePermission> newPsermissionMap = newPermissions.stream()
                .collect(Collectors.toMap(RolePermission::getPermissionCode, rolePermission -> rolePermission));
        currentPermissionMap.keySet().stream()
                .filter(key -> !newPsermissionMap.containsKey(key))
                .forEach(key -> this.rolePermissions.remove(currentPermissionMap.get(key)));
        newPsermissionMap.keySet().stream()
                .filter(key -> !currentPermissionMap.containsKey(key))
                .forEach(key -> this.rolePermissions.add(newPsermissionMap.get(key)));
        events().attach(new RolePermissionChangedDomainEvent(this), this);
    }


    // 【行为方法结束】


    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "`role_id`", nullable = false)
    private List<RolePermission> rolePermissions;

    /**
     * ID
     * bigint
     */
    @Id
    @GeneratedValue(generator = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator")
    @GenericGenerator(name = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator", strategy = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator")
    @Column(name = "`id`")
    Long id;

    /**
     * 角色名
     * varchar(255)
     */
    @Column(name = "`name`")
    String name;

    /**
     * 角色描述
     * varchar(255)
     */
    @Column(name = "`description`")
    String description;

    /**
     * 创建时间
     * timestamp
     */
    @Column(name = "`created_at`")
    java.time.LocalDateTime createdAt;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


