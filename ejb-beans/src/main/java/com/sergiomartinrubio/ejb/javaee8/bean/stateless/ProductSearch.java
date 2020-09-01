package com.sergiomartinrubio.ejb.javaee8.bean.stateless;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ProductSearch {
    List<String> search(String type);
}
