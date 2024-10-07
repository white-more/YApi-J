package org.ifs.yapi.service;

import org.ifs.yapi.pojo.req.ProjectAddParam;
import org.ifs.yapi.pojo.resp.GroupProjectInfo;

import java.util.List;

/**
 * @author wangsong
 * @date 2024/10/07
 */
public interface IYApiProjectService {
    Integer addProject(ProjectAddParam param, String userId);

    List<GroupProjectInfo> queryByGroupId(String groupId,  String userId);
}
