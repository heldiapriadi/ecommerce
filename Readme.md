# E-Commerce API
This is an OpenAPI definition for an API that provides functionality for E-Commerce. The API includes the following endpoints:

## Enitity Relationship Diagram (ERD)
![image.png]( https://raw.githubusercontent.com/heldiapriadi/ecommerce/master/other/ecommerce-erd.png )
## Endpoints
### Add to Cart
**_POST /api/v1/shopping-cart/add-to-cart_**

This endpoint allows customers to add items to their shopping cart. It requires a JSON request body with the following properties:

* customerId (integer, format: int64): The ID of the customer
* productId (integer, format: int64): The ID of the product
* quantity (integer, format: int32): The quantity of the product to add to the cart

This endpoint requires authentication using a bearer token.

### Checkout
**_POST /api/v1/checkout_**

This endpoint allows customers to checkout their shopping cart. It requires a JSON request body with the following properties:

* customerId (integer, format: int64): The ID of the customer
* cartId (array of integers, format: int64): The ID of the shopping cart
* paymentId (array of integers, format: int32): The ID of the payment method

This endpoint requires authentication using a bearer token.

### Register
**_POST /api/v1/auth/register_**

This endpoint allows customers to register for an account. It requires a JSON request body with the following properties:

* name (string): The name of the customer
* email (string): The email address of the customer
* password (string): The password for the account
* address (string): The address of the customer

### Login
**_POST /api/v1/auth/login_**

This endpoint allows customers to login to their account. It requires a JSON request body with the following properties:

* email (string): The email address of the customer
* password (string): The password for the account

### Get Cart
**_GET /api/v1/shopping-cart/get-cart_**

This endpoint allows customers to retrieve the items in their shopping cart. It requires a query parameter
* customer_id (integer, format: int64) which is the ID of the customer.

This endpoint requires authentication using a bearer token.

### Get Product by Category
**_GET /api/v1/product-category_**

This endpoint allows customers to retrieve products by category. It requires a query parameter
* category_id (integer, format: int64) which is the ID of the category.

### Remove from Cart
**_DELETE /api/v1/shopping-cart/remove-from-cart_**

This endpoint allows customers to remove items from their shopping cart. It requires a JSON request body with the following properties:

* customerId (integer, format: int64): The ID of the customer
* productId (integer, format: int64): The ID of the product
* quantity (integer, format: int32): The quantity of the product to remove from the cart

This endpoint requires authentication using a bearer token.

### Clear Cart
**_DELETE /api/v1/shopping-cart/clear-cart_**

This endpoint allows customers to clear all items from their shopping cart. It requires a JSON request body with the following properties:
* customerId (integer, format: int64): The ID of the customer

This endpoint requires authentication using a bearer token.

### Authentication
Some of the endpoints in this API require authentication using a bearer token. This token should be included in the **'Authorization'** header of the request in the following format: **'Bearer <token>'**.

## Responses
All successful requests will return a response with a status code of 200 OK and a JSON object containing the data related to the request.

## Accessing the API documentation
To access the API documentation and try out the endpoints, you can use the Swagger UI by visiting **/swagger-ui/index.html** in your web browser. The Swagger UI allows you to interact with the API, send requests, and view responses without writing any code.

## Notes
In addition to the features described above, this API also includes logging using MongoDB with the "ecommerce" database and "logs" collection. Each time a request is received by the API, the request and response information will be recorded in the "logs" collection as analysis and troubleshooting material. This allows tracking user activity and identifying potential issues within the system.