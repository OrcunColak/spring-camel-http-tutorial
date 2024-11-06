package com.colak.springtutorial.route;

import com.colak.springtutorial.dto.OrderDTO;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class OrderRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Stage 1: Order Ingestion via HTTP endpoint
        from("jetty:http://localhost:8081/orders")
                .unmarshal().json(OrderDTO.class) // Convert JSON to DTO
                .process(new OrderValidator()) // Validate DTO
                .log("Ingesting valid order: ${body}")
                .to("seda:paymentProcessing");//seda component of Apache Camel

        // Stage 2: Payment Processing
        from("seda:paymentProcessing")
                .log("Processing payment for order: ${body}")
                .to("seda:shipping");

        // // Stage 3: Shipping
        from("seda:shipping")
                .log("Shipping order: ${body}")
                .process(exchange -> {
                    OrderDTO order = exchange.getIn().getBody(OrderDTO.class);
                    exchange.getIn().setBody("Shipped: " + order.getOrderId());
                });
    }
}
