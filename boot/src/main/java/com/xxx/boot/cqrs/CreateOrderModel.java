package com.xxx.boot.cqrs;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-07-21 14:10
 */
@Data
@Builder
@ToString
public class CreateOrderModel {
    private String name;
}
