package com.trembear.bookauthorization.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class BCUser  implements UserDetails {
    private Integer userid;

    private String username;

    private String password;

    private String salt;

    private String phone;

    private String wxnumber;

    private String userlogo;

    private Integer bookcoin;

    private String isused;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getWxnumber() {
        return wxnumber;
    }

    public void setWxnumber(String wxnumber) {
        this.wxnumber = wxnumber == null ? null : wxnumber.trim();
    }

    public String getUserlogo() {
        return userlogo;
    }

    public void setUserlogo(String userlogo) {
        this.userlogo = userlogo == null ? null : userlogo.trim();
    }

    public Integer getBookcoin() {
        return bookcoin;
    }

    public void setBookcoin(Integer bookcoin) {
        this.bookcoin = bookcoin;
    }

    public String getIsused() {
        return isused;
    }

    public void setIsused(String isused) {
        this.isused = isused == null ? null : isused.trim();
    }
}