package org.ifs.yapi.service;

import org.ifs.yapi.pojo.resp.MemberInfo;

import java.util.List;

public interface IYApiMemberService {
    List<MemberInfo> queryMemberDic(String query);
}
