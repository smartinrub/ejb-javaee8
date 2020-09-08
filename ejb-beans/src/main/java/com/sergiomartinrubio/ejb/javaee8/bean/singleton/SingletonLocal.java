package com.sergiomartinrubio.ejb.javaee8.bean.singleton;

import javax.ejb.Local;

@Local
public interface SingletonLocal {
    void increaseCounter();

    int getCounter();

    void resetCounter();
}
