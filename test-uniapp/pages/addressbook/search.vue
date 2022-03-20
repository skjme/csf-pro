<template>
	<view class="continer">
		<view class="header-nav">
			<view class="search-container {{searchActive?'search-active':''}}">
				<icon bindtap="searchClickEvent" size="15" type="search"></icon>
				<input focus @blur="searchBlur" @focus="searchFocus" 
					@input="searchInputEvent"
					confirmType="search" placeholder="搜索族人" placeholderStyle="color:#999999;" type="text"
					:value="val"></input>
				<view @tap="clearVal" class="closeIco" v-if="showClose">x</view>
			</view>
			<view @tap="doSearch" class="search" v-if="searchActive">取消</view>
		</view>
		<view class="searchCont">
			<blcok v-for="(item, index) in searchItem">
				<!-- <view catchtap="jumpDetali" class="searchItem clearfix" data-uuid="{{item.uuid}}">
					<view class="left">
						<view class="avatar">
							<image src="{{item.avatar}}"></image>
						</view>
						<view class="msg">
							<view class="name">{{item.name}} </view>
							<view class="date">{{item.dayLabel}}</view>
						</view>
					</view>
					<view class="right">
						<view class="day">
							<text style="font-size: 40rpx;">{{item.days}}</text>天
						</view>
						<view class="nextBirthday">{{item.textLabel}}</view>
					</view>
				</view> -->
				<view @tap="jump(item.id)"  class="searchItem clearfix test_line1" 
					data-path="detail" data-shouxing="{{item.shouXing}}"
					data-url="{{item.wishUri}}" data-uuid="{{item.id}}">
					<view class="left clearfix1">
						<view class="avatar">
						<image src="{{item.avatar}}"></image>
						</view>
						<view class="msg test_line1">
							<view class="name">{{item.name}}</view> 
							<view class="date">{{item.isLunar?'农':'公'}} {{item.dayLabel}} </view>
						</view>
						<view class="left clearfix" style=" width: 100px; 1px solid #007AFF;">
							<view class="rs_bg">{{item.rsName || '未选择'}} </view>
							<view class="code_circle right clearfix"> {{item.code}}</view>
						 </view>
					</view>	
					
					<view class="right">
						<view class="day">
							<text style="font-size: 40rpx;">{{item.remainingDays}}</text>天
						</view>
						<view class="nextBirthday">{{item.textLabel}}</view>
					</view>
				</view>
			</blcok>
			<view class="searchNothing" wx:if="{{nothingShow}}">查无此人</view>
		</view>
	</view>

</template>

<script>
	export default {
		data() {
			return {
				searchActive: !1,
				nothingShow: !1,
				showCont: !0,
				showClose: !1,
				val: "",
				recommend: [],
				searchItem: [],
			}
		},
		onLoad() {

		},
		onShow() {

		},
		methods: {
			searchFocus: function() {
				this.searchActive = !0
			},
			searchBlur: function(t) {},
			searchInputEvent: function(e) {
				console.log(e.detail.value)
				var a = this,
					i = e.detail.value,
					n = !1;
				var ab_list = uni.getStorageSync('ab_list');
				if (ab_list) {
					this.searchItem = ab_list.filter(item =>{  
											return item.name.indexOf(i) >= 0;  
										})
					console.log('this.searchItem', this.searchItem)
					if(this.searchItem.length > 0){
						this.nothingShow = false
					}else{
						this.nothingShow = true
					}
					this.showClose = true
					this.showCont = true
				}else{
					this.nothingShow = true
					this.showClose = false
					this.showCont = false
				}

				// i ? t.newGet("brapi/search/buddy?&q=" + i, {}).then(function(t) {
				// 	0 == t.data.items.length && (n = !0), a.setData({
				// 		searchItem: t.data.items,
				// 		nothingShow: n,
				// 		showClose: !0
				// 	});
				// }) : a.setData({
				// 	showClose: !1
				// }), a.setData({
				// 	showCont: !1
				// });
			},
			clearVal: function() {
				this.val = ""
				this.showClose = false
				console.log('this.val', this.val)
			},
			doSearch: function() {
				console.log('doSearch')
				uni.navigateBack({
					url: "../addressbook/addressbook"
				});
			},
			jump: function(id) {
				console.log('jump')
				console.log('id', id)
		
				uni.navigateTo({ 
					url: `../addressbook/addForm?uuid=${id}`
				});
				
			},
		}
	}
</script>

<style>
	page {
		width: 100%;
		height: 100%;
		background-color: #fff;
	}
	
	
.test_line{
	border: 1px solid #007AFF;
}

.code_circle{
	border-radius: 50%;
	width: 60rpx; 
	height: 60rpx; 
	line-height: 60rpx;
	text-align: center;
	color: #FFFFFF;
	background-color: #6E238F; 
}
.rs_bg{
	width: 80rpx; 
	font-size: small;
	background-color: #B9DC53; 
	vertical-align: center; 
	text-align: center;
	color: #FFFFFF;
}

	.continer {
		width: 100%;
		height: 100%;
		background-color: #fff;
		padding-top: 1rpx;
	}

	.header-nav {
		background: #fff;
		align-items: center;
		padding: 20rpx 40rpx 0 40rpx;
	}

	.search-container {
		position: relative;
		height: 68rpx;
		color: #FFF;
		border-radius: 8rpx;
		z-index: 100;
		overflow: hidden;
	}

	.search-active {
		margin-right: 110rpx;
	}

	.search {
		position: absolute;
		z-index: 110;
		right: 35rpx;
		top: 25rpx;
		font-size: 32rpx;
		color: #333333;
		line-height: 62rpx;
		padding: 0 20rpx;
	}

	.search-container input {
		background: #F9F9F9;
		color: #333333;
		padding: 0 60rpx;
		font-size: 28rpx;
		height: 100%;
		border-radius: 7rpx;
		padding-right: 30rpx;
	}

	.search-container icon {
		position: absolute;
		z-index: 10;
		left: 17rpx;
		top: 18rpx;
	}

	.search-container .closeIco {
		position: absolute;
		z-index: 10;
		top: 20rpx;
		right: 15rpx;
		width: 30rpx;
		height: 30rpx;
		border-radius: 50%;
		line-height: 30rpx;
		text-align: center;
		font-size: 28rpx;
		background: rgb(194, 194, 194);
		color: #fff;
	}

	.content {
		margin: 20rpx auto 0 auto;
		width: 100%;
		background: #F9F9F9;
	}

	.mayFriends {
		padding: 0.1rpx;
		width: 100%;
		height: 670rpx;
		box-sizing: border-box;
	}

	.mayFriends .title {
		margin: 40rpx auto;
		width: 100%;
		text-align: center;
		font-family: PingFangSC-Regular;
		font-size: 28rpx;
		color: #999999;
	}

	.mayFriends .friendsInfo {
		margin: 0 auto;
		width: 690rpx;
		height: 500rpx;
		float: right;
		white-space: nowrap;
		background-color: #F9F9F9;
	}

	.mayFriends .friendsInfo .item {
		display: inline-block;
		margin-right: 10rpx;
		width: 310rpx;
		height: 100%;
		background-color: #ffffff;
		box-sizing: border-box;
	}

	.mayFriends .friendsInfo .item .more {
		position: absolute;
		top: 0;
		left: 0;
		width: 310rpx;
		height: 100%;
		background: url('https://static.shengri.cn/uploads/xydd/web/srgjmore@2x.jpg');
		background-repeat: no-repeat;
		background-size: 100%;
	}

	.mayFriends .friendsInfo .item image {
		margin: 40rpx auto 36rpx auto;
		width: 120rpx;
		height: 120rpx;
		border-radius: 50%;
	}

	.mayFriends .friendsInfo .item .name {
		width: 100%;
		height: 34rpx;
		line-height: 34rpx;
		text-align: center;
		font-family: PingFangSC-Regular;
		font-size: 32rpx;
		color: #333333;
		overflow: hidden;
	}

	.mayFriends .friendsInfo .item .date {
		margin: 14rpx 0;
		width: 100%;
		height: 30rpx;
		line-height: 30rpx;
		text-align: center;
		font-family: PingFangSC-Light;
		font-size: 28rpx;
		color: #999999;
	}

	.mayFriends .friendsInfo .item .desc {
		margin: 0 auto;
		width: 240rpx;
		height: 64rpx;
		line-height: 32rpx;
		font-family: PingFangSC-Light;
		font-size: 24rpx;
		color: #999999;
		white-space: normal;
		overflow: hidden;
		display: -webkit-box;
		-webkit-line-clamp: 2;
		-webkit-box-orient: vertical;
	}

	.mayFriends .friendsInfo .item .btn {
		margin: 32rpx auto 0 auto;
		width: 230rpx;
		height: 68rpx;
		border: 1px solid #333333;
		line-height: 68rpx;
		text-align: center;
		font-family: PingFangSC-Regular;
		font-size: 28rpx;
		color: #333333;
	}

	.searchCont {
		margin: 20rpx auto 0 auto;
		width: 630rpx;
		background: #FFFFFF;
	}

	.searchCont .searchNothing {
		margin-top: 40rpx;
		width: 100%;
		text-align: center;
		font-family: PingFangSC-Regular;
		font-size: 28rpx;
		color: #999999;
	}

	.searchCont .searchItem {
		margin: 26rpx auto 0 auto;
		width: 630;
		height: 110rpx;
		box-sizing: border-box;
		border-bottom: 1px solid #EAEAEA;
	}

	.searchCont .searchItem .left {
		float: left;
		width: 480rpx;
		height: 100%;
	}

	.searchCont .searchItem .left .avatar {
		margin: 0rpx 28rpx 0 0;
		float: left;
		width: 80rpx;
		/* height: 800rpx; */
	}

	.searchCont .searchItem .left .avatar image {
		width: 80rpx;
		height: 80rpx;
		border-radius: 50%;
	}

	.searchCont .searchItem .left .msg {
		float: left;
		/* width: 370rpx; */
		width: 170rpx;
	}

	.searchCont .searchItem .left .msg .name {
		/* margin-top: 30rpx; */
		font-family: PingFangSC-Regular;
		font-size: 32rpx;
		color: #333333;
		width: 100%;
		height: 50rpx;
		line-height: 50rpx;
		overflow: hidden;
		display: -webkit-box;
		-webkit-line-clamp: 1;
		-webkit-box-orient: vertical;
	}

	.searchCont .searchItem .left .msg .date {
		margin: 4rpx 0 10rpx 0;
		font-family: PingFangSC-Light;
		font-size: 28rpx;
		color: #999999;
	}

	.searchCont .searchItem .right {
		/* margin-top: 30rpx; */
		float: right;
	}

	.searchCont .searchItem .day {
		text-align: right;
		font-family: PingFangSC-Regular;
		font-size: 24rpx;
		color: #FF3939;
	}

	.searchCont .searchItem .nextBirthday {
		text-align: right;
		font-family: PingFangSC-Light;
		font-size: 24rpx;
		color: #999999;
	}
</style>
