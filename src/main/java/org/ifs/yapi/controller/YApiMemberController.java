package org.ifs.yapi.controller;

import org.apache.commons.lang3.StringUtils;
import org.ifs.yapi.common.YResult;
import org.ifs.yapi.pojo.resp.MemberInfo;
import org.ifs.yapi.service.IYApiMemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 成员管理
 *
 * @author wangsong
 * @date 2024/10/06
 */
@RestController
@RequestMapping("/member")
public class YApiMemberController {

    @Resource
    private IYApiMemberService memberService;

    /**
     * 下拉模糊查询成员列表
     *
     * @param query 查询关键字
     * @return {@link YResult }<{@link List }<{@link MemberInfo }>>
     */
    @GetMapping("/queryMemberDic")
    public YResult<List<MemberInfo>> queryMemberDic(@RequestParam String query) {
        if(StringUtils.isBlank(query)) {
            throw new IllegalArgumentException("查询关键字不能为空");
        }
        return YResult.ok(memberService.queryMemberDic(query));
    }

}
