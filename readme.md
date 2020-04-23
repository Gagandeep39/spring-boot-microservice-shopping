Eureka Server Port - 3000
MVC Application Port - 3001
Login Service Port - 3002
Server URL: http://192.168.56.1

POST http://localhost:3002/register
Registeration Data
{
"username": "gagandeep39",
"password": "123456",
"name": "Gagandeep",
"email": "test@mail.com",
"address": "Earth",
"phoneNumber": "8877665544"
}
Login Data
POST http://localhost:3002/login
{
"username": "gagandeep",
"password": "12345"
}
Error Response
{
"status": 400,
"message": "Invalid Username Password",
"timeStamp": 1587574212202
}
FETCH Product
GET http://localhost:3004/products
Add Product
POST http://localhost:3004/products
{
"stocks": 1000,
"productDetails": {
"productName": "OnePlus 8",
"productCategory": "Mobile",
"productPrice": 60000
}
}
RESPONSE
{
"productId": 18,
"stocks": 1000,
"productDetails": {
"productDetailsId": 17,
"productName": "OnePlus 8",
"productCategory": "Mobile",
"productPrice": 60000.0
}
}
ADD Product Details (Shouldnt be Done)

Stock var inside a product

-> \*Universal stock list (Unidirectional from stocks)
->
