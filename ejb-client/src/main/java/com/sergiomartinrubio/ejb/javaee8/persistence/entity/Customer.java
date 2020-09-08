//package com.sergiomartinrubio.ejb.javaee8.persistence.entity;
//
//import javax.persistence.*;
//import java.util.Objects;
//import java.util.Set;
//
//@Entity
//@Table(name = "CUSTOMER")
//public class Customer {
//
//    @Id
//    @GeneratedValue
//    @Column(name = "id")
//    private Integer customerId;
//
//    private String name;
//
//    // fetch strategy is eager by default
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(referencedColumnName = "address_id")
//    private Address address;
//
//    @OneToMany
//    private Set<Order> orders;
//
//    public Integer getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(Integer customerId) {
//        this.customerId = customerId;
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
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    public Set<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(Set<Order> orders) {
//        this.orders = orders;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Customer customer = (Customer) o;
//        return Objects.equals(customerId, customer.customerId) &&
//                Objects.equals(name, customer.name) &&
//                Objects.equals(address, customer.address) &&
//                Objects.equals(orders, customer.orders);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(customerId, name, address, orders);
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "customerId=" + customerId +
//                ", name='" + name + '\'' +
//                ", address=" + address +
//                ", orders=" + orders +
//                '}';
//    }
//}
