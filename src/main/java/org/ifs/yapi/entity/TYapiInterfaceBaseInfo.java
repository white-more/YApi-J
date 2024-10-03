package org.ifs.yapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 接口基本信息
 *
 * @author wangsong
 * @date 2024/10/04
 */
@Getter
@Setter
@Table(name = "T_YAPI_INTERFACE_BASE_INFO")
public class TYapiInterfaceBaseInfo {
    /**
     * 主键id
     */
    @Id
    private String id;
    /**
     * 排序
     */
    private Integer index;
    /**
     * 接口名称
     */
    private String title;
    /**
     * 接口请求方式
     */
    private String method;
    /**
     * 接口请求地址
     */
    private String path;
    /**
     * 项目id
     */
    private String projectId;
    /**
     * 接口分组id
     */
    private String catId;
    /**
     * 开放接口
     */
    private String apiOpened;
    /**
     * 接口创建者id
     */
    private String uid;
    /**
     * 修改者id
     */
    private String editUid;
    /**
     * markdown描述信息
     */
    private String markdown;
    /**
     * 描述信息
     */
    private String desc;
    /**
     * 请求体是否JSON
     */
    private String reqBodyIsJsonSchema;
    /**
     * 请求体类型（form、json）
     */
    private String reqBodyType;
    /**
     * 请求体内容
     */
    private String reqBodyOther;
    /**
     * 响应体是否JSON
     */
    private String resBodyIsJsonSchema;
    /**
     * 响应体内容
     */
    private String resBody;
    /**
     * 响应体类型（json）
     */
    private String resBodyType;
    /**
     * 状态
     */
    private String status;
    /**
     * 类型
     */
    private String type;
    /**
     * 添加时间
     */
    private LocalDateTime addTime;
    /**
     * 更新时间
     */
    private LocalDateTime upTime;
}
