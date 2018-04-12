package com.fullexception.mapper;

import com.fullexception.entity.FriendGroup;

public interface FriendGroupMapper {
    int deleteByPrimaryKey(Integer friendGroupId);

    int insert(FriendGroup record);

    int insertSelective(FriendGroup record);

    FriendGroup selectByPrimaryKey(Integer friendGroupId);

    int updateByPrimaryKeySelective(FriendGroup record);

    int updateByPrimaryKey(FriendGroup record);
}