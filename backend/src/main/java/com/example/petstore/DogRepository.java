package com.example.petstore;

import com.example.petstore.domain.Dog;

import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long>{
// Dog 클래스와 Long 타입으로 지정된 crudrepository를 상속받는 인터페이스 DogRepository 생성 
}
