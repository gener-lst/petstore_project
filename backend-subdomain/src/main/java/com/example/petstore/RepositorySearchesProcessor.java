package com.example.petstore;

import com.example.petstore.domain.CartItem;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RepositorySearchesProcessor implements RepresentationModelProcessor<EntityModel<CartItem>> {
// 컴포넌트로서 cartItem을 entitymodel로 설정하고 검색한 결과에 대해 간섭할 수 있는 기능인 RepresentationModelProcessor를 implements하는 RepositorySearchesProcessor 생성
    @Override
    public EntityModel<CartItem> process(EntityModel<CartItem> model) {
        model.add(Link.of(model.getContent().getPet()).withRel("pet"));
    // entitymodel에 대해 만들어진 결과에서 모델의 링크 뒷 부분에 "pet"을 덧붙히도록 간섭
        return model;
    // 간섭된 결과값을 return
    }
}
