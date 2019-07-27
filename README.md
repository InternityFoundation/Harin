# Helping Me Hibernate
Hibernate Technology used for operating on Employee 
Controller-Service-DAO :
  This is a part of MVC architecture widely used in companies. Here they are just Classes which work in this way:
     Controller calls service, Service calls DAO, DAO(Data Access Object) performs Hibernate Operation

# Employee Manager
Rest api for performing GET,PUT,POST operations using JPA. On an attempt to get a employee with id that doesn't exist, you'll get employees with last 100 ids

# SecurityEmailDemo
A rest api with the following 3 end points:
1) POST - for registration, send in username and password as json data; accessible to all
2) GET - for login, send username and password(not as json but in postman auth section); no output mean wrong credentials
3) PUT - for changing password, send username and password as you did  for login. Additionally, send a json data having username,previousPassword, newPassword and email. This will send you an email notification with new password.
  {UPDATE}: OAuth2 feature added for login end point, client ID and secret can be found in AuthenticationServerConfig class. Retreive access token from "/oauth/token" endpoint with POST request and use it as header for login.  
