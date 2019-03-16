<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
   
    <h3>Vue Router</h3>
    <ul>
      <!-- <li><a href="/" rel="noopener">Home</a></li> -->
      <li><router-link to="/">Home</router-link></li>
      <li><router-link to="/list">List</router-link></li>
    </ul>
    
  </div>
</template>

<script>
export default {
  name: 'Header',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
