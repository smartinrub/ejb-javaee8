package com.sergiomartinrubio.ejb.javaee8.singleton;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class SearchCountBean implements SearchCountLocal, SearchCount {

    private static final Logger LOGGER = Logger.getLogger(SearchCountBean.class.getName());

    private int searchCount;

    @Lock(LockType.WRITE)
    public void incrementSearchCount() {
        searchCount++;
    }

    @Lock(LockType.READ)
    public int getSearchCount() {
        return searchCount;
    }

    public void resetCounter() {
        searchCount = 0;
    }

    @PostConstruct
    public void applicationStartup() {
        LOGGER.log(Level.INFO, "From applicationStartup method.");
        resetCounter();
    }

    @PreDestroy
    public void applicationShutdown() {
        LOGGER.log(Level.INFO, "From applicationShutdown method.");
    }
}
