package com.sergiomartinrubio.ejb.javaee8.bean.singleton;

import javax.ejb.Remote;

@Remote
public interface SearchCount {
    void incrementSearchCount();

    int getSearchCount();

    void resetCount();
}
