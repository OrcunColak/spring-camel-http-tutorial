# Read me

The original idea is from  
https://medium.com/@kiarash.shamaii/implementing-seda-pattern-in-order-processing-work-flow-with-apache-camel-and-spring-boot-a27b3e4cb944

```
curl -X POST http://localhost:8081/orders -H "Content-Type: application/json" -d '{"orderId":"1", "customerName":"John Doe"}'
curl -X POST http://localhost:8081/orders -H "Content-Type: application/json" -d '{"orderId":"2"}' # This will fail validation
```

Windows

```
curl -X POST http://localhost:8081/orders -H "Content-Type: application/json" -d "{\"orderId\":\"1\", \"customerName\":\"John Doe\"}"
curl -X POST http://localhost:8081/orders -H "Content-Type: application/json" -d "{\"orderId\":\"2\"}"
```