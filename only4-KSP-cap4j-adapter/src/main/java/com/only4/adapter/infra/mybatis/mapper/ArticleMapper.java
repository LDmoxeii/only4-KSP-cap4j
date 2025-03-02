package com.only4.adapter.infra.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    Boolean existedByCategoryId(Long categoryId);
    Boolean existedByTagId(Long tagId);
}
