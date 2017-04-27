package com.feng.bean;


import javax.persistence.*;

@Entity
@Table(name = "B_rbac_user")
public class UserBean {

    @Id
    @GeneratedValue
    private String userid;
    @Column(name = "usercde")
    private String username;
    @Column(name = "userpwd")
    private String password;
    @Column(name = "username")
    private String displayName;

    public UserBean() {
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
