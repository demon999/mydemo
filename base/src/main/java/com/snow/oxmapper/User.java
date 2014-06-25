package com.snow.oxmapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Administrator on 14-6-23.
 */
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    private int id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Person [id=" + id + ", username=" + username + ", password=" + password + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
