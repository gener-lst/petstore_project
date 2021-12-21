package com.example.petstore;


import com.example.petstore.domain.Pet;

import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
// Pet 클래스와 Long 타입으로 지정된 crudrepository를 상속받는 인터페이스 PetRepository 생성 
}
