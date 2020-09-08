package com.sergiomartinrubio.ejb.javaee8.bean.stateless;

import javax.ejb.Local;

@Local
public interface StatelessLocal {
    boolean isFound(String name);
}
