<template>
	<view>
		<button @click="sayHello()">class cloud function</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			sayHello:function(){
				uniCloud.callFunction({
					// .sayHello("shu")
					name: 'sayHello',
					data: {
						name: 'shu'
					}
				})
			}
		}
	}
</script>

<style>

</style>
