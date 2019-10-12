package com.epam.spring.example;

import java.util.LinkedList;
import java.util.List;

public class CacheFileLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    CacheFileLogger(String filename, int cacheSize) {
        super(filename);
        this.cache = new LinkedList<>();
        this.cacheSize = cacheSize;
    }

    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            for (Event eventToWrite : cache) {
                super.logEvent(eventToWrite);
            }
            cache.clear();
        }
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            for (Event eventToWrite : cache) {
                super.logEvent(eventToWrite);
            }
            cache.clear();
        }
    }
}
