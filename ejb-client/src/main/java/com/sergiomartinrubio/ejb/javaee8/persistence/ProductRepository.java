//package com.sergiomartinrubio.ejb.javaee8.persistence;
//
//import com.sergiomartinrubio.ejb.javaee8.persistence.entity.Product;
//
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//import java.util.Optional;
//
//@Stateless
//public class ProductRepository {
//
//    @PersistenceContext(unitName = "DefaultPersistenceUnit")
//    private EntityManager entityManager;
//
//    public List<Product> findAll() {
//        return entityManager.createNamedQuery("Product.findAll", Product.class)
//                .getResultList();
//    }
//
//    public Optional<Product> findByName(String name) {
//        Product product = entityManager.createNamedQuery("Product.findByName", Product.class)
//                .setParameter("name", name)
//                .getSingleResult();
//        return product != null ? Optional.of(product) : Optional.empty();
//    }
//
//    public List<Product> findByType(String type) {
//        return entityManager.createNamedQuery("Product.findByType", Product.class)
//                .setParameter("name", type)
//                .getResultList();
//    }
//
//    public void save(Product product) {
//        entityManager.persist(product);
//    }
//
//    public void removeAll() {
//        entityManager.createQuery("DELETE FROM Product")
//                .executeUpdate();
//    }
//}
