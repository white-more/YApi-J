package org.ifs.yapi.controller;

import org.ifs.yapi.common.PageResult;
import org.ifs.yapi.common.YResult;
import org.ifs.yapi.constant.Constant;
import org.ifs.yapi.pojo.req.ProjectAddParam;
import org.ifs.yapi.pojo.resp.GroupProjectInfo;
import org.ifs.yapi.pojo.resp.LoginUserInfo;
import org.ifs.yapi.service.IYApiProjectService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 项目管理
 *
 * @author wangsong
 * @date 2024/10/07
 */
@RestController
@RequestMapping("/project")
public class YApiProjectController {


    @Resource
    private IYApiProjectService projectService;

    /**
     * 添加项目
     *
     * @param param
     * @param request
     * @return {@link YResult }<{@link Integer }>
     */
    @PostMapping("/addProject")
    public YResult<Integer> addProject(@RequestBody @Validated ProjectAddParam param, HttpServletRequest request) {
        LoginUserInfo userInfo = (LoginUserInfo) request.getSession().getAttribute(Constant.SESSION_KEY_NAME);
        return YResult.ok(projectService.addProject(param, userInfo.getId()));
    }


    @GetMapping("queryProjectByGroupId")
    public YResult<PageResult<GroupProjectInfo>> queryProjectByGroupId(@RequestParam("groupId") String groupId
            , HttpServletRequest request) {
        LoginUserInfo userInfo = (LoginUserInfo) request.getSession().getAttribute(Constant.SESSION_KEY_NAME);
        return YResult.ok(PageResult.of(projectService.queryByGroupId(groupId,userInfo.getId())));
    }
}
