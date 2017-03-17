package com.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.dao.entity.UPermission;

public interface UPermissionMapper {

	void insertUPermission(UPermission UPermission);

	void deleteUPermissionById(Long id);

	void updateUPermission(UPermission UPermission);

	List<UPermission> searchUPermissionByParams(@Param("map") Map<String, String> map);

} 
