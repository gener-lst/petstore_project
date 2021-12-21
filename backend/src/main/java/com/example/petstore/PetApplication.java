package com.example.petstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import com.example.petstore.domain.Groomable;
import com.example.petstore.domain.Pet;
import com.example.petstore.RepositorySearchesProcessor;

import com.h2.examples.H2FileDatabaseExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableAspectJAutoProxy
// springboot와 restful API, aspectJ의 기능을 사용하기 위한 API
public class PetApplication {
	public static void main(String[] args) {
		SpringApplication.run(PetApplication.class, args);
	}
	// springboot를 실행하기 위한 코드
	@Autowired
	PetRepository petRepository;
	// petRepository를 Autowired
	@RequestMapping(method = RequestMethod.PUT, path="pets/{petID}/feed")
	public String feedPet(@PathVariable(value = "petID") Long petID){
		Pet thePet = petRepository.findById(petID).get();
	// requestmapping 어노테이션을 통해 PUT 메서드와 path를 지정. 메서드는 해당 path에서 호출이 오면 실행되도록 선언.
	// 해당 메서드는 어노테이션 PathVariable petID로 매핑한 펫을 전달한다.
		thePet.eat();

		petRepository.save(thePet);

		return "밥을 줍니다.";
	// 이후 해당 펫에 대해 eat 메서드를 실행하고 petRepository에 해당 결과값을 저장한 후 메세지를 return한다.
	}

	@RequestMapping(method = RequestMethod.PUT, path="pets/{petID}/sleep")
	public String sleepPet(@PathVariable(value = "petID") Long petID){
		Pet thePet = petRepository.findById(petID).get();
	// requestmapping 어노테이션을 통해 PUT 메서드와 path를 지정. 메서드는 해당 path에서 호출이 오면 실행되도록 선언.
	// 해당 메서드는 어노테이션 PathVariable petID로 매핑한 펫을 전달한다.
		thePet.sleep();

		petRepository.save(thePet);

		return "재웠습니다.";
	// 이후 해당 펫에 대해 sleep 메서드를 실행하고 petRepository에 해당 결과값을 저장한 후 메세지를 return한다.
	}

	@RequestMapping(method = RequestMethod.PUT, path="pets/{petID}/groom")
	public String groomPet(@PathVariable(value = "petID") Long petID){
		Pet thePet = petRepository.findById(petID).get();
	// requestmapping 어노테이션을 통해 PUT 메서드와 path를 지정. 메서드는 해당 path에서 호출이 오면 실행되도록 선언.
	// 해당 메서드는 어노테이션 PathVariable petID로 매핑한 펫을 전달한다.
		if(thePet instanceof Groomable){
			String message = ((Groomable) thePet).grooming();
			petRepository.save(thePet);
			return message;
		}
			
		return "그루밍이 불가능한 Pet 입니다.";
	// 이후 해당 펫이 groomable한 펫일 경우, grooming 메서드의 실행값을 문자열 변수 message에 저장하고 petRepository에 해당 결과값을 저장한 후 message 값을 return한다.
	// 그렇지 않을 경우, "그루밍이 불가능한 Pet 입니다."라는 메세지를 return한다. 		
	}

	@RequestMapping(method = RequestMethod.PUT, path="cats/{petID}/groom")
	public String groomCat(@PathVariable(value = "petID") Long petID){
		return groomPet(petID);
	}
	// requestmapping 어노테이션을 통해 PUT 메서드와 "cats/" 아래의 path를 지정. 해당 path에서 호출이 오면 실행되는 메서드를 선언하고 실행.
	// 해당 메서드는 어노테이션 PathVariable petID로 매핑한 펫을 전달한다. 
	@RequestMapping(method = RequestMethod.PUT, path="cats/{petID}/feed")
	public String feedCat(@PathVariable(value = "petID") Long petID){
		return feedPet(petID);
	}
	// requestmapping 어노테이션을 통해 PUT 메서드와 "cats/" 아래의 path를 지정. 해당 path에서 호출이 오면 실행되는 메서드를 선언하고 실행.
	// 해당 메서드는 어노테이션 PathVariable petID로 매핑한 펫을 전달한다. 
	@RequestMapping(method = RequestMethod.PUT, path="dogs/{petID}/feed")
	public String feedDog(@PathVariable(value = "petID") Long petID){
		return feedPet(petID);
	}
	// requestmapping 어노테이션을 통해 PUT 메서드와 "dogs/" 아래의 path를 지정. 해당 path에서 호출이 오면 실행되는 메서드를 선언하고 실행.
	// 해당 메서드는 어노테이션 PathVariable petID로 매핑한 펫을 전달한다. 
	@RequestMapping(method = RequestMethod.PUT, path="cats/{petID}/sleep")
	public String sleepCat(@PathVariable(value = "petID") Long petID){
		return sleepPet(petID);
	}
	// requestmapping 어노테이션을 통해 PUT 메서드와 "cats/" 아래의 path를 지정. 해당 path에서 호출이 오면 실행되는 메서드를 선언하고 실행.
	// 해당 메서드는 어노테이션 PathVariable petID로 매핑한 펫을 전달한다. 
	@RequestMapping(method = RequestMethod.PUT, path="dogs/{petID}/sleep")
	public String sleepDog(@PathVariable(value = "petID") Long petID){
		return sleepPet(petID);
	}
	// requestmapping 어노테이션을 통해 PUT 메서드와 "dogs/" 아래의 path를 지정. 해당 path에서 호출이 오면 실행되는 메서드를 선언하고 실행.
	// 해당 메서드는 어노테이션 PathVariable petID로 매핑한 펫을 전달한다. 
}
