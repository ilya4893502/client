import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translator {

    public static void main(String[] args) throws JsonProcessingException {

        // Тут будем делать запросы к Yandex Translate API.
        // Будем посылать запросы на русском языке и нам будет приходить ответ на английском.

        // Сначала будем принимать то, что введет человек.
        System.out.println("Введите сообщение на русском языке");
        Scanner scanner = new Scanner(System.in);
        String sentenceToTranslate = scanner.nextLine();

        // Создадим RestTemplate.
        RestTemplate restTemplate = new RestTemplate();

        // Из документации берем url.
        String url = "https://translate.api.cloud.yandex.net/translate/v2/translate";

        // В самом запросе необходимо передавать заголовки (-H):
        // - Content-Type, чтобы показать то, что передаем в теле JSON.
        // - Authorization, это тот токен, который мы получили при регистрации.
        HttpHeaders headers = new HttpHeaders();

        // Сначала мы указали, что передается JSON.
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Тут укажем токен.
        headers.add("Authorization", "Bearer " + "туи указывается свой токен");

        // Теперь в формате JSON в запросе нужно передать данные (folderId, texts, targetLanguages).
        // Это id, которое дается при регистрации; текст, который мы хотим перевести; язык, на который
        // нужен перевод.
        Map<String, String> jsonData = new HashMap<>();
        jsonData.put("folderId", "folderId дается при регистрации");
        jsonData.put("targetLanguages", "en");
        jsonData.put("texts", "[" + sentenceToTranslate + "]");
        // Передается массив из текстов. За раз можно передать сразу массив из текстов, чтобы Yandex их
        // перевел.

        // Далее мы должны положить этот словарь в HttpEntity
        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonData, headers);
        // Мы передаем в HttpEntity сам словарь и заголовки.

        // Далее делаем запрос.
        String response = restTemplate.postForObject(url, request, String.class);

        // Выведем на экран ответ от Yandex.
//        System.out.println(response);

        // Запустим, введем строку на русском в Scanner и нам придет перевод в виде JSON.

        // Теперь мы должны этот JSON распарсить, для этого используем Jackson.
        // С помощью ObjectMapper можно распарсить любою строчку JSON.
        ObjectMapper mapper = new ObjectMapper();

        // С помощью Jackson можно создать собственный класс, который будет соответствовать этому JSON.
        // И Jackson автоматически спарсит этот JSON. Но если мы не хотим создавать класс, то используем
        // ObjectMapper.

        // Используем метод readTree, чтобы распарсить. Объект JsonNode - это уже распарсенный объект.
        JsonNode obj = mapper.readTree(response);

        // Теперь можно получать доступ к отдельным ключам JSON.
        System.out.println("Перевод: " + obj.get("translations").get(0).get("text"));
        // Так мы получили доступ к значению ключа translations (это массив). Из массива translations
        // получаем доступ к 0-му элементу и значению ключа text.
        // Выводится только перевод, а не полный объект JSON.


        // Чтобы постоянно не парсить JSON с помощью ObjectMapper можно создать Java-класс. Так как
        // структура JSON огаваривается заранее.
        // Создадим класс YandexResponse, который будет соответствовать JSON'у, который пришел от Yandex.
        // Теперь JSON спарсим в объекты созданных классов.

        // Вместо String.class пишется YandexResponse.class.
        YandexResponse response1 = restTemplate.postForObject(url, request, YandexResponse.class);

        // Теперь на этом Java-объекте можно вызывать геттеры, чтобы обращаться к полям.
        System.out.println("Перевод: " + response1.getTranslations().get(0).getText());
        // Мы обращаемся к полю translations, так как оно является списком обращаемся к 0-му элементу
        // этого списка. И из этого элемента получаем поле text.

        // Работает также.
    }
}
