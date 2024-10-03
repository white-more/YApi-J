package org.ifs.yapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 请求表单信息
 *
 * @author wangsong
 * @date 2024/10/04
 */
@Getter
@Setter
@Table(name = "T_YAPI_INTERFACE_REQ_BODY_FORM")
public class TYapiInterfaceReqBodyForm {
    /**
     * 主键id
     */
    @Id
    private String id;
    /**
     * 接口ID
     */
    private String interfaceId;
    /**
     * 字段名称
     */
    private String name;
    /**
     * 字段描述
     */
    private String desc;
    /**
     * 字段类型
     */
    private String type;
    /**
     * 示例
     */
    private String example;
    /**
     * 是否必须
     */
    private String required;
}
