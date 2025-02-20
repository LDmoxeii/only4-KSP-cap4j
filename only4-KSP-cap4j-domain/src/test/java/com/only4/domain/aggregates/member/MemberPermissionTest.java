package com.only4.domain.aggregates.member;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberPermissionTest {

    @Test
    public void testMemberPermissionCreation() {
        MemberPermission permission = MemberPermission.builder()
                .permissionCode("READ")
                .permissionMark("Read permission")
                .build();

        assertEquals("READ", permission.getPermissionCode());
        assertEquals("Read permission", permission.getPermissionMark());
    }
}
