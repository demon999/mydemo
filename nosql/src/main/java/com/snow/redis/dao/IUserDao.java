package com.snow.redis.dao;

import com.snow.redis.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Richard on 14-8-25.
 */
public interface IUserDao {
    boolean add(User user);
    boolean add(List<User> list);
    void delete(String key);
    void delete(List<String> keys);
    boolean update(User user);
    User get(String keyId);
}
