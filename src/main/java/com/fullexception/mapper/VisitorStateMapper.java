package com.fullexception.mapper;

import com.fullexception.entity.VisitorState;

public interface VisitorStateMapper {
    int deleteByPrimaryKey(Integer visitorStateId);

    int insert(VisitorState record);

    int insertSelective(VisitorState record);

    VisitorState selectByPrimaryKey(Integer visitorStateId);

    int updateByPrimaryKeySelective(VisitorState record);

    int updateByPrimaryKey(VisitorState record);
}