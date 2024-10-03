package org.ifs.yapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 项目token信息
 *
 * @author wangsong
 * @date 2024/10/04
 */
@Getter
@Setter
@Table(name = "T_YAPI_TOKEN")
public class TYapiToken {
    /**
     * 主键id
     */
    @Id
    private String id;
    /**
     * 项目id
     */
    private String projectId;
    /**
     * 登录用户id
     */
    private String uid;
    /**
     * token信息
     */
    private String token;
}
