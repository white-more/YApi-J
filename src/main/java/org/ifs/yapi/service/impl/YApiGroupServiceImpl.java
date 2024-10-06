package org.ifs.yapi.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.ifs.yapi.common.IdWorker;
import org.ifs.yapi.constant.Constant;
import org.ifs.yapi.entity.TYapiGroup;
import org.ifs.yapi.entity.TYapiMemberInfo;
import org.ifs.yapi.mapper.TYapiGroupMapper;
import org.ifs.yapi.mapper.TYapiMemberInfoMapper;
import org.ifs.yapi.pojo.GroupInfo;
import org.ifs.yapi.service.IYApiGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class YApiGroupServiceImpl implements IYApiGroupService {

    @Resource
    private TYapiGroupMapper yapiGroupMapper;

    @Resource
    private TYapiMemberInfoMapper memberInfoMapper;

    @Resource
    private IdWorker idWorker;

    @Override
    public TYapiGroup queryById(String id) {
        if (StringUtils.isBlank(id)) {
            throw new IllegalArgumentException("分组id不能为空");
        }
        return yapiGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<GroupInfo> queryByUserId(String userId) {
        TYapiGroup privateGroup = yapiGroupMapper.queryPrivateGroup(userId);
        List<TYapiGroup> ownGroup = yapiGroupMapper.queryOwnGroup(userId);
        List<TYapiGroup> otherGroup = yapiGroupMapper.queryOtherGroup(userId);

        List<TYapiGroup> groups = new ArrayList<>();
        groups.add(privateGroup);
        groups.addAll(ownGroup);
        groups.addAll(otherGroup);

        return JSONArray.parseArray(JSONObject.toJSONString(groups), GroupInfo.class);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer addGroup(String groupName, String groupDesc, String uid, String addUid) {
        TYapiGroup group = new TYapiGroup();
        group.setGroupName(groupName);
        group.setGroupDesc(groupDesc);
        group.setUid(addUid);
        group.setType(Constant.AUTH_PUBLIC);
        group.setRole(Constant.GROUP_AUTH_ROLE);
        group.setId(String.valueOf(idWorker.nextId()));
        group.setAddTime(LocalDateTime.now());
        group.setUpTime(LocalDateTime.now());
        yapiGroupMapper.insertSelective(group);
        if (!uid.equals(addUid)) {
            TYapiMemberInfo memberInfo = new TYapiMemberInfo();
            memberInfo.setId(String.valueOf(idWorker.nextId()));
            memberInfo.setUid(uid);
            memberInfo.setBusId(group.getId());
            memberInfo.setMemberBelong(Constant.MEMBER_BELONG_GROUP);
            memberInfo.setMemberType(Constant.GROUP_AUTH_ROLE);
            memberInfo.setAddTime(LocalDateTime.now());
            memberInfo.setUpTime(LocalDateTime.now());
            memberInfoMapper.insertSelective(memberInfo);
        }
        return 1;
    }
}
