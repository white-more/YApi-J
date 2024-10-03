package org.ifs.yapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 登录用户信息
 *
 * @author wangsong
 * @date 2024/10/04
 */
@Getter
@Setter
@Table(name = "T_YAPI_LOGIN_USER")
public class TYapiLoginUser {
    /**
     * 用户id
     */
    @Id
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
     * 登录密码
     */
    private String password;
    /**
     * 创建时间
     */
    private LocalDateTime addTime;
    /**
     * 修改时间
     */
    private LocalDateTime upTime;
}
