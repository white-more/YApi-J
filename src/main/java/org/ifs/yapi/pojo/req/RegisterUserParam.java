package org.ifs.yapi.pojo.req;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 注册用户参数
 *
 * @author wangsong
 * @date 2024/10/05
 */
@Getter
@Setter
public class RegisterUserParam {

    /**
     * 用户名（或邮箱）
     */
    @NotBlank
    @NotNull
    private String username;
    /**
     * 邮箱
     */
    @NotBlank
    @NotNull
    private String email;

    /**
     * 密码
     */
    @NotBlank
    @NotNull
    private String password;

    /**
     * 确认密码
     */
    @NotBlank
    @NotNull
    private String confirmPassword;
}
