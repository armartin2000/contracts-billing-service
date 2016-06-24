# contracts-billing-service
Spring Boot Restful Service Provider for Customer Access to their Contract and Billing Information

PROJECT DESCRIPTION:

Simple Spring Boot/Spring MVC/Hibernate Restful service to query Contract (3 types), Billing, Invoice, User, and Site  information

Service Endpoints:
    A. Contracts Billing Summary Controller
        - Aggregate contracts, billing, and invoices
        - base path: /contractsummary
    B. Contracts Controller
        - Query contracts
        - base context: /contracts
    C. Invoices Controller
            - Query invoices
            - base path: /invoices
    D.  Sites Controller
          - Query sites
          - base path: /sites
    E. User Controller
          - Query users
          - base path: /users

INSTALLATION:

1) Clone repository to local directory
2) Import project into IDE (Eclipse or IntelliJ)
3) Start Service:
        Run com.gci.service.contract.ContractApplication
        - (defaults) host: localhost, port: 8080
4) View Restful Service API - Swagger Api Explorer
        URL: http://localhost:8080/swagger-ui.html#/


