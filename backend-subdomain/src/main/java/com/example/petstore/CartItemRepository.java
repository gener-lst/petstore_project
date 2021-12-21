package com.example.petstore;

import com.example.petstore.domain.*;

import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Long>{
// CartItem 클래스와 long 타입으로 지정된 crudrepository를 상속받는 인터페이스 CartItemRepository 생성 
}