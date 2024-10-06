package org.ifs.yapi.service.impl;

import org.ifs.yapi.mapper.TYapiLoginUserMapper;
import org.ifs.yapi.pojo.resp.MemberInfo;
import org.ifs.yapi.service.IYApiMemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class YApiMemberServiceImpl implements IYApiMemberService {

    @Resource
    private TYapiLoginUserMapper loginUserMapper;
    @Override
    public List<MemberInfo> queryMemberDic(String query) {

        return loginUserMapper.queryMemberDic(query);
    }
}
