# Demo EC

## module
 - customer-service :  manage customer.
   - customer register : register by phone number
   - customer address management : multiole address for receive product
   -  
 - vendor-service 
    - vendor register: 
    - 

- order-service
    - customer place order.
    - vendor check orders

### System Process
```mermaid
sequenceDiagram
    participant Alice
    participant Bob
    Alice->>John: Hello John, how are you?
    loop Healthcheck
        John->>John: Fight against hypochondria
    end
    Note right of John: Rational thoughts <br/>prevail!
    John-->>Alice: Great!
    John->>Bob: How about you?
    Bob-->>John: Jolly good!
```