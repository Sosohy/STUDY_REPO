<script setup>
import { RouterLink, RouterView } from 'vue-router';
</script>

<!-- 
  npm install vue-router@next
 -->

<template>
  <header>
    <h1>라우터 사용하기</h1>
    <hr>
    <div class="wrapper">
      <h2>basic router</h2>
      <nav>
        <RouterLink to="/">HOME</RouterLink>
        <RouterLink to="/pathvariable">pathVariable</RouterLink>
      </nav>
    </div>
  </header>

  <main>
    <RouterView />
  </main>
</template>



<style scoped>
nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
  font-size: 30px;
}

a {
  margin-left: 10px;
}

.active {
  color: red;
}

main {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

header {
  text-align: center;
}
</style>