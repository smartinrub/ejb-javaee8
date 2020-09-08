package com.sergiomartinrubio.ejb.javaee8.bean.stateful;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateful
public class StatefulBean implements StatefulRemote, StatefulLocal {

    private static final Logger LOGGER = Logger.getLogger(StatefulBean.class.getName());

    public List<Integer> numbers;

    @PostConstruct
    public void postConstruct() {
        LOGGER.log(Level.INFO, "PostConstruct.");
        numbers = new ArrayList<>();
    }

    @PreDestroy
    public void preDestroy() {
        LOGGER.log(Level.INFO, "PreDestroy.");
        numbers = null;
    }

    @Remove
    public void remove() {
        System.out.println("Remove.");
    }

    @Override
    public void addNumber(Integer number) {
        numbers.add(number);
    }

    @Override
    public void removeNumber(Integer number) {
        numbers.remove(number);
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }

}
