package org.ifs.yapi.pojo.resp;

import lombok.Getter;
import lombok.Setter;

/**
 * 分组项目信息
 *
 * @author wangsong
 * @date 2024/10/07
 */
@Getter
@Setter
public class GroupProjectInfo {

    /**
     * 项目id
     */
    private String id;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 创建用户id
     */
    private String uid;
}
