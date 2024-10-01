package org.ifs.yapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 分组信息
 *
 * @author wangsong
 * @date 2024/10/01
 */
@Getter
@Setter
@Table(name = "T_YAPI_GROUP")
public class TYapiGroup {
    /**
     * 主键id
     */
    @Id
    private String id;
    /**
     * 分组名称
     */
    private String groupName;
    /**
     * 分组描述
     */
    private String groupDesc;
    /**
     * 分组类型public、private
     */
    private String type;
    /**
     * 分组创建者id
     */
    private String uid;
    /**
     * 更新时间
     */
    private LocalDateTime upTime;
    /**
     * 添加时间
     */
    private LocalDateTime addTime;
    /**
     * 组角色
     */
    private String role;
    /**
     * 自定义字段
     */
    private String customField1;
}
