package com.dingzhen.entity;

import java.io.Serializable;

/**
 *
 *
 * @author dingzhen*/
public class SysUser  implements Serializable {

    private static final long serialVersionUID = -1125391840273441527L;
    /**
     * 用户ID
     **/

    private String userId;
    /**
     * 用户编号
     **/

    private String userCode;
    /**
     * 用户姓名
     **/

    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId='" + userId + '\'' +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
