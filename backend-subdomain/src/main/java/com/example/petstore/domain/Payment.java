package com.example.petstore.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Payment {

    String method;
    String status;
    // 문자열 변수 method와 status 선언
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    // method의 getter와 setter 설정
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    // status의 getter와 setter 설정    
}
