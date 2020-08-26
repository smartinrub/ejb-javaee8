package com.sergiomartinrubio.ejb.javaee8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@Stateless(name = "SearchFacade")
public class SearchFacadeBean implements SearchFacade, SearchFacadeLocal {

    private final Map<String, String> manufacturersByCountry = new HashMap<>();

    @PostConstruct
    public void initializeManufacturersByCountry() {
        manufacturersByCountry.put("Spain", "Seat");
        manufacturersByCountry.put("Renault", "France");
        manufacturersByCountry.put("Peugeot", "France");
        manufacturersByCountry.put("Citroen", "France");
    }

    @PreDestroy
    public void destoryManufacturerByCountry() {
        manufacturersByCountry.clear();
    }

    @Override
    public List<String> transmissionSearch(String manufacturer) {
        List<String> models = new ArrayList<>();

        if ("SEAT".equals(manufacturer)) {
            models.add("Leon");
            models.add("Ibiza");
            models.add("Toledo");
            models.add("Cordoba");
        } else if ("RENAULT".equals(manufacturer)) {
            models.add("Clio");
            models.add("Megane");
            models.add("Scenic");
            models.add("Laguna");
        }

        return models;
    }

    @AroundInvoke
    public Object timerLog(InvocationContext ctx) throws Exception {
        String beanClassName = ctx.getClass().getName();
        String businessMethodName = ctx.getMethod().getName();
        String target = beanClassName + "." + businessMethodName;
        long startTime = System.currentTimeMillis();
        System.out.println("Invoking " + target);

        try {
            return ctx.proceed();
        } finally {
            System.out.println("Existing " + target);
            long totalTime = System.currentTimeMillis() - startTime;
            System.out.println("Business method " + businessMethodName + " in "
                    + beanClassName + " takes " + totalTime + "ms to execute");
        }
    }

}
