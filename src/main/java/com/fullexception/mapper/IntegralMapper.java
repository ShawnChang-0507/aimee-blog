package com.fullexception.mapper;

import com.fullexception.entity.Integral;

public interface IntegralMapper {
    int deleteByPrimaryKey(Integer integralId);

    int insert(Integral record);

    int insertSelective(Integral record);

    Integral selectByPrimaryKey(Integer integralId);

    int updateByPrimaryKeySelective(Integral record);

    int updateByPrimaryKey(Integral record);
}