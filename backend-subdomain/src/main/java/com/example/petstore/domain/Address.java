package com.example.petstore.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    
    String detail;
    String zipcode;
    // 문자열 변수 detail과 zipcode 선언
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    // detail에 대한 getter와 setter 설정
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    // zipcode에 대한 getter와 setter 설정
}
