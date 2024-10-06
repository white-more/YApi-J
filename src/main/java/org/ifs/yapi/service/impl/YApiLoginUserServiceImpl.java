package org.ifs.yapi.service.impl;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.ifs.yapi.common.IdWorker;
import org.ifs.yapi.constant.Constant;
import org.ifs.yapi.entity.TYapiGroup;
import org.ifs.yapi.entity.TYapiLoginUser;
import org.ifs.yapi.mapper.TYapiGroupMapper;
import org.ifs.yapi.mapper.TYapiLoginUserMapper;
import org.ifs.yapi.pojo.resp.LoginUserInfo;
import org.ifs.yapi.service.IYApiLoginUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class YApiLoginUserServiceImpl implements IYApiLoginUserService {


    @Resource
    private TYapiLoginUserMapper loginUserMapper;
    @Resource
    private TYapiGroupMapper groupMapper;

    @Resource
    private IdWorker idWorker;

    /**
     * 用户登录
     *
     * @param username 用户名/邮箱
     * @param password 密码
     * @return {@link LoginUserInfo }
     */
    @Override
    public LoginUserInfo loginUser(String username, String password) {
        password = new String(Hex.encodeHex(DigestUtils.md5(password)));
        TYapiLoginUser loginUser = loginUserMapper.queryByUsernameAndPassword(username, password);
        if (loginUser == null) {
            throw new IllegalArgumentException("用户不存在或者用户名密码错误");
        }
        LoginUserInfo loginUserInfo = new LoginUserInfo();
        BeanUtils.copyProperties(loginUser, loginUserInfo);
        return loginUserInfo;
    }

    /**
     * 用户注册
     *
     * @param username 用户名
     * @param email    邮箱
     * @param password 密码
     * @return {@link Integer }
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer registerUser(String username, String email, String password) {
        Integer repeatCount = loginUserMapper.checkUser(username, email);
        if (repeatCount > 0) {
            throw new IllegalArgumentException("用户名或者邮箱重复");
        }
        password = new String(Hex.encodeHex(DigestUtils.md5(password)));
        TYapiLoginUser loginUser = new TYapiLoginUser();
        loginUser.setId(String.valueOf(idWorker.nextId()));
        loginUser.setUserName(username);
        loginUser.setEmail(email);
        loginUser.setPassword(password);
        loginUser.setRole(Constant.GROUP_AUTH_ROLE);
        loginUser.setType(Constant.USER_TYPE_SITE);
        loginUser.setAddTime(LocalDateTime.now());
        loginUser.setUpTime(LocalDateTime.now());
        loginUserMapper.insertSelective(loginUser);

        TYapiGroup group = new TYapiGroup();
        group.setId(String.valueOf(idWorker.nextId()));
        group.setUid(loginUser.getId());
        group.setGroupName("个人空间");
        group.setGroupDesc("这是个人空间");
        group.setRole(Constant.USER_ROLE_MEMBER);
        group.setType(Constant.AUTH_PRIVATE);
        group.setAddTime(LocalDateTime.now());
        group.setUpTime(LocalDateTime.now());
        groupMapper.insertSelective(group);
        return 1;
    }
}
