public class Translation {

    // В этом классе будет лежать перевод ключей.

    private String text;
    private String detectedLanguageCode;
    // Имена полей должно быть такими же как и в JSON.


    // Обязательно нужны геттеры и сеттеры.

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDetectedLanguageCode() {
        return detectedLanguageCode;
    }

    public void setDetectedLanguageCode(String detectedLanguageCode) {
        this.detectedLanguageCode = detectedLanguageCode;
    }
}
