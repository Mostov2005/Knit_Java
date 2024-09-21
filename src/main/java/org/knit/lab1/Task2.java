package org.knit.lab1;

/***
 * Задача 2
 * Создайте класс SimpleUrl
 * глядя на URL ниже создайте как можно больше полей в классе SimpleUrl:
 * https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText
 * добавьте геттеры и сеттеры для полей
 * Переопределите метод toString() для вывода информации о полях класса:
 * protocol = https
 * address = test.ru
 * domainZone = ru
 * siteName = test
 * webpageName = page.jsp
 * webPageExtention = jsp
 * ....
 * Распарсите данный URL на переменные, создайте экземпляр класса SimpleUrl и выведите на экран
 * Дополнительно
 * попробуйте с другими URL в сети, подумайте как можно сгруппировать значения.
 *
 */
public class Task2 {
    public void execute() {

        String urlValue = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";

        // Разбираем URL
        String[] parts = urlValue.split("://");
        String protocol = parts[0];
        String restOfUrl = parts[1];

        String[] addressAndParams = restOfUrl.split("\\?");
        String addressPart = addressAndParams[0];
        String paramsPart = addressAndParams.length > 1 ? addressAndParams[1] : "";

        // Разбираем адрес
        String[] addressParts = addressPart.split("/");
        String address = addressParts[0];
        String[] domainParts = address.split("\\.");
        String domainZone = domainParts[1];
        String siteName = domainParts[0];

        String webpage = addressParts[addressParts.length - 1];
        String[] webpageParts = webpage.split("\\.");
        String webpageName = webpageParts[0];
        String webpageExtension = webpageParts[1];

        // Разбираем параметры
        String[] params = paramsPart.split("&");
        String intParam = "";
        String doubleParam = "";
        String textParam = "";

        for (String param : params) {
            if (param.startsWith("intParam=")) {
                intParam = param.split("=")[1];
            } else if (param.startsWith("doubleParam=")) {
                doubleParam = param.split("=")[1];
            } else if (param.startsWith("textParameter=")) {
                textParam = param.split("=")[1];
            }
        }

        // Создаем объект SimpleUrl
        SimpleUrl url = new SimpleUrl();
        url.setProtocol(protocol);
        url.setAddress(address);
        url.setDomainZone(domainZone);
        url.setSiteName(siteName);
        url.setWebpageName(webpageName);
        url.setWebpageExtension(webpageExtension);
        url.setIntParam(intParam);
        url.setDoubleParam(doubleParam);
        url.setTextParam(textParam);

        // Выводим информацию об URL
        System.out.println(url);
    }
}

//todo create class SimpleUrl()
// SimpleUrl url= new SimpleUrl();
// url.setAddress(address);
// url.setProtocol(protocol)
// System.out.println(url);
class SimpleUrl {
    private String protocol;
    private String address;
    private String domainZone;
    private String siteName;
    private String webpageName;
    private String webpageExtension;
    private String intParam;
    private String doubleParam;
    private String textParam;

    // Геттеры и сеттеры для каждого поля
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDomainZone() {
        return domainZone;
    }

    public void setDomainZone(String domainZone) {
        this.domainZone = domainZone;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getWebpageName() {
        return webpageName;
    }

    public void setWebpageName(String webpageName) {
        this.webpageName = webpageName;
    }

    public String getWebpageExtension() {
        return webpageExtension;
    }

    public void setWebpageExtension(String webpageExtension) {
        this.webpageExtension = webpageExtension;
    }

    public String getIntParam() {
        return intParam;
    }

    public void setIntParam(String intParam) {
        this.intParam = intParam;
    }

    public String getDoubleParam() {
        return doubleParam;
    }

    public void setDoubleParam(String doubleParam) {
        this.doubleParam = doubleParam;
    }

    public String getTextParam() {
        return textParam;
    }

    public void setTextParam(String textParam) {
        this.textParam = textParam;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return "SimpleUrl {" +
                "protocol='" + protocol + '\'' +
                ", address='" + address + '\'' +
                ", domainZone='" + domainZone + '\'' +
                ", siteName='" + siteName + '\'' +
                ", webpageName='" + webpageName + '\'' +
                ", webpageExtension='" + webpageExtension + '\'' +
                ", intParam='" + intParam + '\'' +
                ", doubleParam='" + doubleParam + '\'' +
                ", textParam='" + textParam + '\'' +
                '}';
    }
}