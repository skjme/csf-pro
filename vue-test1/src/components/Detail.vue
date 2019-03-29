<template>

    <div> 
        <H1>Detail</H1>
        User {{ $route.params.id }}
    </div>
</template>

<script>
import { log } from 'util';
export default {
    name:'Detail',
    watch: {
    '$route' (to, from) {
      // react to route changes...
      log(to)
      log(from)
    }
  }
}
</script>

<style>

</style>

