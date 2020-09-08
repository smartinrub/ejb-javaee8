//package com.sergiomartinrubio.ejb.javaee8.persistence.entity;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Table(name = "ADDRESS")
//public class Address {
//
//    @Id
//    @GeneratedValue
//    @Column(name = "id")
//    private Integer addressId;
//
//    private Integer zipCode;
//
//    private String city;
//
//    // fetch strategy is eager by default
//    @OneToOne(
//            mappedBy = "address",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    private Customer customer;
//
//    public Integer getAddressId() {
//        return addressId;
//    }
//
//    public void setAddressId(Integer addressId) {
//        this.addressId = addressId;
//    }
//
//    public Integer getZipCode() {
//        return zipCode;
//    }
//
//    public void setZipCode(Integer zipCode) {
//        this.zipCode = zipCode;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Address address = (Address) o;
//        return Objects.equals(addressId, address.addressId) &&
//                Objects.equals(zipCode, address.zipCode) &&
//                Objects.equals(city, address.city) &&
//                Objects.equals(customer, address.customer);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(addressId, zipCode, city, customer);
//    }
//
//    @Override
//    public String toString() {
//        return "Address{" +
//                "addressId=" + addressId +
//                ", zipCode=" + zipCode +
//                ", city='" + city + '\'' +
//                ", customer=" + customer +
//                '}';
//    }
//}
