<template>

  <Pet v-model="value"></Pet>
 
</template>

<script>

  import Pet from './Pet'
  // 컴포넌트 Pet을 import
  export default {
    name: 'Dog',
    // 이름 설정
    components:{
      Pet
    },
    // 사용할 컴포넌트로 Pet 설정
    mixins: [Pet],
    // Pet이 가진 기능들을 해당 컴포넌트와 혼합시켜 사용 가능

    methods:{

    }
  }
</script>
