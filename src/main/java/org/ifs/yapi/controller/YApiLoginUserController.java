package org.ifs.yapi.controller;

import org.ifs.yapi.common.AccessDeniedException;
import org.ifs.yapi.common.YResult;
import org.ifs.yapi.constant.Constant;
import org.ifs.yapi.pojo.req.LoginUserParam;
import org.ifs.yapi.pojo.req.RegisterUserParam;
import org.ifs.yapi.pojo.resp.LoginUserInfo;
import org.ifs.yapi.service.IYApiLoginUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录用户控制器
 *
 * @author wangsong
 * @date 2024/10/05
 */
@RestController
@RequestMapping("/user")
public class YApiLoginUserController {


    @Resource
    private IYApiLoginUserService loginUserService;

    /**
     * 用户登录
     *
     * @param param   登录信息
     * @param request
     * @return {@link YResult }<{@link LoginUserInfo }>
     */
    @PostMapping("/login")
    public YResult<LoginUserInfo> loginUser(@RequestBody @Validated LoginUserParam param, HttpServletRequest request) {
        LoginUserInfo userInfo = loginUserService.loginUser(param.getUsername(), param.getPassword());
        if (null == userInfo) {
            throw new AccessDeniedException("登录用户不存在");
        }
        request.getSession().setAttribute(Constant.SESSION_KEY_NAME, userInfo);
        return YResult.ok(userInfo);
    }

    /**
     * 退出登录
     *
     * @param request
     * @return {@link YResult }<{@link Integer }>
     */
    @GetMapping("/logout")
    public YResult<Integer> logout(HttpServletRequest request) {
        request.getSession().removeAttribute(Constant.SESSION_KEY_NAME);
        return YResult.ok(1);
    }


    /**
     * 用户注册
     *
     * @param param
     * @return {@link YResult }<{@link Integer }>
     */
    @PostMapping("/register")
    public YResult<Integer> register(@RequestBody @Validated RegisterUserParam param) {
        if(!param.getPassword().equals(param.getConfirmPassword())){
            throw new IllegalArgumentException("确认密码不一致");
        }
        return YResult.ok(loginUserService.registerUser(param.getUsername(),param.getEmail(),param.getPassword()));
    }


    @RequestMapping("/notLogin")
    public YResult<String> notLogin(HttpServletRequest request, HttpServletResponse response){
        throw new AccessDeniedException("未登录");
    }
}
