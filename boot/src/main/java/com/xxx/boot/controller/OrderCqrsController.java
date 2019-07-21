package com.xxx.boot.controller;

import com.xxx.boot.cqrs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-07-21 14:03
 */
@RestController
@RequestMapping("/orders")
public class OrderCqrsController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CommandDispatcher commandDispatcher;
    @Autowired
    private CreateOrderCommand createOrderCommand;

    @GetMapping("/{no}")
    public Order findByNo(@PathVariable String no) {
        return orderService.findByNo(no);
    }

    @PostMapping
    public void create(@RequestBody CreateOrderModel createOrderModel) {
        commandDispatcher.dispatch(createOrderCommand, createOrderModel);
    }

}
