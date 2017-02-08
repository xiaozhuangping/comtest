package com.dao.mapper;

import com.dao.model.Classmates;

public interface ClassmatesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classmates record);

    int insertSelective(Classmates record);

    Classmates selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classmates record);

    int updateByPrimaryKey(Classmates record);
}