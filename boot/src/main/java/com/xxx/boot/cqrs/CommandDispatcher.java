package com.xxx.boot.cqrs;

import org.springframework.stereotype.Component;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-07-21 21:10
 */
@Component
public class CommandDispatcher {

    public void dispatch(Command command, CreateOrderModel createOrderModel) {
        command.execute(createOrderModel);
    }

}
