<template>
   <v-data-table
    :headers="headers"
    :items="cartItems"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>
</template>

<script>

const axios = require('axios').default;
// axios 라이브러리를 사용가능하게 설정
export default {   
  name: 'Cart',
  // 이름 설정
  components: {},

  data: () => ({
    headers: [
      { text: '이름', value: 'petDetail.name' },
      { text: '에너지', value: 'petDetail.energy' },
      { text: '외모', value: 'petDetail.appearance' },
      { text: '결제방법', value: 'payment.method' },
      { text: '결제상태', value: 'payment.status' }, 
    ],
    // UI에 표시되는 테이블에 들어갈 구성요소와 그 값들을 설정

    cartItems: [],
    showCart: false
  }),
    // 테이블로 이루어진 cart 창을 접속시 기본적으로 보이지 않게 하기 위해 showCart를 false로 설정
  created(){
    this.init();
  },
    // 뒤에 async로 걸려있는 init 메서드를 실행하기 위한 메서드
  methods:{
    showCart(){
      this.showCart =true;
    },
    // cart 창으로 전환되기 위해 showCart를 true로 바꾸는 메서드 선언
    async init(){
      const response = await axios.get("/cartItems");
      
      this.cartItems = response.data._embedded.cartItems;

      this.cartItems.forEach(async cartItem => {
        const response = await axios.get(new URL(cartItem._links.pet.href).pathname);
        cartItem.petDetail = response.data;
      })
    // cartItem에 저장된 값을 불러오고 cart 테이블의 petDetail에 해당 되는 값에 대해 매치되는 hateos 링크 값을 cart 테이블로 불러옴
    }

  }
};
</script>
