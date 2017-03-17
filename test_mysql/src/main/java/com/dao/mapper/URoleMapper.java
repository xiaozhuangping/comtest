package com.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.dao.entity.URole;

public interface URoleMapper {

	void insertURole(URole URole);

	void deleteURoleById(Long id);

	void updateURole(URole URole);

	List<URole> searchURoleByParams(@Param("map") Map<String, String> map);

} 
