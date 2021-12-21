<template>

  <v-card
    class="mx-auto"
    max-width="344"
    outlined
  >
    <v-list-item three-line>
      <v-list-item-content>
        <div class="text-overline mb-4">
          {{value.type}}
        </div>
        <v-list-item-title class="text-h5 mb-1">
          {{value.name}}
        </v-list-item-title>
        <v-list-item-subtitle>에너지는 {{value.energy}}이고 외모지수는 {{value.appearance}}입니다.</v-list-item-subtitle>
      </v-list-item-content>

      <v-list-item-avatar
        tile
        size="80"
        color="grey"
      ></v-list-item-avatar>
    </v-list-item>

    <v-card-actions>

      <v-chip v-if="inTheCart">카트에 담겼습니다</v-chip>
      <v-btn
        v-else
        outlined
        rounded
        text

        @click="addToCart"
      >
        카트담기
      </v-btn>

      <slot name="buttons"></slot>
      
    </v-card-actions>
  </v-card>


</template>

<script>

  const axios = require('axios').default;
  // axios 라이브러리를 사용가능하게 설정
  export default {     
    name: 'Pet',
  // 이름 설정
    props: {
      value: Object,
      editMode: Boolean
    },
  // property(속성) 설정
    data: () => {
      return {
        inTheCart: false
      }
    },
  // 카드에 담겼는지 여부를 나타내기 위한 inTheCart의 기본값을 false로 설정
    methods:{

      async addToCart(){
      // 펫을 카트에 담기 위한 메서드 선언. 예약어인 async를 걸어둠
        var cartItem = {
          pet: this.value._links.self.href,
          customer: "http://localhost:8088/customers/help@uengine.org",
          payment: {
            method: "신용카드",
            status: "결제완료"
          }
        }
      // var 타입 자료인 cartItem 설정. 펫의 정보는 선택된 개체의 hateos 링크로 불러옴. 구매자와 결제정보는 임의로 설정
        await axios.request({ 
          method: 'POST', 
          url: "/cartItems", 
          headers: {'Content-Type': 'application/json'},
          data: cartItem
        });
      // 값이 반환될 때 실행되게 하기 위해 await 사용. 이 경우에 지정된 url으로 RESTful API 메서드 POST를 통해 cartItem의 데이터 전달
        this.inTheCart = true
      // 해당 개체가 카트에 담겼음을 버튼 상으로 알리기 위해 inTheCart를 true로 바꿈
      }
    }
  }
</script>
