package com.colak.springtutorial.route;

import com.colak.springtutorial.dto.OrderDTO;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class OrderValidator implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        OrderDTO order = exchange.getIn().getBody(OrderDTO.class);
        if (order.getOrderId() == null || order.getCustomerName() == null) {
            throw new RuntimeException("Invalid order: missing properties");
        }
    }
}
