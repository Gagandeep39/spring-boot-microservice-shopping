Eureka Server Port - 3000
MVC Application Port - 3001
Login Service Port - 3002
Server URL: http://192.168.56.1
------ Product Service ------
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
# Product Service 
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
ADD Product Details (Shouldnt be Done alone)
Update Stocks
POST http://localhost:3004/updatestock
{
"productId": 20,
"stocks": 50,
"productDetails": {
"productName": "OnePlus 8",
"productCategory": "Mobile",
"productPrice": 60000
}
}



# Cart Service 
Crete Cart 
POST 
ADD Items To Cart
POST http://localhost:3003/additem
customer info is optional as cartitemID itself is unique
{
    "quantity": 30,
    "productDetails": {
        "productDetailsId": 19,
        "productName": "OnePlus10",
        "productCategory": "Mobile",
        "productPrice": 60000
    },
    "cart": {
        "cartId": 15,
        "status": "Shopping",
        "customer": {
            "username": "gagandeep39",
            "password": "123456",
            "name": "Gagandeep",
            "address": "Earth",
            "email": "test@mail.com",
            "phoneNumber": "8877665544"
        }
    }
}





# Accss Hystrix Dashboard
http://localhost:3005/hystrix