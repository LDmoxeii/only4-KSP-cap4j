package com.only4.domain.aggregates.member;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockMemberTest {

    @Test
    public void testUpdate() {
        BlockMember blockMember = BlockMember.builder()
                .otherName("oldName")
                .build();

        blockMember.update("newName");

        assertEquals("newName", blockMember.getOtherName());
    }
}
