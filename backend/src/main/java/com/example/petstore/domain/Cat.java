package com.example.petstore.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cat")
public class Cat extends Pet implements Groomable{
// pet을 상속하고 groomable 인터페이스를 implements하는 entity 클래스 cat 생성
    public Cat() {
        setType("Cat");
    }
    // type을 cat으로 설정
     
    @Override
    public String grooming() {
        setAppearance(getAppearance() + 1);

        return "야옹, 내 집사할래?";
    }
    // implements한 메서드 grooming에 대해 실행되면 appearance가 1 증가하도록 설정
}
