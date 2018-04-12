package com.fullexception.mapper;

import com.fullexception.entity.Attention;

public interface AttentionMapper {
    int deleteByPrimaryKey(Integer attentionId);

    int insert(Attention record);

    int insertSelective(Attention record);

    Attention selectByPrimaryKey(Integer attentionId);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);
}