package com.sergiomartinrubio.ejb.javaee8.bean.singleton;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class SearchCountBean implements SearchCount, SearchCountLocal {

    private static final Logger LOGGER = Logger.getLogger(SearchCountBean.class.getName());

    private int searchCount;

    @Override
    @Lock(LockType.WRITE)
    public void incrementSearchCount() {
        searchCount++;
    }

    @Override
    @Lock(LockType.READ)
    public int getSearchCount() {
        return searchCount;
    }

    @Override
    public void resetCount() {
        searchCount = 0;
    }

    @PostConstruct
    public void applicationStartup() {
        LOGGER.log(Level.INFO, "From applicationStartup method.");
        resetCount();
    }

    @PreDestroy
    public void applicationShutdown() {
        LOGGER.log(Level.INFO, "From applicationShutdown method.");
    }
}
