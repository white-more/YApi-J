package org.ifs.yapi.controller;

import org.ifs.yapi.common.YResult;
import org.ifs.yapi.entity.TYapiGroup;
import org.ifs.yapi.service.IYApiGroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 分组信息控制器
 *
 * @author wangsong
 * @date 2024/10/01
 */
@RestController
@RequestMapping("/group")
public class YApiGroupController {

    @Resource
    private IYApiGroupService yApiGroupService;

    /**
     * 根据分组id查询分组信息
     *
     * @return {@link YResult }<{@link TYapiGroup }>
     */
    @GetMapping("/queryById")
    public YResult<TYapiGroup> queryById(String id) {
        return YResult.ok(yApiGroupService.queryById(id));
    }
}
