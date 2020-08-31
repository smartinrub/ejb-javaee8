package com.sergiomartinrubio.ejb.javaee8.stateful;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class OrderBean implements Order, OrderLocal {

    public List<String> orderItems;

    @PostConstruct
    public void postConstruct() {
        orderItems = new ArrayList<>();
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Saved items into database");
    }

    @Remove
    public void remove() {
        System.out.println("From stopSession method with @Remove annotation");
    }

    @Override
    public void addItem(String item) {
        orderItems.add(item);
    }

    @Override
    public void removeItem(String item) {
        orderItems.remove(item);
    }

    @Override
    public void setItems(ArrayList<String> items) {
        this.orderItems = items;
    }

    @Override
    public List<String> getItems() {
        return orderItems;
    }

}
