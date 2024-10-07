package org.ifs.yapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 项目信息
 *
 * @author wangsong
 * @date 2024/10/04
 */
@Getter
@Setter
@Table(name = "T_YAPI_PROJECT_INFO")
public class TYapiProjectInfo {
    /**
     * 项目id
     */
    @Id
    private String id;
    /**
     * 接口基本路径
     */
    private String basePath;
    /**
     * 颜色
     */
    private String color;
    /**
     * 分组id
     */
    private String groupId;
    /**
     * 图标
     */
    private String icon;
    /**
     * 项目名称
     */
    @Column(name = "`NAME`")
    private String name;
    /**
     * 项目类型（public、private）
     */
    private String projectType;
    /**
     * 默认开启消息通知
     */
    private String switchNotice;
    /**
     * 创建用户id
     */
    private String uid;
    /**
     * 开启json5
     */
    private String isJson5;
    /**
     * mock严格模式
     */
    private String isMockOpen;
    /**
     * 角色
     */
    @Column(name = "`ROLE`")
    private String role;
    /**
     * 描述
     */
    @Column(name = "`DESC`")
    private String desc;
    /**
     *
     */
    private String strice;
    /**
     * 创建时间
     */
    private LocalDateTime addTime;
    /**
     * 更新时间
     */
    private LocalDateTime upTime;
}
