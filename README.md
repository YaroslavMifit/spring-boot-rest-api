# spring-boot-rest-api
Приложение использует базу MySql перед сборкой исходника необходимо ввести свои настройки бд в файле \src\main\resources\application.properties

#Connection url for the database "one"
spring.datasource.url=jdbc:mysql://localhost:3306/one

#Username and password
spring.datasource.username=Username
spring.datasource.password=password

# Ветка master собирает jar file 
#Далее в консоли для сборки исходника необходимо ввести команду
mvn clean install

#Далее для запуска jar исходника необходимо в консоли ввести команду
java -Dfile.encoding=utf-8 -jar target\NVision.jar

#Приложение стартует на порту 8080
example: 
http://localhost:8080/demo/banks
http://localhost:8080/demo/clients
http://localhost:8080/demo/contributions
