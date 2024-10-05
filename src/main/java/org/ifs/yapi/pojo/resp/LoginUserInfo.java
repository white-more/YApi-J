package org.ifs.yapi.pojo.resp;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 登录用户信息
 *
 * @author wangsong
 * @date 2024/10/05
 */
@Getter
@Setter
public class LoginUserInfo {
    /**
     * 用户id
     */
    private String id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 登录邮箱
     */
    private String email;
    /**
     * 登录类型（网站登录：site）
     */
    private String type;
    /**
     *
     */
    private String study;
    /**
     * 角色（memeber、admin）
     */
    private String role;
    /**
     * 头像
     */
    private String avatar;

    /**
     * 创建时间
     */
    private LocalDateTime addTime;
    /**
     * 修改时间
     */
    private LocalDateTime upTime;
}
