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
Fetch All Products 
GET http://localhost:3004/products

Get Recommendation 
POST http://localhost:3004/recommendation