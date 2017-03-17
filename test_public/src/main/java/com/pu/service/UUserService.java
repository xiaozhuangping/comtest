package com.pu.service;

import com.pu.vo.UUserVo;

/**
 * createtime：2017/3/16/01615:53
 * author：xiaozhuangping
 * purpose：
 */
public interface UUserService extends BaseDao<UUserVo> {

    UUserVo searchUUserByName(String name)throws PublicException;
}
