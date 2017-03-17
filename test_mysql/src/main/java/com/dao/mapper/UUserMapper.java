package com.dao.mapper;

import java.util.List;
import java.util.Map;

import com.dao.vo.UUserVo;
import org.apache.ibatis.annotations.Param;
import com.dao.entity.UUser;

public interface UUserMapper {

	void insertUUser(UUser UUser);

	void deleteUUserById(Long id);

	void updateUUser(UUser UUser);

	List<UUser> searchUUserByParams(@Param("map") Map<String, String> map);

	UUserVo searchUUserByName(String name);

} 
