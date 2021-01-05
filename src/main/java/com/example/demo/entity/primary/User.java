package com.example.demo.entity.primary;

import java.util.Date;
import javax.persistence.*;
@Table(name = "basic_user")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
    private String id;

    @Column(name = "UserName")
    private String username;

    @Column(name = "PassWord")
    private String password;

    @Column(name = "Tel")
    private String tel;

    @Column(name = "Email")
    private String email;

    @Column(name = "CreateName")
    private String createname;

    @Column(name = "CreateTime")
    private Date createtime;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return UserName
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return PassWord
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return Tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return CreateName
     */
    public String getCreatename() {
        return createname;
    }

    /**
     * @param createname
     */
    public void setCreatename(String createname) {
        this.createname = createname;
    }

    /**
     * @return CreateTime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}