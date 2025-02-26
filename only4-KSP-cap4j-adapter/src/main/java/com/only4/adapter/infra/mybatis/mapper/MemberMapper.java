package com.only4.adapter.infra.mybatis.mapper;

import com.only4.domain.aggregates.member.Favorites;
import com.only4.domain.aggregates.member.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    Boolean existedMemberByName(String name);
    Boolean existedMemberByPhone(String phone);
    Member getMemberByName(String name);
}
