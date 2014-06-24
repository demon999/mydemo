package com.snow.oxmapper;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 14-6-23.
 */
@XStreamAlias("person")
public class Person {
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
