<template>
  <!--  <img alt="Vue logo" src="./assets/logo.png">-->
  <!--  <HelloWorld msg="Welcome to Your Vue.js App"/>-->

  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <router-link class="navbar-brand" to="/">bezKoder</router-link>
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link class="nav-link" to="/tutorials">Tutorials</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/add">Add</router-link>
        </li>
      </div>
    </nav>
    <div class="container mt-3">
      <router-view/>
    </div>
  </div>

</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'

// export default {
//   name: 'App',
//   components: {
//     HelloWorld
//   }
// }
export default {
  name: "app"
};
</script>

<style>
/*#app {*/
/*  font-family: Avenir, Helvetica, Arial, sans-serif;*/
/*  -webkit-font-smoothing: antialiased;*/
/*  -moz-osx-font-smoothing: grayscale;*/
/*  text-align: center;*/
/*  color: #2c3e50;*/
/*  margin-top: 60px;*/
/*}*/
</style>
