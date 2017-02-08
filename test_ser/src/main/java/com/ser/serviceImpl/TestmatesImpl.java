package com.ser.serviceImpl;

import com.dao.mapper.ClassmatesMapper;
import com.dao.model.Classmates;
import com.ser.hessian.HessianService;
import com.ser.service.Testmates;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Administrator on 2017/2/1.
 */
@HessianService
@Service
public class TestmatesImpl implements Testmates {
    private static Logger logger = org.slf4j.LoggerFactory.getLogger(TestmatesImpl.class);
    @Autowired
    private ClassmatesMapper classmatesMapper;
    @Override
    public int insert(Object record) {
        Classmates classmates = new Classmates();
        try {
            BeanUtils.copyProperties(classmates,record);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return classmatesMapper.insert(classmates);
    }
}
