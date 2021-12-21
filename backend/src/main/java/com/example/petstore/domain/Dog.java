package com.example.petstore.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dog")
public class Dog extends Pet {
// pet을 상속하는 entity 클래스 Dog 생성
    @Override
    public void eat() {

        setEnergy(getEnergy() + 1);
    }
    // pet 클래스에서 eat 메서드를 오버라이드하여 실행되었을 때, energy가 1만 증가하도록 설정

    @Override
    public void sleep() {
        super.sleep();

        setAppearance(getAppearance() + 1);
    // pet 클래스에서 sleep 메서드를 오버라이드하고 super.sleep() 코드를 통해 실행되었을 때, 기존 sleep 메서드의 기능을 실행하고 추가로 appearance도 1 증가하도록 설정
    }
}
