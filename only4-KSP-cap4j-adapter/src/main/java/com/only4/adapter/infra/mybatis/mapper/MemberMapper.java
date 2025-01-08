package com.only4.adapter.infra.mybatis.mapper;

import com.only4.domain.aggregates.member.Favorite;
import com.only4.domain.aggregates.member.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Boolean existedMemberByName(String name);
    Boolean existedMemberByPhone(String phone);
    Member getMemberByName(String name);
    Favorite getFavoriteByMemberId(Long id);
    Boolean existedSignInRecordByDate(Long id);
    Integer countFavoriteRecordByMemberIdAndDate(Long id);
    Favorite getFavoritesByFavoritesId(Long favoriteId);
}
