package com.only4.adapter.infra.mybatis.mapper;

import com.only4.domain.aggregates.category.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    Boolean existedByName(String name);
    Boolean existedById(Long Id);
    Category getById(Long Id);
}
