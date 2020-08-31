package com.sergiomartinrubio.ejb.javaee8.singleton;

import javax.ejb.Remote;

@Remote
public interface SearchCount {
    void incrementSearchCount();

    int getSearchCount();

    void resetCounter();
}
