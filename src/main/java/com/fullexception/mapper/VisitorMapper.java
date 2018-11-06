package com.fullexception.mapper;

import com.fullexception.entity.Visitor;

public interface VisitorMapper {
    int deleteByPrimaryKey(Integer visitorId);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    Visitor selectByPrimaryKey(Integer visitorId);

    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKey(Visitor record);
    
    Visitor login(String name, String password);
}