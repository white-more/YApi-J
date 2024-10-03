package org.ifs.yapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 请求query信息
 *
 * @author wangsong
 * @date 2024/10/04
 */
@Getter
@Setter
@Table(name = "T_YAPI_INTERFACE_REQ_QUERY")
public class TYapiInterfaceReqQuery {

    /**
     * 主键id
     */
    @Id
    private String id;
    /**
     * 接口id
     */
    private String interfaceId;
    /**
     * 字段名称
     */
    private String name;
    /**
     * 字段示例
     */
    private String example;
    /**
     * 字段描述
     */
    private String desc;
    /**
     * 是否必须
     */
    private String required;
}
