package com.sergiomartinrubio.ejb.javaee8.bean.stateless;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class ProductSearchBean implements ProductSearch, ProductSearchLocal {

    private static final Logger LOGGER = Logger.getLogger(ProductSearchBean.class.getName());

    private final Map<String, String> productsByCountry = new HashMap<>();

    @PostConstruct
    public void postConstruct() {
        productsByCountry.put("milk", "United Kingdom");
        productsByCountry.put("yogurt", "United Kingdom");
        productsByCountry.put("cheese", "The Netherlands");
        productsByCountry.put("eggs", "United Kingdom");
        productsByCountry.put("broccoli", "France");
        productsByCountry.put("tomatoes", "Spain");
        productsByCountry.put("onion", "Spain");
        productsByCountry.put("garlic", "Spain");
    }

    @PreDestroy
    public void preDestroy() {
        productsByCountry.clear();
    }

    @Override
    public List<String> search(String type) {
        List<String> products = new ArrayList<>();

        if ("diary".equals(type)) {
            products.add("milk");
            products.add("yogurt");
            products.add("cheese");
            products.add("eggs");
        } else if ("vegetables".equals(type)) {
            products.add("broccoli");
            products.add("tomatoes");
            products.add("onion");
            products.add("garlic");
        }

        return products;
    }

    @AroundInvoke
    public Object logMethodInvocationTime(InvocationContext ctx) throws Exception {
        long startTime = System.currentTimeMillis();
        LOGGER.log(Level.INFO, "Running method " + ctx.getMethod());

        try {
            return ctx.proceed();
        } finally {
            long totalTime = System.currentTimeMillis() - startTime;
            LOGGER.log(Level.INFO, "Method" + ctx.getMethod() + " takes " + totalTime + "ms to run!");
        }
    }

}
