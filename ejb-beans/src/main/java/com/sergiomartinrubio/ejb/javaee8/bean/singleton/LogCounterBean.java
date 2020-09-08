package com.sergiomartinrubio.ejb.javaee8.bean.singleton;

import javax.ejb.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Startup
@DependsOn("SingletonBean")
public class LogCounterBean {

    private static final Logger LOGGER = Logger.getLogger(LogCounterBean.class.getName());

    @EJB
    private SingletonLocal singletonLocal;

    // Logs search count every 10 seconds
    @Schedule(hour = "*", minute = "*", second = "*/10")
    public void logCounter(Timer timer) {
        String timerInfo = (String) timer.getInfo();
        LOGGER.log(Level.INFO, "Counter: " + singletonLocal.getCounter() + " - " + timerInfo);
    }
}
