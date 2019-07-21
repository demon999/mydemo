package com.xxx.boot.cqrs;

import org.springframework.stereotype.Component;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-07-21 14:11
 */
@Component
public class CreateOrderCommand implements Command<CreateOrderModel> {
    @Override
    public void execute(CreateOrderModel createOrderModel) {
        System.out.println("CreateOrderCommand>>>" + createOrderModel.toString());
    }
}
