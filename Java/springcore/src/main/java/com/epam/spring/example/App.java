package com.epam.spring.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Map;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public void logEvent(EventType type, String msg) {
        Event event = new Event(msg, new Date(), new DateFormat() {
            @Override
            public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
                return toAppendTo.append(date).append(" Formatted");
            }

            @Override
            public Date parse(String source, ParsePosition pos) {
                return null;
            }
        });
        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = new CacheFileLogger("file.txt", 10);
        }
        logger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("SpringXML.xml");
        App app = (App) ctx.getBean("app");
        app.logEvent(null, "CacheFileLogger-Called");
        app.logEvent(EventType.INFO, "ConsoleEventLogger-Called");
        app.logEvent(EventType.ERROR, "CONSOLE&CACHE-CALLED");
        ctx.close();
    }
}
