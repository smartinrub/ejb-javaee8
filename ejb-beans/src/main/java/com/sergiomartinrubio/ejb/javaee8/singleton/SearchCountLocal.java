package com.sergiomartinrubio.ejb.javaee8.singleton;

import javax.ejb.Local;

@Local
public interface SearchCountLocal {
    void incrementSearchCount();

    int getSearchCount();

    void resetCounter();
}
