package com.xxx.boot.cqrs;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-07-21 13:58
 */
@Data
@Builder
public class Order {
    private String no;
    private String name;
    private int status;
    private Date createTime;
}
