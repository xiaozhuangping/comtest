package com.web.HessianFactory;

import com.web.service.Testmates;
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
    public HessianProxyFactoryBean testClassmates(){
        HessianProxyFactoryBean hessianProxyFactoryBean = new HessianProxyFactoryBean();
        hessianProxyFactoryBean.setConnectTimeout(10000); //连接超时10秒
        hessianProxyFactoryBean.setReadTimeout(20000);    //请求超时20秒
        hessianProxyFactoryBean.setServiceUrl(hessianPath + "testmates"); //接口实现路径
        hessianProxyFactoryBean.setServiceInterface(Testmates.class); //接口类
        return hessianProxyFactoryBean;
    }
}
