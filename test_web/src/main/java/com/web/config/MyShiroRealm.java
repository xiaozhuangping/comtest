package com.web.config;

import com.pu.service.PublicException;
import com.pu.service.UUserService;
import com.pu.vo.UUserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * createtime：2017/3/16/01616:36
 * author：xiaozhuangping
 * purpose：
 */
public class MyShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

   /* @Autowired
    private UUserService uUserService;*/

    /**
     *  @Date 2017/3/17/017 15:23
     *  @Author xiaozhuangping
     *  @Purpose 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.debug("登录验证后进行权限认证....");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }

    /**
     *  @Date 2017/3/17/017 15:23
     *  @Author xiaozhuangping
     *  @Purpose 验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.debug("登录操作进行登录认证......");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UUserVo uUserVo = null;
        try {
            uUserVo = SpringContextUtils.getBean(UUserService.class).searchUUserByName(token.getUsername());
            if (uUserVo == null) {
                // 没找到帐号
                throw new UnknownAccountException("没有在本系统中找到对应的用户信息。");
            }
        } catch (PublicException e) {
                throw new UnknownAccountException("没有在本系统中找到对应的用户信息。");
        }
        // 简单验证
        SecurityUtils.getSubject().getSession().setAttribute("user", uUserVo);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(uUserVo,uUserVo.getPswd(), getName());
        return info;
    }
}
