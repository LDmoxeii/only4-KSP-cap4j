package com.only4.adapter.infra.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {
    Boolean existedByName(String name);
}
