package com.sergiomartinrubio.ejb.javaee8.bean.singleton;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class SingletonBean implements SingletonRemote, SingletonLocal {

    private static final Logger LOGGER = Logger.getLogger(SingletonBean.class.getName());

    private int counter;

    @Override
    @Lock(LockType.WRITE)
    public void increaseCounter() {
        counter++;
    }

    @Override
    @Lock(LockType.READ)
    public int getCounter() {
        return counter;
    }

    @Override
    public void resetCounter() {
        counter = 0;
    }

    @PostConstruct
    public void postConstruct() {
        LOGGER.log(Level.INFO, "PostConstruct. Reset counter.");
        resetCounter();
    }

    @PreDestroy
    public void preDestroy() {
        LOGGER.log(Level.INFO, "PreDestroy.");
    }
}
