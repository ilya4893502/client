import java.util.List;

public class YandexResponse {

    // Во-первых, у объекта JSON есть ключ translations. Это массив из объектов, каждый из которых
    // содержит 2 ключа: text и detectedLanguageCode.
    // Поэтому создадим класс Translation.

    // Создадим поле translations список из класса Translation.
    private List<Translation> translations;
    // Имя поля должно быть таким же как и в JSON.


    public List<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }


    // Теперь YandexResponse полностью соответствует JSON, который пришел от Yandex. Так как у него есть
    // поле translations. Это поле является списком из переводов.
    // Каждый объект Translation - это text и detectedLanguageCode.
}
