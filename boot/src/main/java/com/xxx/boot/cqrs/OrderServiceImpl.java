package com.xxx.boot.cqrs;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-07-21 13:58
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order findByNo(String no) {
        return Order.builder().no(UUID.randomUUID().toString()).createTime(new Date()).build();
    }
}
