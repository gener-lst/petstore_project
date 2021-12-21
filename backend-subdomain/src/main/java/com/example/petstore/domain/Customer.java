package com.example.petstore.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    String id;
    // 문자열 변수 id에 어노테이션을 통해 기본키 속성 부여
    @Embedded
    Address address;
    // 어노테이션을 통해 내장 변수로 address 선언
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    // id의 getter와 setter 설정
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    // address의 getter와 setter 설정
}

