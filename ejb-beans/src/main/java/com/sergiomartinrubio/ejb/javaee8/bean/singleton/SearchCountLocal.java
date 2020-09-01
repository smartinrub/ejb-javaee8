package com.sergiomartinrubio.ejb.javaee8.bean.singleton;

import javax.ejb.Local;

@Local
public interface SearchCountLocal {
    void incrementSearchCount();

    int getSearchCount();

    void resetCount();
}
