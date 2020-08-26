package com.sergiomartinrubio.ejb.javaee8;

import java.util.List;
import javax.ejb.Local;

@Local
public interface SearchFacadeLocal {

    List<String> transmissionSearch(String transmissionType);
}
