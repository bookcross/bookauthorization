package com.trembear.bookauthorizationapi.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * description
 *
 * @author Junwei.Xiong
 * since 2018-12-12 11:10
 */
public class UserDto implements Serializable {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWxnumber() {
        return wxnumber;
    }

    public void setWxnumber(String wxnumber) {
        this.wxnumber = wxnumber;
    }

    public String getUserlogo() {
        return userlogo;
    }

    public void setUserlogo(String userlogo) {
        this.userlogo = userlogo;
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
        this.isused = isused;
    }
}

