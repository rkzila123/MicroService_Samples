INSERT INTO PROPERTIES( APPLICATION_ID, PROFILE, LABEL, CONFIG_KEY, CONFIG_VALUE) 
values('myconfig', 'default', 'demo', 'microservice.payment.services.endpoint.uri', 'http://PAYMENT-SERVICE/payment/doPayment');
INSERT INTO PROPERTIES( APPLICATION_ID, PROFILE, LABEL, CONFIG_KEY, CONFIG_VALUE) 
values('myconfig', 'default', 'demo', 'microservice.order.services.endpoint.uri', 'http://ORDER-SERVICE/order/bookOrder');
INSERT INTO PROPERTIES( APPLICATION_ID, PROFILE, LABEL, CONFIG_KEY, CONFIG_VALUE) 
values('myconfig', 'default', 'demo', 'eureka.client.register-with-eureka', 'true');
INSERT INTO PROPERTIES( APPLICATION_ID, PROFILE, LABEL, CONFIG_KEY, CONFIG_VALUE) 
values('myconfig', 'default', 'demo', 'eureka.client.fetch-registry', 'true');
INSERT INTO PROPERTIES( APPLICATION_ID, PROFILE, LABEL, CONFIG_KEY, CONFIG_VALUE) 
values('myconfig', 'default', 'demo', 'eureka.client.service-url.defaultZone', 'http://localhost:8761/eureka/');
INSERT INTO PROPERTIES( APPLICATION_ID, PROFILE, LABEL, CONFIG_KEY, CONFIG_VALUE) 
values('myconfig', 'default', 'demo', 'eureka.instance.hostname', 'localhost');