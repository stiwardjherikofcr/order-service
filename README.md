# order-service
JPetStore is a microservices-based web application built on top of Spring Boot, Angular and Docker

requerimientos:
  -Java > 1.8
  -Loombok
  -Maven
  -MySql 8.0, port: 3306
  

Swagger: http://localhost:8888/swagger-ui.html

End-Points: 

  -OrderController:
    +Method Get, Url: http://localhost:8888/order, list order
      response: [
                  {
                    "id": 1,
                    "customer": null,
                    "paymentMethodId": null,
                    "products": null
                  }
                ]
    +Method Get, Url: http://localhost:8888/order/get-order?idOrder=1, get order
          response: 
                  {
                    "id": 1,
                    "customer": 1,
                    "paymentMethodId": 1,
                    "products": null
                  }
                
                
    +Method Get. Url: http://localhost:8888/order/list-order-by-customer?idCustomer=1, list order by customer
              response: [
                  {
                    "id": 1,
                    "customer": 1,
                    "paymentMethodId": 1,
                    "products": 1
                  }
                ]
                
    +Method Post, Url: http://localhost:8888/order, save order
     response: 1 (Long)
                  
     +Method Delete, Url: http://localhost:8888/order?idOrder=1, delete order
      response: 200(ok)
      
      
  -PaymentMethod:
    +Method Get, Url: http://localhost:8888/paymentMethod, list all
      response: [
                  {
                    "id": 2,
                    "name": "string"
                  }
                ]
                
     +Method Post, Url: http://localhost:8888/paymentMethod, save paymentMethod
      response: 3 (Long)
      
     +Method Delete, Url: http://localhost:8888/paymentMethod?id=2, delete paymentMethod
        response: 200 (ok)
        
        
 
