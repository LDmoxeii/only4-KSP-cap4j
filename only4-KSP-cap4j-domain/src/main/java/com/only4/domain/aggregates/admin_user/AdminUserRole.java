package com.only4.domain.aggregates.admin_user;

import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * 用户角色表
 * <p>
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Aggregate(aggregate = "AdminUser", name = "AdminUserRole", root = false, type = Aggregate.TYPE_ENTITY, relevant = { "AdminUser" }, description = "用户角色表")
@Entity
@Table(name = "`admin_user_role`")
@DynamicInsert
@DynamicUpdate

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@SQLDelete(sql = "update `admin_user_role` set `del_flag` = 1 where `id` = ? ")
@Where(clause = "`del_flag` = 0")
public class AdminUserRole {

    // 【行为方法开始】

    public void updateRoleInfo(String roleName) {
        this.roleName = roleName;
    }


    // 【行为方法结束】


    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

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

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


