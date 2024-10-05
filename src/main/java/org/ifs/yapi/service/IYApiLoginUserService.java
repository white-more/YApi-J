package org.ifs.yapi.service;

import org.ifs.yapi.pojo.resp.LoginUserInfo;

public interface IYApiLoginUserService {
    LoginUserInfo loginUser(String username, String password);

    Integer registerUser(String username, String email, String password);

}
