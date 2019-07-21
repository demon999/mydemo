package com.xxx.boot.cqrs;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-07-21 13:57
 */
public interface OrderService {

    /**
     * find order
     * @param no
     * @return
     */
    Order findByNo(String no);
}
