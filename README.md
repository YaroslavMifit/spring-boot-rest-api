# spring-boot-rest-api
Запуск приложения spring-boot-rest-api:
Скачать на компьютер проект spring-boot-rest-api используя команду
 git clone https://github.com/YaroslavMifit/spring-boot-rest-api.git 
открыть IntelliJ IDEA  зайти в File -> New -> Project from Existing Sources..  далее выбрать  проект -> выбрать Maven сборку, далее , далее, далее … проект собран.
Далее в ..\src\main\resources\application.properties указываем ваш логин, пароль и имя БД(где вы хотите, что бы приложение создало  и заполнило несколько сущностей при запуске)
spring.datasource.url=jdbc:mysql://localhost:3306/"ИМЯ ВАШЕЙ БД В MySQL",
spring.datasource.username="ВАШ ЛОГИН",
spring.datasource.password="ВАШ ПАРОЛЬ".
 Далее для того, что бы запустить приложение на SpringBoot нажимаем на кнопку Run.
