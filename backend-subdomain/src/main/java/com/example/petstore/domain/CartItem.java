package com.example.petstore.domain;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class CartItem {

    @Id @GeneratedValue
    Long id;
    // 자동생성의 기본키인 long 타입 변수 id 선언과 이를 위한 어노테이션
    @ManyToOne
    Customer customer;
    // 다대일로 설정된 변수 cutomer 선언
    String pet;
        public String getPet() {
            return pet;
        }
        public void setPet(String pet) {
            this.pet = pet;
        }
    // 문자열 변수 pet에 대한 getter와 setter 설정
    @Embedded
    Payment payment;
    // 어노테이션으로 내장 변수로 payment 선언
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    // id에 대한 getter와 setter 설정
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    // customer에 대한 getter와 setter 설정
    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    // payment에 대한 getter와 setter 설정
}
