package org.ifs.yapi.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.ifs.yapi.entity.TYapiGroup;
import org.ifs.yapi.mapper.TYapiGroupMapper;
import org.ifs.yapi.service.IYApiGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class YApiGroupServiceImpl implements IYApiGroupService {

    @Resource
    private TYapiGroupMapper yapiGroupMapper;

    @Override
    public TYapiGroup queryById(String id) {
        if (StringUtils.isBlank(id)) {
            throw new IllegalArgumentException("分组id不能为空");
        }
        return yapiGroupMapper.selectByPrimaryKey(id);
    }
}
