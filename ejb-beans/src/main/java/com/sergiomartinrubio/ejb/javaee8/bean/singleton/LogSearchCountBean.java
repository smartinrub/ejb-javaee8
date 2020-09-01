package com.sergiomartinrubio.ejb.javaee8.bean.singleton;

import javax.ejb.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Startup
@DependsOn("SearchCountBean")
public class LogSearchCountBean {

    private static final Logger LOGGER = Logger.getLogger(LogSearchCountBean.class.getName());

    @EJB
    private SearchCountLocal searchCount;

    // Logs search count every 10 seconds
    @Schedule(hour = "*", minute = "*", second = "*/10")
    public void logSearchCount(Timer timer) {
        String timerInfo = (String) timer.getInfo();
        LOGGER.log(Level.INFO, "Search count: " + searchCount.getSearchCount() + " - " + timerInfo);
    }
}
