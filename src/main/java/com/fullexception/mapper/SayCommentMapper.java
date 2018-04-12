package com.fullexception.mapper;

import com.fullexception.entity.SayComment;

public interface SayCommentMapper {
    int deleteByPrimaryKey(Integer sayCommentId);

    int insert(SayComment record);

    int insertSelective(SayComment record);

    SayComment selectByPrimaryKey(Integer sayCommentId);

    int updateByPrimaryKeySelective(SayComment record);

    int updateByPrimaryKeyWithBLOBs(SayComment record);

    int updateByPrimaryKey(SayComment record);
}