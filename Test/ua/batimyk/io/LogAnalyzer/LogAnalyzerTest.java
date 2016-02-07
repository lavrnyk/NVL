package ua.batimyk.io.LogAnalyzer;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by N on 02/07/16.
 * NVL
 */
public class LogAnalyzerTest {

    @Test
    public void testScanLog() throws Exception {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        String sTimeFrom = "12/Mar/2004:13:25:45 -0800";
        String sTimeTo = "12/Mar/2004:13:25:45 -0800";

        LocalDateTime timeFrom = LocalDateTime.parse(sTimeFrom, LogToken.formatter);
        LocalDateTime timeTo = LocalDateTime.parse(sTimeTo, LogToken.formatter);

        Collection<LogToken> logTokens = logAnalyzer.scanLog("apache-samples/access_log/access_log", timeFrom, timeTo);
        assertEquals("2004-03-12T13:25:45 GET GET /SpamAssassin.html HTTP/1.1", logTokens.iterator().next().toString());

        sTimeFrom = "12/Mar/2004:13:25:45 -0800";
        sTimeTo = "12/Mar/2004:13:25:44 -0800";

        timeFrom = LocalDateTime.parse(sTimeFrom, LogToken.formatter);
        timeTo = LocalDateTime.parse(sTimeTo, LogToken.formatter);
        logTokens = logAnalyzer.scanLog("apache-samples/access_log/access_log", timeFrom, timeTo);
        assertEquals(0, logTokens.size());

    }
}