
# АВТОТЕСТИРОВАНИЕ ВЕБ-ПРИЛОЖЕНИЯ ДЛЯ ПОКУПКИ ТУРА ДВУМЯ СПОСОБАМИ ПЛАТЕЖА
Тестируемое приложение — это веб-сервис, который предлагает купить тур по определённой цене двумя способами:

    - обычная оплата по дебетовой карте.
    - выдача кредита по данным банковской карты.

## УСТАНОВКА НЕОБХОДИМЫХ ИНСТРУМЕНТОВ И КОМПОНЕНТОВ

1. Установить на рабочую станцию и настроить следующие приложения:
   - IntelliJ IDEA
   - Git
   - Docker Desktop
2. Запустить Git Bash.
3. В терминале Git Bash выполнить команду git clone git@github.com:netology-code/qa-diploma.git/
4. Открыть папку в IntelliJ IDEA, настроить проект (Open Module Settings--> Project --> Name = "...", -->SDK = correcto-11 java version 11.0.21)
5. Создать файл build.gradle, установить плагины и настроить зависимости:
   plugins {
       id 'java'
       id "io.freefair.lombok" version "8.2.2"
       id "io.qameta.allure" version "2.11.2"
   }
   dependencies {
       testImplementation 'org.junit.jupiter:junit-jupiter:5.9.0'
       testImplementation 'org.junit.vintage:junit-vintage-engine:5.8.2'
       testImplementation 'com.codeborne:selenide:6.17.1'
       testImplementation 'com.github.javafaker:javafaker:1.0.2'
       testImplementation 'org.slf4j:slf4j-simple:1.7.32'
       testImplementation 'io.rest-assured:rest-assured:5.3.1'
       testImplementation 'io.rest-assured:json-schema-validator:4.3.0'
       testImplementation 'com.google.code.gson:gson:2.10.1'
       testImplementation 'mysql:mysql-connector-java:8.0.30'
       testImplementation 'commons-dbutils:commons-dbutils:1.7'
   }
6. Создать директорию scr
7. Сделать Rebuild проекта
8. В файле application.properties прописать путь к базе Postgresql "spring.datasource.url=jdbc:postgresql://localhost:5432/app"
9. Создать файл docker-compose.yml со следующими настройками:
   version: '3.1'
   services:

   db1:
   image: mysql:8.0
   restart: always
   environment:
   MYSQL_DATABASE: app
   MYSQL_USER: app
   MYSQL_PASSWORD: pass
   MYSQL_ROOT_PASSWORD: pass
   volumes:
   - ./data/mysql:/var/lib/mysql
   ports:
   - '3306:3306'

   db2:
   image: postgres:13-alpine
   restart: always
   environment:
   POSTGRES_PASSWORD: pass
   POSTGRES_DATABASE: app
   POSTGRES_USER: app
   volumes:
   - ./data/postgresql:/var/lib/postgresql/data
   ports:
   - '5432:5432'
    
   node:
   image: node:8
   user: "node"
   working_dir: /home/node/app
   environment:
   - NODE_ENV=production
   volumes:
   - ./data/node/gate-simulator:/home/node/app
   ports:
   - '9999:9999'
   command: "npm start"
    
   phpmyadmin:
   image: phpmyadmin
   restart: always
   ports:
   - '8081:80'
   depends_on:
   - db1
   environment:
   - PMA_ARBITRARY=1

##    АВТОТЕСТИРОВАНИЕ

1. Запустить в терминале контейнеры командой docker compose up --build

### на базе MySQL

* Запустить БД MySQL командой java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar aqa-shop.jar
* Запустить тесты командой ./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"

### на базе PostgreSQL

* Запустить БД PostgreSQL командой java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar aqa-shop.jar
* Запустить тесты в терминале командой ./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"

2. Запустить в терминале команду ./gradlew allureServe для получения отчета по тестам
3. Остановить контейнеры командой docker compose down
4. Остановить jar-файл командой java -jar aqa-shop.jar down
