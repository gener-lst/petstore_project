<template>
   <v-app id="inspire">
    <v-app-bar
      app
      color="white"
      flat
    >
      <v-container class="py-0 fill-height">
        <v-avatar
          class="mr-10"
          color="grey darken-1"
          size="32"
        ></v-avatar>

        <v-btn
          v-for="link in links"
          :key="link.href"
          :href="link.href"
          text
        >
          {{ link.title }}
        </v-btn>

        <v-spacer></v-spacer>

        <v-responsive max-width="260">
          <v-text-field
            dense
            flat
            hide-details
            rounded
            solo-inverted
          ></v-text-field>
        </v-responsive>
      </v-container>
    </v-app-bar>

    <v-main class="grey lighten-3">
      <v-container>
        <v-row>
          <v-col cols="2">
            <v-sheet rounded="lg">
              <v-list color="transparent">
                <v-list-item @click="showCart = true">
                  <v-list-item-content>
                    <v-list-item-title>
                      카트보기
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>

                <v-divider class="my-2"></v-divider>

                <v-list-item
                  link
                  color="grey lighten-4"
                >
                  <v-list-item-content>
                    <v-list-item-title>
                      Refresh
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet
              min-height="70vh"
              rounded="lg"
            >
              <Cart v-if="showCart"></Cart>

              <Pet v-else v-model="pets[index]" v-for="(pet, index) in pets" :key="index"></Pet>
                          
              
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>

import Pet from './components/Pet' 
import Cart from './components/Cart' 
// 컴포넌트 Pet과 Cart를 import
const axios = require('axios').default;
// axios 라이브러리를 사용가능하게 설정
export default {    
  name: 'App',
  // 이름 설정
  components: {
    Pet, Cart
  },
  // 사용될 컴포넌트로 Pet과 Cart를 설정
  data: () => ({
      links: [
        {title: '애완동물 등록', href:"/"}
      ],
      items: [
        '강아지',
        '고양이'
      ],
      pets: [
        
        
      ],
      showCart: false
  }),
  // UI에 표시된 버튼에 link와 item을 연결하기 위해 데이터 설정. cart 테이블을 보여주는 showCart를 기본적으로 false로 설정
  created(){
    this.init();
  },
  // 뒤에 async로 걸려있는 init 메서드를 실행하기 위한 메서드
  methods:{
    showCart(){
      this.showCart =true;
    },
    // cart 테이블이 보이도록 showCart를 true로 바꾸는 메서드 선언
    async init(){
      const response = await axios.get("/cats");
      
      this.pets = response.data._embedded.cats;
    }
  // cats에 저장된 값을 불러옴
  }
};
</script>
