package org.ifs.yapi.pojo.req;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 添加分组
 * @author wangsong
 * @date 2024/10/06
 */
@Getter
@Setter
public class GroupAddParam {

    /**
     * 分组名称
     */
    @NotBlank
    @NotNull
    private String groupName;

    /**
     * 分组描述
     */
    @NotBlank
    @NotNull
    private String groupDesc;

    /**
     * 组长
     */
    @NotBlank
    @NotNull
    private String uid;
}
