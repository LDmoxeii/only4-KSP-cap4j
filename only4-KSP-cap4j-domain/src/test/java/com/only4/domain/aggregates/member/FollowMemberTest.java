package com.only4.domain.aggregates.member;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FollowMemberTest {

    @Test
    public void testUpdateInfo() {
        FollowMember followMember = FollowMember.builder()
                .otherName("oldName")
                .build();

        followMember.updateInfo("newName");

        assertEquals("newName", followMember.getOtherName());
    }
}
