<template>
	<!-- 添加入口 -->
	<view class="container">
	    <view class="info-layout">
	        <view @click="addBirth" class="birth-layout">
	            <view class="label">手动录入好友生日</view>
	            <image class="arrow" src="/images/arrow.png"></image>
	        </view>
	        <!-- <view catchtap="importBirth" class="birth-layout">
	            <view class="label">批量添加</view>
	            <image class="arrow" src="/images/arrow.png"></image>
	            <view class="red-point"></view>
	        </view>  -->
			 <view catchtap="importBirth" class="birth-layout">
	            <view class="label">邀请好友填写</view>
	            <image class="arrow" src="/images/arrow.png"></image>
	            <view class="red-point"></view>
	        </view>
	    </view>
	</view>

</template>

<script>
export default {
	data() {
		return {
			pageShow: true, 
		}
	},
	onLoad() {
		
	},
	methods: {
		// 进入添加表单
		addBirth:function(){
			uni.navigateTo({
				url: "../addressbook/addForm"
			});
		}
	},
}
</script>

<style>
	page {
	    background-color: #fff;
	}
	
	.container {
	    margin: 20rpx 0;
	    padding-bottom: 100rpx;
	}
	
	.info-layout {
	    display: flex;
	    align-items: center;
	    flex-flow: column nowrap;
	}
	
	.part-title {
	    width: 100%;
	    height: 80rpx;
	    line-height: 80rpx;
	    text-indent: 60rpx;
	    background: #f9f9f9;
	    font-family: PingFangSC-Regular;
	    font-size: 28rpx;
	    color: #999999;
	}
	
	.name-layout {
	    display: flex;
	    width: 630rpx;
	    height: 110rpx;
	    align-items: center;
	    justify-content: space-between;
	    border-bottom: 1rpx solid #eee;
	}
	
	.label {
	    flex: 1;
	    margin-right: 10rpx;
	    min-width: 160rpx;
	    font-size: 32rpx;
	}
	
	.name-label {
	    margin-right: 20rpx;
	    line-height: 110rpx;
	    color: #333;
	    font-size: 32rpx;
	}
	
	.rec-avatar {
	    margin-left: -40rpx;
	    width: 80rpx;
	    height: 80rpx;
	    border-radius: 50%;
	    background-repeat: no-repeat;
	    background-size: contain;
	}
	
	.arrow {
	    width: 12rpx;
	    height: 12rpx;
	}
	
	.birth-layout {
	    position: relative;
	    display: flex;
	    width: 630rpx;
	    height: 110rpx;
	    align-items: center;
	    justify-content: space-between;
	    border-bottom: 1rpx solid #eee;
	}
	
	.red-point {
	    position: absolute;
	    top: 47rpx;
	    right: 36rpx;
	    width: 16rpx;
	    height: 16rpx;
	    border-radius: 50%;
	    background-color: #ff3939;
	}
	
	.game-layout {
	    display: flex;
	    width: 630rpx;
	    height: 220rpx;
	    flex-flow: row nowrap;
	    align-items: flex-start;
	    justify-content: flex-start;
	    border-bottom: 1rpx solid #eaeaea;
	}
	
	.game-avatar {
	    width: 200rpx;
	    height: 200rpx;
	}
</style>
