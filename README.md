# springoauth2demo
1.  integrate spring oauth2 security, seperate resource server and security server 
2.  integrate swagger with security 
3.  use database to store user name and password, and secure server visit userdetailservice and return access_token correspondingly  

Need to run in local:
##1. startup redis db local with default port 6379
2. mysql   
CREATE SCHEMA `svae` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
3. execute schema.sql


build 
1. mvn package
2. mvn dockerfile:build / docker-compose build
3. docker-compose up -d  shutdown docker-compose down