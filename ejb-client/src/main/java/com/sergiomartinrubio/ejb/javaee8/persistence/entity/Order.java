//package com.sergiomartinrubio.ejb.javaee8.persistence.entity;
//
//import javax.persistence.*;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//@Table(name = "ORDER")
//public class Order {
//
//    @Id
//    @GeneratedValue
//    @Column(name = "id")
//    private Integer orderId;
//
//    @ManyToOne
//    @JoinColumn(referencedColumnName = "customer_id")
//    private Customer customer;
//
//    @ManyToMany(mappedBy = "orders")
//    @JoinTable(joinColumns = {@JoinColumn(referencedColumnName = "ID")},
//            inverseJoinColumns = {@JoinColumn(referencedColumnName = "ID")})
//    private List<Product> products;
//
//    public Integer getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(Integer orderId) {
//        this.orderId = orderId;
//    }
//
//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Order order = (Order) o;
//        return Objects.equals(orderId, order.orderId) &&
//                Objects.equals(products, order.products);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(orderId, products);
//    }
//
//    @Override
//    public String toString() {
//        return "Order{" +
//                "orderId=" + orderId +
//                ", products=" + products +
//                '}';
//    }
//}
