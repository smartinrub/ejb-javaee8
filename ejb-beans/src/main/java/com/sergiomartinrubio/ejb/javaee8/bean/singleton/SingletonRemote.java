package com.sergiomartinrubio.ejb.javaee8.bean.singleton;

import javax.ejb.Remote;

@Remote
public interface SingletonRemote {
    void increaseCounter();

    int getCounter();

    void resetCounter();
}
