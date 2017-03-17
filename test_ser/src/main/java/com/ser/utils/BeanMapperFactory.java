package com.ser.utils;

import com.dao.entity.UUser;
import com.pu.vo.UUserVo;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * 实体类的转换 BeanMapperFactory
 * Created by Administrator on 2017/2/25/025.
 */
public class BeanMapperFactory {

    //用户rm-en
    public static MapperFactory rmUserVoToUser = new DefaultMapperFactory.Builder().mapNulls(false).build();
    static {
        rmUserVoToUser.classMap(UUser.class, UUserVo.class).byDefault().register();
    }
    //用户rm-vo
    public static MapperFactory rmUserVoToUserVo = new DefaultMapperFactory.Builder().mapNulls(false).build();
    static {
        rmUserVoToUserVo.classMap(com.dao.vo.UUserVo.class, UUserVo.class).byDefault().register();
    }


}
