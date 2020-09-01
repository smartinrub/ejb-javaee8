package com.sergiomartinrubio.ejb.javaee8.bean.stateless;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductSearchLocal {
    List<String> search(String type);
}
