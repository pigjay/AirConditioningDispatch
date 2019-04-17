package com.pigteam.airconditioning.web.system;

import com.pigteam.airconditioning.common.enums.SystemCodeEnum;
import com.pigteam.airconditioning.common.utils.vcode.Captcha;
import com.pigteam.airconditioning.common.utils.vcode.GifCaptcha;
import com.pigteam.airconditioning.common.web.Result;
import com.pigteam.airconditioning.config.vcode.FebsProperties;
import com.pigteam.airconditioning.model.po.user.CurrentUser;
import com.pigteam.airconditioning.model.req.LoginReq;
import com.pigteam.airconditioning.service.user.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @className: LoginController
 * @author: zhujie
 * @version:
 * @date: 2019/4/17 15:41
 * @descripton:
 **/
@RestController
@Slf4j
public class LoginController {

    private static final String CODE_KEY = "v_code";

    @Autowired
    private FebsProperties febsProperties;

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/login")
    public Result login(@RequestBody @Valid LoginReq loginReq, HttpServletRequest request) {

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        if (!loginReq.getVcode().equalsIgnoreCase((String) session.getAttribute(CODE_KEY))) {
            return Result.fail(SystemCodeEnum.AUTH_VCODEERR);
        }
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginReq.getUsername(), loginReq.getPassword());
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            return Result.fail(SystemCodeEnum.AUTH_NOT_USER);
        } catch (LockedAccountException e) {
            return Result.fail(SystemCodeEnum.AUTH_USER_DISABLE);
        } catch (AuthenticationException e) {
            return Result.fail(SystemCodeEnum.AUTH_PASSWORD_ERROR);
        }
        CurrentUser currentUser = (CurrentUser) subject.getPrincipal();
        return Result.success(currentUser.getSysUser());
    }

    @PostMapping("/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Result.success();
    }

    @GetMapping(value = "/static/gifCode")
    public void getGifCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");

            Captcha captcha = new GifCaptcha(
                    febsProperties.getValidateCode().getWidth(),
                    febsProperties.getValidateCode().getHeight(),
                    febsProperties.getValidateCode().getLength());
            HttpSession session = request.getSession(true);
            captcha.out(response.getOutputStream());
            session.removeAttribute(CODE_KEY);
            session.setAttribute(CODE_KEY, captcha.text().toLowerCase());
        } catch (Exception e) {
            log.error("图形验证码生成失败", e);
        }
    }
}
