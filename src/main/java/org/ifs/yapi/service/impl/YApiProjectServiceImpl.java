package org.ifs.yapi.service.impl;

import org.ifs.yapi.common.IdWorker;
import org.ifs.yapi.constant.Constant;
import org.ifs.yapi.entity.TYapiProjectInfo;
import org.ifs.yapi.mapper.TYapiProjectInfoMapper;
import org.ifs.yapi.pojo.req.ProjectAddParam;
import org.ifs.yapi.pojo.resp.GroupProjectInfo;
import org.ifs.yapi.service.IYApiProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * @author wangsong
 * @date 2024/10/07
 */
@Service
public class YApiProjectServiceImpl implements IYApiProjectService {

    @Resource
    private TYapiProjectInfoMapper projectInfoMapper;

    @Resource
    private IdWorker idWorker;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer addProject(ProjectAddParam param, String userId) {
        TYapiProjectInfo projectInfo = new TYapiProjectInfo();
        projectInfo.setId(String.valueOf(idWorker.nextId()));
        projectInfo.setName(param.getName());
        projectInfo.setGroupId(param.getGroupId());
        projectInfo.setBasePath(projectInfo.getBasePath());
        projectInfo.setDesc(param.getDesc());
        projectInfo.setProjectType(param.getProjectType());
        projectInfo.setUid(userId);
        projectInfo.setStrice("0");
        projectInfo.setIsJson5("0");
        projectInfo.setSwitchNotice("0");
        projectInfo.setIsMockOpen("0");
        projectInfo.setRole(Constant.USER_ROLE_MEMBER);
        projectInfo.setAddTime(LocalDateTime.now());
        projectInfo.setUpTime(LocalDateTime.now());
        projectInfoMapper.insertSelective(projectInfo);
        return 1;
    }

    @Override
    public List<GroupProjectInfo> queryByGroupId(String groupId, String userId) {

        return projectInfoMapper.queryByGroupId(groupId);
    }
}
