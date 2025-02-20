package com.only4.domain.aggregates.article;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArticleTagTest {

    private ArticleTag articleTag;

    @BeforeEach
    void setUp() {
        articleTag = ArticleTag.builder()
                .id(1L)
                .tagId(1L)
                .tagName("Tag1")
                .build();
    }

    @Test
    void testUpdateInfo() {
        articleTag.updateInfo("New Tag Name");
        assertEquals("New Tag Name", articleTag.getTagName());
    }
}
