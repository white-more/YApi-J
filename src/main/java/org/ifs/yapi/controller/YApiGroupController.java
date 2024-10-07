package org.ifs.yapi.controller;

import org.ifs.yapi.common.YResult;
import org.ifs.yapi.constant.Constant;
import org.ifs.yapi.entity.TYapiGroup;
import org.ifs.yapi.pojo.GroupInfo;
import org.ifs.yapi.pojo.req.GroupAddParam;
import org.ifs.yapi.pojo.resp.LoginUserInfo;
import org.ifs.yapi.service.IYApiGroupService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    /**
     * 根据用户id查询分组信息
     *
     * @param request
     * @return {@link YResult }<{@link List }<{@link GroupInfo }>>
     */
    @GetMapping("/queryByUserId")
    public YResult<List<GroupInfo>> queryByUserId(HttpServletRequest request) {
        LoginUserInfo userInfo = (LoginUserInfo) request.getSession().getAttribute(Constant.SESSION_KEY_NAME);
        return YResult.ok(yApiGroupService.queryByUserId(userInfo.getId()));
    }

    /**
     * 添加分组
     *
     * @param param   分组添加参数
     * @param request
     * @return {@link YResult }<{@link Integer }>
     */
    @PostMapping("/addGroup")
    public YResult<Integer> addGroup(@RequestBody @Validated GroupAddParam param, HttpServletRequest request) {
        LoginUserInfo userInfo = (LoginUserInfo) request.getSession().getAttribute(Constant.SESSION_KEY_NAME);
        return YResult.ok(yApiGroupService.addGroup(param.getGroupName()
                , param.getGroupDesc()
                , param.getUid()
                , userInfo.getId()));
    }


}
