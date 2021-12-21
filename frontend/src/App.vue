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
          href="/shop"
          text
        >
          쇼핑몰
          {{ link }}
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
                <v-list-item
                  v-for="item in items"
                  :key="item"
                  link
                  @click="addPet(item)"
                >
                  <v-list-item-content>
                    <v-list-item-title>
                      {{ item }}
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

              <Pet @change="updatePet(pet)" :is="pets[index].type" v-model="pets[index]" v-for="(pet, index) in pets" :key="index"></Pet>
                          
              
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>

import Cat from './components/Cat' 
import Dog from './components/Dog'  
import Pet from './components/Pet'  
// 컴포넌트 Cat, Dog, Pet을 import
const axios = require('axios').default;
// axios 라이브러리를 사용가능하게 설정
export default {   
  name: 'App',
  // 이름 설정
  components: {
    Cat, Dog,
    Pet
  },
  // 사용할 컴포넌트 설정
  data: () => ({

      items: [
        '강아지',
        '고양이'
      ],
      pets: [

      ]
  }),
  // UI에 표시된 버튼에 link와 item을 연결하기 위해 데이터 설정
  created(){
    this.init();
  },
  // 뒤에 async로 걸려있는 init 메서드를 실행하기 위한 메서드
  methods:{

    async init(){
      const response = await axios.get("/cats");
      
      this.pets = response.data._embedded.cats;
    },
    // cats에 저장된 값을 불러옴
    addPet(item){

      if(item == "강아지"){
        this.pets.push({
          type: 'Dog',
          name: '강아지',
          energy: 2, appearance: 5
      // item이 강아지일 경우 갖는 데이터 값 설정  
        });
      }else

      if(item == "고양이"){
        this.pets.push({
          type: 'Cat',
          name: '고양이',
          energy: 2, appearance: 10
      // item이 고양이일 경우 갖는 데이터 값 설정
        });
      }
       
        axios.request({ 
          method: 'POST', 
          url: `/cats`, 
          headers: {'Content-Type': 'application/json'}, 
          data: this.pets[this.pets.length - 1]
        });
      // url /cats 아래로 RESTful API 메서드 POST를 통해 해당 pet의 데이터 전달
    },

    updatePet(pet){

        axios.request({ 
          method: 'PATCH', 
          url: new URL(pet._links.self.href).pathname, 
          headers: {'Content-Type': 'application/json'}, 
          data: pet
        });
    }   // // RESTful API 메서드 PATCH로 해당 링크에서 pathname만을 가져와 데이터 값을 pet에 반영

  }
};
</script>
