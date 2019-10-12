package com.epam.spring.example;

import java.util.List;

public class CombinedEventLogger implements EventLogger {
    List<EventLogger> list;

    public CombinedEventLogger(List<EventLogger> list) {
        this.list = list;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger logger : list) {
            logger.logEvent(event);
        }
    }
}
