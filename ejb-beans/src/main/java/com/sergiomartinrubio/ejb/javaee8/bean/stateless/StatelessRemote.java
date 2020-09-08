package com.sergiomartinrubio.ejb.javaee8.bean.stateless;

import javax.ejb.Remote;

@Remote
public interface StatelessRemote {
    boolean isFound(String type);
}
