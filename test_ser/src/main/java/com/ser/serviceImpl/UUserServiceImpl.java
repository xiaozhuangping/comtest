package com.ser.serviceImpl;

import com.dao.entity.UUser;
import com.dao.mapper.UUserMapper;
import com.pu.service.PublicException;
import com.pu.service.UUserService;
import com.pu.vo.UUserVo;
import com.ser.hessian.HessianService;
import com.ser.utils.BeanMapperFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * createtime：2017/3/16/01615:55
 * author：xiaozhuangping
 * purpose：
 */
@Service
@HessianService
@Transactional
public class UUserServiceImpl implements UUserService{

    @Autowired
    private UUserMapper uUserMapper;

    @Override
    public void saveVo(UUserVo uUserVo) throws PublicException {
        UUser uvo = BeanMapperFactory.rmUserVoToUser.getMapperFacade().map(uUserVo, UUser.class);
        uUserMapper.insertUUser(uvo);
    }

    @Override
    public void deleteVo(Long id) throws PublicException {

    }

    @Override
    public void deleteVoList(List<Long> ids) throws PublicException {

    }

    @Override
    public void updateVo(UUserVo uUserVo) throws PublicException {

    }

    @Override
    public List<UUserVo> searchVoList(UUserVo uUserVo) throws PublicException {
        return null;
    }

    @Override
    public UUserVo searchByVoNo(Long id) throws PublicException {
        return null;
    }

    @Override
    public UUserVo searchUUserByName(String name) throws PublicException {
        if(null!=name){
           return BeanMapperFactory.rmUserVoToUserVo.getMapperFacade().map(uUserMapper.searchUUserByName(name),UUserVo.class);
        }
        return null;
    }
}
