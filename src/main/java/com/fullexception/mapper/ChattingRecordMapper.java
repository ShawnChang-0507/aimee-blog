package com.fullexception.mapper;

import com.fullexception.entity.ChattingRecord;

public interface ChattingRecordMapper {
    int deleteByPrimaryKey(Integer chattingRecordId);

    int insert(ChattingRecord record);

    int insertSelective(ChattingRecord record);

    ChattingRecord selectByPrimaryKey(Integer chattingRecordId);

    int updateByPrimaryKeySelective(ChattingRecord record);

    int updateByPrimaryKey(ChattingRecord record);
}