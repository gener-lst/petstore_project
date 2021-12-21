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
        <v-list-item-title class="text-h5 mb-1" v-if="editMode">
          <v-text-field v-model="value.name"></v-text-field>
        </v-list-item-title>
        <v-list-item-title class="text-h5 mb-1" @click="toggleEditMode" v-else>
          {{value.name}}
        </v-list-item-title>
        <v-list-item-subtitle @click="toggleEditMode">에너지는 {{value.energy}}이고 외모지수는 {{value.appearance}}입니다.</v-list-item-subtitle>
      </v-list-item-content>

      <v-list-item-avatar
        tile
        size="80"
        color="grey"
      ></v-list-item-avatar>
    </v-list-item>

    <v-card-actions>
      <v-btn
        outlined
        rounded
        text

        @click="eat"
      >
        먹이주기
      </v-btn>
      <v-btn
        outlined
        rounded
        text

        @click="sleep"
      >
        잠자기
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
    methods:{

      async eat(){
        await axios.request({ 
          method: 'PUT', 
          url: new URL(this.value._links.feed.href).pathname, 
          headers: {'Content-Type': 'application/json'}
        });
        // RESTful API 메서드 PUT으로 해당 개체의 feed에 대한 링크에서 pathname만을 가져와 전달
        this.refresh();
        // 메서드인 refresh로 새로고침 기능
      },

      async sleep(){
        await axios.request({ 
          method: 'PUT', 
          url: new URL(this.value._links.sleep.href).pathname, 
          headers: {'Content-Type': 'application/json'}
        });
        // RESTful API 메서드 PUT으로 해당 개체의 sleep에 대한 링크에서 pathname만을 가져와 전달
        this.refresh();
        // 메서드인 refresh로 새로고침 기능
      },

      async refresh(){
        var response = await axios.get(new URL(this.value._links.self.href).pathname);

        if(response){
          this.value = response.data;
          this.$emit("input", this.value);
        }
        // 해당 hateos 링크의 pathname만 url로 받아오는 response를 설정하고 반응이 있을 경우, 해당 링크의 값을 데이터로 반영함
      },

      toggleEditMode(){
        this.editMode = !this.editMode;

        this.$emit("change", this.value);
      } // UI에 표시된 텍스트값(이름)을 바꿀 수 있도록 하는 모드 전환 기능
    }
  }
</script>
