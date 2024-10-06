package org.ifs.yapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 成员信息
 *
 * @author wangsong
 * @date 2024/10/04
 */
@Getter
@Setter
@Table(name = "T_YAPI_MEMBER_INFO")
public class TYapiMemberInfo {
    /**
     * 主键id
     */
    @Id
    private String id;
    /**
     * 成员id
     */
    private String uid;
    /**
     * 业务id
     */
    private String busId;
    /**
     * 成员归属（组成员、接口成员）
     */
    private String memberBelong;
    /**
     * 成员类型（开发者、访客、组长） owner、dev、guest
     */
    private String memberType;
    /**
     * 添加时间
     */
    private LocalDateTime addTime;
    /**
     * 更新时间
     */
    private LocalDateTime upTime;
}
