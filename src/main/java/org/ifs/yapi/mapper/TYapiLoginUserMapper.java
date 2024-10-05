package org.ifs.yapi.mapper;

import org.apache.ibatis.annotations.Param;
import org.ifs.yapi.entity.TYapiLoginUser;
import tk.mybatis.mapper.common.Mapper;

public interface TYapiLoginUserMapper extends Mapper<TYapiLoginUser> {
    /**
     * 根据用户名（或邮箱）和密码查询用户信息
     *
     * @param username 用户名（或邮箱）
     * @param password 密码
     * @return {@link TYapiLoginUser }
     */
    TYapiLoginUser queryByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 检查用户名或者邮箱是否重复
     *
     * @param username 用户名
     * @param email    邮箱
     * @return {@link Integer }
     */
    Integer checkUser(@Param("username") String username, @Param("email") String email);
}
