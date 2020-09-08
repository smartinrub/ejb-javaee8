package com.sergiomartinrubio.ejb.javaee8.bean.stateful;

import javax.ejb.Local;
import java.util.List;

@Local
public interface StatefulLocal {
    void addNumber(Integer number);
    void removeNumber(Integer number);
    List<Integer> getNumbers();
}
