package com.sergiomartinrubio.ejb.javaee8;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface SearchFacade {

    List transmissionSearch(String transmissionType);
}
