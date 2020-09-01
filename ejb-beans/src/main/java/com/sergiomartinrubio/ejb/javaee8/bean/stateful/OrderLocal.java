package com.sergiomartinrubio.ejb.javaee8.bean.stateful;

import javax.ejb.Local;
import java.util.ArrayList;
import java.util.List;

@Local
public interface OrderLocal {
    void addItem(String item);

    void removeItem(String item);

    void setItems(ArrayList<String> items);

    List<String> getItems();
}
