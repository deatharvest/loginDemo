package com.jn.security.mysql.po.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by death on 2016/8/1.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "adm_admin")
public class DbUserPo {

    @Id
    @Column(length = 40, nullable = false)
    private String username;

    @Column(length = 40, nullable = false)
    private String password;


    private Integer access;

    //getter/setter


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

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }
}