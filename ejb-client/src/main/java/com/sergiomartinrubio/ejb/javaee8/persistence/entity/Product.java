//package com.sergiomartinrubio.ejb.javaee8.persistence.entity;
//
//import javax.persistence.*;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//@Table(name = "PRODUCT")
//@NamedQueries({
//        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
//        @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
//        @NamedQuery(name = "Product.findByType", query = "SELECT p FROM Product p WHERE p.type = :type")
//})
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "id", unique = true, nullable = false)
//    private Integer productId;
//
//    @Basic(fetch = FetchType.EAGER)
//    private String name;
//
//    private String type;
//
//    @ManyToMany(mappedBy = "products")
//    private List<Order> orders;
//
//    public Integer getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Integer productId) {
//        this.productId = productId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Product product = (Product) o;
//        return Objects.equals(productId, product.productId) &&
//                Objects.equals(name, product.name) &&
//                Objects.equals(type, product.type) &&
//                Objects.equals(orders, product.orders);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(productId, name, type, orders);
//    }
//
//    @Override
//    public String toString() {
//        return "Product{" +
//                "productId=" + productId +
//                ", name='" + name + '\'' +
//                ", type='" + type + '\'' +
//                ", orders=" + orders +
//                '}';
//    }
//}
