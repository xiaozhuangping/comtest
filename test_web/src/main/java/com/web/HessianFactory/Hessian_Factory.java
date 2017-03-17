package com.web.HessianFactory;

import com.pu.service.UUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

/**
 * Created by Administrator on 2017/1/31.
 */
@Configuration
public class Hessian_Factory {
    private @Value("${test_service-hessian-path}") String hessianPath;
    @Bean
    public HessianProxyFactoryBean uUserService(){
        HessianProxyFactoryBean hessianProxyFactoryBean = new HessianProxyFactoryBean();
        hessianProxyFactoryBean.setConnectTimeout(10000); //连接超时10秒
        hessianProxyFactoryBean.setReadTimeout(20000);    //请求超时20秒
        hessianProxyFactoryBean.setServiceUrl(hessianPath + "UUserService"); //接口实现路径
        hessianProxyFactoryBean.setServiceInterface(UUserService.class); //接口类
        return hessianProxyFactoryBean;
    }
}
