package org.ifs.yapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 请求路径参数信息
 *
 * @author wangsong
 * @date 2024/10/04
 */
@Getter
@Setter
@Table(name = "T_YAPI_INTERFACE_QUERY_PATH_PARAMS")
public class TYapiInterfaceQueryPathParams {
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
}
