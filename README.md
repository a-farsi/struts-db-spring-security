# Struts 1.3 

### Maven Project Structure  
![validate_login](https://user-images.githubusercontent.com/32627919/35639772-742fc69e-06a2-11e8-8c90-744751ccafbd.PNG)


## DataBase Configuration :

1. create a network 

_docker network create afa-network_

2. use mysql runing on a container, so do pull the image first and start it.

_docker run --name docker-mysql --network afa-network -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql_


3. use mysql client program to connect to the mysql server. Let's install phpMyAdmin to acces to the mysql DB through a user interface.
 
_docker run -d --name docker-phpmyadmin --network afa-network -e PMA_HOST=docker-mysql -p 8080:80 phpmyadmin/phpmyadmin_

---

Links:

http://keylesson.com/index.php/2014/10/05/struts-1-hibernate-integration-example-856/  
http://javaonlineguide.net/2014/11/struts-validator-framework-example-step-by-step-guide.html  
