package com.example.petstore;

import com.example.petstore.domain.Cat;

import org.springframework.data.repository.CrudRepository;

public interface CatRepository extends CrudRepository<Cat, Long>{
// Cat 클래스와 Long 타입으로 지정된 crudrepository를 상속받는 인터페이스 CatRepository 생성 
}
