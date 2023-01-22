import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Consumer {

    public static void main(String[] args) {

        // Тут мы будем делать запросы.

        // Сделаем запрос к сервису reqres.

        // Создадим класс RestTemplate.
        RestTemplate restTemplate = new RestTemplate();
        // С помощью этого объекта и будем делать запрос к удаленным сервисам.

        // Сначала введем адрес, на который будем делать запрос.
        String url = "https://reqres.in/api/users?page=2";

        // Сделаем GET-запрос, поэтому используем метод getForObject. Если мы делали POST-запрос, то
        // использовали бы postForObject. И так для всех http-методов.
        String response = restTemplate.getForObject(url, String.class);
        // В аргументах мы указали url и объект JSON, пока в формате строки.

        // Выведем в консоль то, что пришло от сервиса.
        System.out.println(response);
        // Выводится на экран строчка с JSON, которая пришла с удаленного сервера.

        // Так мы сделали GET-запрос к удаленному серверу.



        // Далее сделаем POST-запрос к удаленному REST API.

        // Тут мы должны передавать JSON на удаленный REST API сервис.
        // Поэтому создадим HashMap, так как в нем данные хранятся также в формате ключ-значение.
        Map<String, String> jsonToSend = new HashMap<>();

        // Поместим значения в этот словарь.
        jsonToSend.put("name", "Test name");
        jsonToSend.put("name2", "Test name2");

        // Чтобы отправить этот JSON нужно упаковать его в HttpEntity.
        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend);
        // Этот словарь преобразуется в JSON, и на удаленный сервис придет http-запрос с данным JSON в
        // теле запроса.

        // Сделаем POST-запрос для создания нового пользователя.
        String url2 = "https://reqres.in/api/users";

        // Для POST-запроса используем postForObject. Также нужно в запросе указать объект HttpEntity.
        String response2 = restTemplate.postForObject(url2, request, String.class);

        System.out.println(response2);
        // Нам пришел JSON с нашими данными.


    }
}
