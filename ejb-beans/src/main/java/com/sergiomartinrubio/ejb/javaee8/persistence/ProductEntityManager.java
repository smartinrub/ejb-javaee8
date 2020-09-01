package com.sergiomartinrubio.ejb.javaee8.persistence;

import com.sergiomartinrubio.ejb.javaee8.persistence.entity.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductEntityManager {

    @PersistenceContext(unitName = "product-persistence-unit")
    private EntityManager entityManager;

    public void saveProduct() {
        Product product = new Product();
        product.setName("milk");
        entityManager.persist(product);
    }
}
