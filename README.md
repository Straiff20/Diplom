## Тестирование веб-сервиса по покупке тура

Данный проект представляет собой дипломную работу по тестированию веб-сервиса, взаимодействующего с СУДБ и API банка.

#### Запуск приложения

1. Запустить [Docker](https://hub.docker.com/).
1. Развернуть все контейнеры в терминале [IDEA](https://www.jetbrains.com/ru-ru/idea/) командой:
        ````
        docker-compose up -d
        ````
1. Ввести команду для запуска тестов(так же генерируется отчёт Gradle:
        ````
        gradlew clean test
        ````
1. Для генерации отчёта Allure ввести команду:
        ````
        gradlew allureReport
        ````
1. Для получения отчёта Allure, ввести команду:
        ````
        gradlew allureServe
        ````
1. Для переключения между базами необходимо закоментарить или раскоментарить
нужную строку в файле [application.properties](https://github.com/Straiff20/Diplom/blob/master/application.properties)


[План работы](https://github.com/Straiff20/Diplom/blob/master/Plan.md)

[Отчёт о проделанной работе](https://github.com/Straiff20/Diplom/blob/master/Report.md)

CI/CD badge:

[![Build status](https://ci.appveyor.com/api/projects/status/ge4e0tmscml73pxn/branch/master?svg=true)](https://ci.appveyor.com/project/Straiff20/diplom/branch/master)
