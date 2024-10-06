package org.ifs.yapi.service;

import org.ifs.yapi.entity.TYapiGroup;
import org.ifs.yapi.pojo.GroupInfo;

import java.util.List;


public interface IYApiGroupService {

    TYapiGroup queryById(String id);

    List<GroupInfo> queryByUserId(String userId);

    Integer addGroup(String groupName, String groupDesc, String uid, String addUid);
}
