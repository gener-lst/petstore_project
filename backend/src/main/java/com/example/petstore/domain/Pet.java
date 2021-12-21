package com.example.petstore.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorColumn(
    discriminatorType = DiscriminatorType.STRING,
    name = "pet_type",
    columnDefinition = "CHAR(5)"
)
public abstract class Pet {

    @Id @GeneratedValue
    long id;
        public long getId() {
            return id;
        }
    // 자동생성의 기본키인 long 타입 변수 id 선언과 이를 위한 어노테이션
    String name; 
        public String getName() {
            return name;
        }
        public void setName(String name) {
            if(name==null) throw new IllegalArgumentException("이름은 꼭 들어가야 합니다.");
            this.name = name;
        }
    // 문자열 변수 name과 이에 대한 getter와 setter 설정
    String type;
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
    // 문자열 변수 type과 이에 대한 getter와 setter 설정
    private int energy = 0;
        public int getEnergy() {
            return energy;
        }
        protected void setEnergy(int energy) {
            if(Math.abs(this.energy - energy) < 3)
                this.energy = energy;
            else
                throw new IllegalArgumentException("Energy change is too big!");
        }
    // private한 정수형 변수 energy를 0으로 선헌하고 이에 대한 getter와 setter 설정. 
    // setter에 의해 설정되는 에너지 값이 지금 에너지 값과 3이상 차이날 경우 에러 메세지 출력.
    private int appearance;
        public int getAppearance() {
            return appearance;
        }
        protected void setAppearance(int appearance) {
            this.appearance = appearance;
        }
    // 정수형 변수 appearance와 이에 대한 getter와 setter 설정
    public void eat(){
        energy += 2;
    // 실행 시 energy가 2 증가하는 메서드 eat 선언
    }

    public void sleep(){
        energy += 1;
        appearance += 1;
    // 실행 시 energy와 appearance가 각각 1씩 증가하는 메서드 sleep 선언
    }

    @Override
    public String toString() {

        return "<a href='./"+this.getClass().getSimpleName().toLowerCase()+"'"+">"+this.getClass().getSimpleName() + "</a>";
    }// 각각 기능들에 대해 hateos 링크를 해당 기능이 포함된 url로 생성하기 위한 메서드 toString 선언
}
