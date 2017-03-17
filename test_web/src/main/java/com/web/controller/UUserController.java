package com.web.controller;

import com.pu.service.PublicException;
import com.pu.service.UUserService;
import com.pu.vo.UUserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * createtime：2017/3/16/01616:23
 * author："xiao"zhuangping
 * purpose：
 */
@Controller
public class UUserController {

    private Logger logger = LoggerFactory.getLogger(UUserController.class);

    @Autowired
    private UUserService uUserService;

    @RequestMapping("/index")
    public String saveUser(){
        logger.info("jinlaile");
        /*UUserVo uUserVo = new UUserVo();
        uUserVo.setNickname("xiao");
        uUserVo.setPswd("123");
        try {
            uUserService.saveVo(uUserVo);
            logger.info("保存成功！111222333444555");
        } catch (PublicException e) {
           logger.error("保存信息报错",e);
        }*/
        return "index";
    }

    @RequestMapping("/lo")
    public String login(Model model){
        logger.info("验证用户===========================");
        UsernamePasswordToken token = new UsernamePasswordToken("ping", "1234");
        // 获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            logger.info("对用户[" + "xiao" + "]进行登录验证..验证开始");
            currentUser.login(token);
            logger.info("对用户[" + "xiao" + "]进行登录验证..验证通过");
        } catch (UnknownAccountException uae) {
            logger.info("对用户[" + "xiao" + "]进行登录验证..验证未通过,未知账户");
            model.addAttribute("message", "未知账户");
        } catch (IncorrectCredentialsException ice) {
            logger.info("对用户[" + "xiao" + "]进行登录验证..验证未通过,错误的凭证");
            model.addAttribute("message", "密码不正确");
        } catch (LockedAccountException lae) {
            logger.info("对用户[" + "xiao" + "]进行登录验证..验证未通过,账户已锁定");
            model.addAttribute("message", "账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            logger.info("对用户[" + "xiao" + "]进行登录验证..验证未通过,错误次数过多");
            model.addAttribute("message", "用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            logger.error("AuthenticationException",ae);
            // 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.info("对用户[" + "xiao" + "]进行登录验证..验证未通过,堆栈轨迹如下");
            model.addAttribute("message", "用户名或密码不正确");
        }
        return "login";
    }
}
