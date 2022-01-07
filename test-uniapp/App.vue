<script>
	
	import {
		mapMutations
	} from 'vuex'
	
	export default {
		onLaunch: function() {
			console.log('App Launch')
		},
		onShow: function() {
			console.log('App Show')
		},
		onHide: function() {
			console.log('App Hide')
		}
	}
</script>

<style>
	/*每个页面公共css */
	/* uni.css - 通用组件、模板样式库，可以当作一套ui库应用 */
	 /* @import './common/uni.css'; */
	
	page {
	    padding-top: 0.1px;
	    background-color: #ffffff;
	}
	
	image {
	    display: block;
	}

	.clearfix::after {
	    visibility: hidden;
	    display: block;
	    font-size: 0;
	    content: " ";
	    clear: both;
	    height: 0;
	}
	
	.ellipsis {
	    overflow: hidden;
	    text-overflow: ellipsis;
	    white-space: nowrap;
	}
</style>
