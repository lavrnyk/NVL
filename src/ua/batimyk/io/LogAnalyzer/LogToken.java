package ua.batimyk.io.LogAnalyzer;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by N on 02/04/16.
 * NVL
 */
public class LogToken {
    enum HttpMethod {
        GET, POST;

        public static HttpMethod getMethod(String value) {
            for (HttpMethod httpMethod : HttpMethod.values()) {
                if (value.contains(httpMethod.toString())) {
                    return httpMethod;
                }
            }
            return null;
        }
    }

    private LocalDateTime time;
    private HttpMethod method;
    private String message;

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z");

    public LogToken(LocalDateTime time, HttpMethod method, String message) {
        this.time = time;
        this.method = method;
        this.message = message;
    }

    public String toString() {
        return time + " " + method + " " + message;
    }

    public static void main(String[] args) {

        LocalDateTime time = LocalDateTime.parse("12/Mar/2004:13:25:45 -0800", LogToken.formatter);

        LogToken logToken = new LogToken(time, HttpMethod.getMethod("fsfsf"), "Message");

        System.out.println(logToken);
    }

}
