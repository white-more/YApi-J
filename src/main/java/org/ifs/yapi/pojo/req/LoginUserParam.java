package org.ifs.yapi.pojo.req;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 登录用户信息
 *
 * @author wangsong
 * @date 2024/10/05
 */
@Getter
@Setter
public class LoginUserParam {

    /**
     * 用户名（或邮箱）
     */
    @NotBlank
    @NotNull
    private String username;

    /**
     * 密码
     */
    @NotBlank
    @NotNull
    private String password;

}
