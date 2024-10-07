package org.ifs.yapi.pojo.req;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 添加项目参数
 *
 * @author wangsong
 * @date 2024/10/07
 */
@Getter
@Setter
public class ProjectAddParam {

    /**
     * 项目名称
     */
    @NotBlank
    @NotNull
    private String name;

    /**
     * 项目分组
     */
    @NotBlank
    @NotNull
    private String groupId;

    /**
     * 基本路径
     */
    private String basePath;

    /**
     * 描述
     */
    private String desc;

    /**
     * 权限
     */
    @NotBlank
    @NotNull
    private String projectType;
}
