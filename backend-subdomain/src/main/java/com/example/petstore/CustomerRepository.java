package com.example.petstore;

import com.example.petstore.domain.*;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String>{
// Customer 클래스와 string 타입으로 지정된 crudrepository를 상속받는 인터페이스 CustomerRepository 생성 
}