package com.only4.adapter.infra.mybatis.mapper;

import java.util.List;

import com.only4.domain.aggregates.star.Star;
import com.only4.domain.aggregates.star.StarStatistic;
import com.only4.domain.aggregates.star.Stardust;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StarMapper {
    Boolean existedStarByName(String name);
    List<Star> GetStarListByMemberIdQry(String memberId);
}
