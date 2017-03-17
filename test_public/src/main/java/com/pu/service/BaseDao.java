package com.pu.service;

import java.util.List;

/**
 * @Author xiao
 * @Date 2017/2/27/027 11:50
 * @Purpose 公用接口
 */
public interface BaseDao<T> {

    void saveVo(T t) throws PublicException;

    void deleteVo(Long id) throws PublicException;

    void deleteVoList(List<Long> ids) throws PublicException;

    void updateVo(T t) throws PublicException;

    List<T> searchVoList(T t) throws PublicException;

    T searchByVoNo(Long id) throws PublicException;


}
