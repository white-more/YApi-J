package org.ifs.yapi.mapper;

import org.apache.ibatis.annotations.Param;
import org.ifs.yapi.entity.TYapiGroup;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TYapiGroupMapper extends Mapper<TYapiGroup> {
    TYapiGroup queryPrivateGroup(@Param("userId") String userId);

    List<TYapiGroup> queryOwnGroup(@Param("userId") String userId);

    List<TYapiGroup> queryOtherGroup(@Param("userId") String userId);
}
