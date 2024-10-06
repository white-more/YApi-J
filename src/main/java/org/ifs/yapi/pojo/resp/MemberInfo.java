package org.ifs.yapi.pojo.resp;

import lombok.Getter;
import lombok.Setter;

/**
 * 成员信息
 *
 * @author wangsong
 * @date 2024/10/06
 */
@Getter
@Setter
public class MemberInfo {

    /**
     * 成员id
     */
    private String uid;

    /**
     * 成员姓名
     */
    private String username;

    /**
     * 成员邮箱
     */
    private String email;
}
