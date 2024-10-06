package org.ifs.yapi.constant;

/**
 * 常量
 *
 * @author wangsong
 * @date 2024/10/05
 */
public final class Constant {

    private Constant() {
    }

    public final static String SESSION_KEY_NAME = "userInfo";

    /**
     * 用户来源 网站注册
     */
    public final static String USER_TYPE_SITE = "site";
    /**
     * 用户角色 管理员
     */
    public final static String USER_ROLE_ADMIN = "admin";
    /**
     * 普通用户
     */
    public final static String USER_ROLE_MEMBER = "member";


    public final static String AUTH_PUBLIC = "public";

    public final static String AUTH_PRIVATE = "private";


    /**
     * 分组归属
     */
    public final static String GROUP_AUTH_ROLE = "owner";
    /**
     * 开发者
     */
    public final static String GROUP_AUTH_ROLE_DEV = "dev";
    /**
     * 访客
     */
    public final static String GROUP_AUTH_ROLE_GUEST = "guest";


    /**
     * 成员归属（分组）
     */
    public final static String MEMBER_BELONG_GROUP = "1";
    /**
     * 成员归属（接口）
     */
    public final static String MEMBER_BELONG_INTERFACE = "2";


}
