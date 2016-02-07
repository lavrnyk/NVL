package ua.batimyk.io.LogAnalyzer;


import java.io.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by N on 02/04/16.
 * NVL
 */
public class LogAnalyzer {
    private String logPatternString = ".*\\[(.*)\\].*\"(.*)\"";

    public Collection<LogToken> scanLog(String path, LocalDateTime timeFrom, LocalDateTime timeTo) {

        Collection<LogToken> logToken = new LinkedList<>();
        Pattern pattern = Pattern.compile(logPatternString, Pattern.CASE_INSENSITIVE);

        String logEntry;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            while ((logEntry = in.readLine()) != null) {
                Matcher matcher = pattern.matcher(logEntry);
                if (matcher.find()) {
                    LocalDateTime time = LocalDateTime.parse(matcher.group(1), LogToken.formatter);
                    if (time.compareTo(timeFrom) >= 0 && time.compareTo(timeTo) <= 0) {
                        String message = matcher.group(2);
                        logToken.add(new LogToken(time, LogToken.HttpMethod.getMethod(message), message));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logToken;
    }

    public static void main(String[] args) {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        String sTimeFrom = "12/Mar/2004:10:25:45 -0800";
        String sTimeTo = "12/Mar/2004:13:25:45 -0800";

        LocalDateTime timeFrom = LocalDateTime.parse(sTimeFrom, LogToken.formatter);
        LocalDateTime timeTo = LocalDateTime.parse(sTimeTo, LogToken.formatter);

        Collection<LogToken> logTokens = logAnalyzer.scanLog("apache-samples/access_log/access_log", timeFrom, timeTo);
        for (LogToken logToken : logTokens) {
            System.out.println(logToken);
        }

    }
}
