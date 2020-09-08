package com.sergiomartinrubio.ejb.javaee8.bean.stateful;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface StatefulRemote {
    void addNumber(Integer number);

    void removeNumber(Integer number);

    List<Integer> getNumbers();
}
