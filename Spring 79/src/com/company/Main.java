package com.company;

import java.io.PrintWriter;

public class Main {

    // REST API Клиент.

    // На этом уроке будем делать запросы к сторонним REST API сервисам и будем получать от них данные в
    // формате JSON. И эти данные мы распарсим с помощью Jackson.

    // Пока мы не подключаем Spring, мы не создаем свой REST API сервис.


    // Создадим Maven-проект без архетипа.

    // Подключим зависимости к этому проекту.
    // 1) Jackson Databind. Так как нам нужно парсить JSON.
    // 2) Spring Web. Эта зависимость нужна потому что в этой зависимости есть специальный класс RestTemplate,
    // с помощью которого будет удобно делать запросы к стороннему REST API сервису. Но можно обойтись и без
    // него.


    // Создадим класс Consumer, из которого мы и будем делать запросы к REST API сервису.
    // Теперь нужно выбрать этот сторонний сервис, к которому будем делать запрос.
    // Для этого зайдем на сайт reqres. Тут мы можем делать запрос и получать ответ в виде JSON.


    // Далее используем другой REST API сервис. Используем Yandex Translate API.
    // Создадим новый класс Translator.
}
