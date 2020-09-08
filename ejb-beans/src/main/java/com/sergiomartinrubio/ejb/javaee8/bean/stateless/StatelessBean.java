package com.sergiomartinrubio.ejb.javaee8.bean.stateless;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class StatelessBean implements StatelessRemote, StatelessLocal {

    private static final Logger LOGGER = Logger.getLogger(StatelessBean.class.getName());

    private List<String> words = new ArrayList<>();


    @PostConstruct
    public void postConstruct() {
        LOGGER.log(Level.INFO, "PostConstruct.");
        words.add("House");
        words.add("Car");
        words.add("Table");
        words.add("Chair");
        words.add("Computer");
        words.add("TV");
    }

    @PreDestroy
    public void preDestroy() {
        LOGGER.log(Level.INFO, "PreDestroy.");
    }

    @Override
    public boolean isFound(String name) {
        return words.contains(name);
    }

    @AroundInvoke
    public Object logMethodInvocationTime(InvocationContext ctx) throws Exception {
        long startTime = System.currentTimeMillis();
        LOGGER.log(Level.INFO, "Running method " + ctx.getMethod());

        try {
            return ctx.proceed();
        } finally {
            long totalTime = System.currentTimeMillis() - startTime;
            LOGGER.log(Level.INFO, "Method" + ctx.getMethod() + " takes " + totalTime + "ms to run!");
        }
    }

}
