package org.ifs.yapi.mapper;


import org.apache.ibatis.annotations.Param;
import org.ifs.yapi.entity.TYapiProjectInfo;
import org.ifs.yapi.pojo.resp.GroupProjectInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TYapiProjectInfoMapper extends Mapper<TYapiProjectInfo> {
    /**
     * 根据分组id查询用户项目信息
     *
     * @param groupId 分组id
     * @return {@link List }<{@link GroupProjectInfo }>
     */
    List<GroupProjectInfo> queryByGroupId(@Param("groupId") String groupId);
}
