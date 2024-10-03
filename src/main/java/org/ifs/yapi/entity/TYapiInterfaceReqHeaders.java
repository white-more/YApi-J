package org.ifs.yapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 请求头信息
 *
 * @author wangsong
 * @date 2024/10/04
 */
@Getter
@Setter
@Table(name = "T_YAPI_INTERFACE_REQ_HEADERS")
public class TYapiInterfaceReqHeaders {
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
     * 参数名称
     */
    private String name;
    /**
     * 参数值
     */
    private String value;
    /**
     * 是否必须
     */
    private String required;
}
