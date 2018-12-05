package com.trembear.bookauthorization.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class BackendUser implements UserDetails {
    private static final long serialVersionUID = 1;
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 用户头像地址
     */
    private String userLog;

    /**
     * 用户邮箱
     */
    private String userMail;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 登录错误最大次数
     */
    private Integer longErrorTimes;

    /**
     * 状态（0：停用  1 启动 2锁定）
     */
    private Integer status;

    /**
     * 创建人
     */
    private Integer createOperator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Integer modifyOperator;

    /**
     * 创建时间
     */
    private Date modifyTime;

    /**
     * 获取用户ID
     *
     * @return USER_ID - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 设置用户姓名
     *
     * @param username 用户姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取用户头像地址
     *
     * @return USER_LOG - 用户头像地址
     */
    public String getUserLog() {
        return userLog;
    }

    /**
     * 设置用户头像地址
     *
     * @param userLog 用户头像地址
     */
    public void setUserLog(String userLog) {
        this.userLog = userLog;
    }

    /**
     * 获取用户邮箱
     *
     * @return USER_MAIL - 用户邮箱
     */
    public String getUserMail() {
        return userMail;
    }

    /**
     * 设置用户邮箱
     *
     * @param userMail 用户邮箱
     */
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    /**
     * 获取用户昵称
     *
     * @return USER_NICKNAME - 用户昵称
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * 设置用户昵称
     *
     * @param userNickname 用户昵称
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }


    /**
     * 设置用户密码
     *
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = (password ==null?null: password.trim());
    }

    /**
     * 获取登录错误最大次数
     *
     * @return LONG_ERROR_TIMES - 登录错误最大次数
     */
    public Integer getLongErrorTimes() {
        return longErrorTimes;
    }

    /**
     * 设置登录错误最大次数
     *
     * @param longErrorTimes 登录错误最大次数
     */
    public void setLongErrorTimes(Integer longErrorTimes) {
        this.longErrorTimes = longErrorTimes;
    }

    /**
     * 获取状态（0：停用  1 启动 2锁定）
     *
     * @return STATUS - 状态（0：停用  1 启动 2锁定）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态（0：停用  1 启动 2锁定）
     *
     * @param status 状态（0：停用  1 启动 2锁定）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建人
     *
     * @return CREATE_OPERATOR - 创建人
     */
    public Integer getCreateOperator() {
        return createOperator;
    }

    /**
     * 设置创建人
     *
     * @param createOperator 创建人
     */
    public void setCreateOperator(Integer createOperator) {
        this.createOperator = createOperator;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改人
     *
     * @return MODIFY_OPERATOR - 修改人
     */
    public Integer getModifyOperator() {
        return modifyOperator;
    }

    /**
     * 设置修改人
     *
     * @param modifyOperator 修改人
     */
    public void setMpdifyOperator(Integer modifyOperator) {
        this.modifyOperator = modifyOperator;
    }

    /**
     * 获取创建时间
     *
     * @return MODIFY_TIME - 创建时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置创建时间
     *
     * @param modifyTime 创建时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}