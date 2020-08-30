package com.sergiomartinrubio.ejb.javaee8.stateless;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductSearchLocal {
    List<String> search(String type);
}
