package com.sergiomartinrubio.ejb.javaee8.stateful;

import javax.ejb.Remote;
import java.util.ArrayList;
import java.util.List;

@Remote
public interface Order {

    void addItem(String item);

    void removeItem(String item);

    void setItems(ArrayList<String> items);

    List<String> getItems();
}
