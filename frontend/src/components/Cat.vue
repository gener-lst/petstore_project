<template>

    <Pet v-model="value">

      <template v-slot:buttons>
        <v-btn  outlined
        rounded
        text @click="groom">그루밍</v-btn>
      </template>

    </Pet>

</template>

<script>

  const axios = require('axios').default;
  // axios 라이브러리를 사용가능하게 설정
  import Pet from './Pet'
  // 컴포넌트 Pet을 import
  export default {
    name: 'Cat',
    // 이름 설정
    mixins: [Pet],
    // Pet이 가진 기능들을 해당 컴포넌트와 혼합시켜 사용 가능
    components:{
      Pet
    },
    // 사용할 컴포넌트로 Pet 설정
    
    methods:{

      async groom(){    
        await axios.request({ 
          method: 'PUT', 
          url: new URL(this.value._links.groom.href).pathname, 
          headers: {'Content-Type': 'application/json'}
        });
      // RESTful API 메서드 PUT으로 해당 개체의 groom에 대한 링크에서 pathname만을 가져와 전달
        this.refresh();
      // Pet 컴포넌트의 메서드인 refresh로 새로고침 기능
      }
    }
  }
</script>
