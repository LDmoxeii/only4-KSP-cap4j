package com.only4.adapter.portal.api;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.only4.common.entity.R;
import com.only4.domain.aggregates.permission.PermissionDefinitions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 * @author cap4j-ddd-codegen
 */
@RestController
@RequestMapping(value = "/test")
@Slf4j
public class TestController {

    /**
     * 测试
     * @param msg 测试
     * @return
     */
    @PostMapping(value = "")
    @SaCheckPermission(PermissionDefinitions.ADMIN_USER_EDIT)
    public R<String> test(@RequestParam("msg") String msg) {
        return R.ok("echo: " + msg);
    }

}
