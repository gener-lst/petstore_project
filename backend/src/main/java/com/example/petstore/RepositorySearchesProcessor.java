package com.example.petstore;

import com.example.petstore.domain.Cat;
import com.example.petstore.domain.Pet;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RepositorySearchesProcessor implements RepresentationModelProcessor<EntityModel<Pet>> {
// 컴포넌트로서 pet을 entitymodel로 설정하고 검색한 결과에 대해 간섭할 수 있는 기능인 RepresentationModelProcessor를 implements하는 RepositorySearchesProcessor 생성
    @Override
    public EntityModel<Pet> process(EntityModel<Pet> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/feed").withRel("feed"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/sleep").withRel("sleep"));
        // entitymodel에 대해 만들어진 결과에서 모델의 링크 뒷 부분에 "feed", "sleep"을 덧붙히도록 간섭
        if(model.getContent() instanceof Cat)
            model.add(Link.of(model.getRequiredLink("self").getHref() + "/groom").withRel("groom"));
        // 해당 모델의 펫 타입이 cat이었을 경우, 모델의 링크 뒷 부분에 "groom"을 덧붙히도록 간섭
        return model;
        // 간섭된 결과값을 return
    }   
}
