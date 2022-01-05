<template>
	<view>
		<text>call cloud function</text>
		<button @click="sayHello()">sayHello</button>
		<button @click="trashClassify()">trashClassify</button>
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
			},
			trashClassify:function(){
				uniCloud.callFunction({
					name:'TrashClassify',
					data:{
						keyword:'香蕉'
					}
				}).then(res => {
					console.log(res)
				});
			}
		}
	}
</script>

<style>

</style>
