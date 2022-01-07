<template>
	
	<view class="container" v-if="pageShow">
		
		<!-- v-for="(item, index) in dataList" :key="item.id" -->
		
		<view class="header-nav">
			<view class="search-container">
				<icon @tap="searchClickEvent" size="15" type="search"></icon>
				<view @click="jumpSearch" class="input">搜索{{ lately.length}}位族人</view>
			</view>
		</view>
					
		<!-- 近期过生日 -->
		<view style="height:10rpx;padding:0 -60rpx;background: #f9f9f9;"></view>
		<view class="monthBirthday" v-if="lately.length>0">
			<view class="title">
				<text class="ico"></text>近期过生日
			</view>
			<view @tap="jump(item.id)" class="birthdayInfo clearfix" data-path="detail" data-shouxing="{{item.shouXing}}"
				data-url="{{item.wishUri}}" data-uuid="{{item.id}}" v-for="(item, index) in lately">
				<view class="left clearfix">
					<image src="{{item.avatar}}"></image>
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
		</view>
		
	
		<view @click="jumpImportBir" class="importBir" v-if="lately.length<10 && future.length<10">批量导入生日</view>
		<view style="width: 100%; height: 40rpx;"></view>
		<image @click="addFriend" class="addBtn" src="https://static.shengri.cn/uploads/xydd/web/srgjadd@3x.png">
		</image>
		
	</view>

</template>

<script>
	var domain = 'http://192.168.2.28:8001';
	export default {
		data() {
			return {
				pageShow: true,
				api2_token: '',
				text: '',
				data: {},
				dataList: [],
				today:[],
				upcoming:[],
				lately:[],
				future:[],
				
			}
		},
		onLoad() {
			this.init()
		},
		methods: {

			init: function() {

				//this.api2_token = uni.getStorageSync('api2_token');
				// console.log(this.api2_token)
				
				this.lately = uni.getStorageSync('ab_list');
				if(this.lately){
					return;
				}

				let uid = 169952;
				uni.request({
					url: `${domain}/wxapp/addressbook/list/${uid}`,
					method: 'GET',
					data: {
						orderby: 'birthday' // 排序方式orderby：birthday、code、nineyear、relationship、addtime
					},
					header: {
						'Authorization': uni.getStorageSync('api2_token')
					},
					success: (res) => {
						console.log(res.data);
						this.text = 'request success';
						if (res.data.success) {
							this.data = res.data.data;
							this.dataList = this.data.list;
							// this.today = this.dataList;
							this.lately = this.dataList;
							// this.upcoming = this.dataList;
							// this.future = this.dataList;
							
							uni.setStorageSync('ab_list', this.dataList)
						}
					}
				})

			},

		    jump: function(id) {
				console.log('jump')
				console.log(id)
				
				uni.navigateTo({
					url: `../addressbook/addForm?uuid=${id}`
				});
			},
			
			addFriend: function() {
				console.log('addFriend')
				uni.navigateTo({
					url: "../addressbook/addEntry"
				});
			}, 
			jumpImportBir: function() {
				console.log('jumpImportBir')
				// wx.navigateTo({
				// 	url: "../addEntry/index"
				// });
			},
			jumpSearch: function() {
				console.log('jumpSearch')
				uni.navigateTo({
					url: "../addressbook/search"
				});
			},
			toDanGao: function() {
				console.log('toDanGao')
				// wx.navigateTo({
				// 	url: "../search/search"
				// });
			},
			enterWishwall: function() {
				console.log('enterWishwall')
				// wx.navigateTo({
				// 	url: "../search/search"
				// });
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

::-webkit-scrollbar {
    display: none;
    width: 0;
    height: 0;
    opacity: 0;
    color: transparent;
}

.container {
    box-sizing: border-box;
    width: 100%;
    background: #fff;
}

.kefu {
    position: relative;
    width: 100%;
    height: 80rpx;
    line-height: 80rpx;
    text-align: center;
    font-family: PingFangSC-Regular;
    font-size: 24rpx;
    color: #FF3939;
    background-color: rgba(255,57,57,0.1);
}

.kefu .angle {
    display: inline-block;
    margin-left: 20rpx;
    border-left: 12rpx solid #ff3939;
    border-right: 12rpx solid transparent;
    border-top: 6rpx solid transparent;
    border-bottom: 6rpx solid transparent;
}

.kefu button {
    position: absolute;
    top: 0;
    display: block;
    width: 100%;
    height: 100%;
    opacity: 0;
}

.history-today {
    margin: 36rpx 60rpx 40rpx;
    border-bottom: 1rpx solid #eaeaea;
}

.arrow {
    position: relative;
}

.share-btn {
    font-size: 28rpx;
    color: #FF3939;
    line-height: 80rpx;
    padding: 0 40rpx;
    border: 1rpx solid #FF3939;
    box-sizing: border-box;
    width: 400rpx;
}

.importBir {
    width: 360rpx;
    font-size: 32rpx;
    line-height: 80rpx;
    color: #ff3939;
    border: 1rpx solid #ff3939;
    text-align: center;
    margin: 60rpx auto;
}

.arrow::after {
    border: 12rpx solid #333;
    border-right: 12rpx solid transparent;
    border-top: 6rpx solid transparent;
    border-bottom: 6rpx solid transparent;
    content: "";
    width: 0;
    height: 0;
    position: absolute;
    top: 50%;
    transform: translate3d(0,-50%,0);
    right: -4rpx;
}

.history-date {
    color: #333333;
    font-size: 48rpx;
    line-height: 48rpx;
    font-family: BodoniSvtyTwoITCTT-Book;
}

.history-date-box {
    display: flex;
    margin-top: 40rpx;
    margin-bottom: 16rpx;
}

.history-title {
    font-family: PingFangSC-Light;
    margin-bottom: 18rpx;
    font-size: 32rpx;
    color: #333;
}

.history-lunar {
    color: #333;
    font-size: 32rpx;
    line-height: 48rpx;
    font-family: BodoniSvtyTwoITCTT-Book;
    margin-left: 14rpx;
}

.history-header {
    display: flex;
    margin-bottom: 36rpx;
    height: 46rpx;
    line-height: 46rpx;
    font-size: 28rpx;
    font-family: PingFangSC-Regular;
    color: #999;
    align-items: center;
}

.history-header text {
    height: 46rpx;
    line-height: 46rpx;
}

.header-nav {
    background: #fff;
    align-items: center;
    padding: 40rpx;
}

.search-container {
    position: relative;
    height: 68rpx;
    color: #FFF;
    border-radius: 8rpx;
    z-index: 100;
    overflow: hidden;
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

.search-container .input {
    background: #F9F9F9;
    line-height: 68rpx;
    color: #999999;
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

.container .remind {
    margin: 0 auto 40rpx auto;
    width: 516rpx;
    height: 60rpx;
    border-radius: 30rpx;
    text-align: center;
    line-height: 60rpx;
    font-family: PingFangSC-Regular;
    font-size: 28rpx;
    display: flex;
    justify-content: space-between;
    padding: 0 15rpx;
    box-sizing: border-box;
}

.addtip {
    background: #F8F8F8;
    color: #333333;
}

.wechatip {
    background: #FF000020;
    color: #F00;
}

.header {
    display: flex;
    margin-bottom: 20rpx;
}

.self-wishes {
    display: flex;
    justify-content: flex-end;
    margin-bottom: 40rpx;
}

.header .avatar {
    padding: 30rpx 0 0 4rpx;
    width: 124rpx;
    height: 160rpx;
    background-image: url('https://static.shengri.cn/uploads/xydd/web/ww-dtsr-xk.png');
    background-size: 100%;
    margin-right: 24rpx;
    box-sizing: border-box;
}

.header .avatar image {
    width: 116rpx;
    height: 116rpx;
    border-radius: 100%;
}

.header .birth {
    flex: 1;
}

.header .name-box {
    display: flex;
    justify-content: flex-start;
    margin-bottom: 20rpx;
    font-size: 36rpx;
    line-height: 36rpx;
}

.header .name {
    font-family: PingFangSC-Regular;
    font-size: 36rpx;
    color: #333333;
    line-height: 52rpx;
    margin-right: 16rpx;
    flex: 1;
}

.header .name-box image {
    width: 236rpx;
    height: 52rpx;
}

.header .birth-desc {
    font-family: PingFangSC-Light;
    font-size: 28rpx;
    color: #999;
    line-height: 28rpx;
    margin-bottom: 20rpx;
}

.header .hb {
    font-family: PingFangSC-Light;
    font-size: 28rpx;
    color: #666666;
    line-height: 28rpx;
}

.todayBirthday {
    margin: 40rpx auto 0;
    width: 630rpx;
}

.todayBirthday .title {
    margin-bottom: 34rpx;
    font-family: PingFangSC-Regular;
    font-size: 26rpx;
    line-height: 52rpx;
    color: #999999;
}

.todayBirthday .title .ico,.comingBirthday .title .ico,.recentBirthday .title .ico,.monthBirthday .title .ico {
    margin-right: 10rpx;
    display: inline-block;
    vertical-align: top;
    width: 52rpx;
    height: 52rpx;
    background-image: url('https://static.shengri.cn/uploads/xydd/web/srgjshengri@2x.png');
    background-repeat: no-repeat;
    background-size: 100%;
}

.todayBirthday .item {
    width: 100%;
}

.todayBirthday .item .top {
    width: 100%;
}

.todayBirthday .item .top .left {
    float: left;
    width: 480rpx;
}

.todayBirthday .item .top .left .avatar {
    float: left;
    padding: 30rpx 0 0 4rpx;
    width: 124rpx;
    height: 160rpx;
    background-image: url('https://static.shengri.cn/uploads/xydd/web/ww-dtsr-xk.png');
    background-size: 100%;
    margin-right: 24rpx;
    box-sizing: border-box;
}

.todayBirthday .item .top .left .avatar image {
    width: 116rpx;
    height: 116rpx;
    border-radius: 50%;
}

.todayBirthday .item .top .left .msg {
    float: left;
    /* width: 330rpx; */
    width: 130rpx;
}

.todayBirthday .item .top .left .msg .name {
    font-family: PingFangSC-Regular;
    font-size: 36rpx;
    color: #333333;
    /* width: 100%; */
    width: 130rpx;
    height: 50rpx;
    line-height: 50rpx;
    overflow: hidden;
    display: -webkit-box;
    -webkit-line-clamp: 1;
    -webkit-box-orient: vertical;
}

.todayBirthday .item .top .left .msg .date {
    margin: 10rpx 0 16rpx 0;
    font-family: PingFangSC-Light;
    font-size: 28rpx;
    color: #999999;
}

.todayBirthday .item .top .left .msg .lable {
    font-family: PingFangSC-Light;
    font-size: 24rpx;
    color: #999999;
}

.todayBirthday .item .top .right {
    margin-top: 17rpx;
    float: right;
    width: 116rpx;
    background-image: url('https://static.shengri.cn/uploads/image/app/wxapp/brwall/enterwall-btn.png');
    background-repeat: no-repeat;
    background-size: 116rpx 116rpx;
    font-family: PingFangSC-Light;
    font-size: 24rpx;
    text-align: center;
    padding-top: 100rpx;
    color: #FF3939;
}

.todayBirthday .item .top .ding-dangao {
    background-image: url('https://static.shengri.cn/uploads/image/app/wxapp/brwall/dingdangao-btn.png');
}

.todayBirthday .item .bottom {
    padding: 22rpx 0 0.1rpx 22rpx;
    margin: 26rpx auto 0 auto;
    width: 100%;
    background-color: #F9F9F9;
}

.todayBirthday .item .bottom .wishInfo {
    margin-bottom: 20rpx;
    font-family: PingFangSC-Light;
    font-size: 28rpx;
    color: #151515;
}

.todayBirthday .item .bottom .wishInfo image {
    margin-right: 16rpx;
    margin-top: -3rpx;
    float: left;
    width: 48rpx;
    height: 48rpx;
    border-radius: 50%;
}

.starBirthday {
    width: 100%;
}

.starBirthday .title {
    margin: 0 auto 36rpx auto;
    width: 630rpx;
    font-family: PingFangSC-Regular;
    font-size: 28rpx;
    color: #999999;
}

.starBirthday .title .ico {
    margin-right: 10rpx;
    display: inline-block;
    vertical-align: middle;
    width: 52rpx;
    height: 52rpx;
    background-image: url('https://static.shengri.cn/uploads/xydd/web/srgjstar@3x.png');
    background-repeat: no-repeat;
    background-size: 100%;
}

.starBirthday .Bg {
    margin-bottom: 80rpx;
    padding: 0.1rpx;
    width: 100%;
    height: 300rpx;
    background-color: cyan;
    box-sizing: border-box;
}

.starBirthday .Bg .name {
    margin: 74rpx 0 0 118rpx;
    font-family: .PingFangSC-Regular;
    font-size: 48rpx;
    color: #333333;
}

.starBirthday .Bg .desc {
    margin: 18rpx 0 0 118rpx;
    font-family: .PingFangSC-Light;
    font-size: 24rpx;
    color: #333333;
}

.starBirthday .Bg .btn {
    margin: 28rpx 0 0 74rpx;
    width: 200rpx;
    height: 68rpx;
    border: 1px solid #CC9E3D;
    line-height: 68rpx;
    text-align: center;
    font-family: PingFangSC-Light;
    font-size: 28rpx;
    color: #CC9E3D;
}

.comingBirthday {
    margin: 0 auto;
    width: 630rpx;
}

.comingBirthday .title {
    margin-bottom: 34rpx;
    font-family: PingFangSC-Regular;
    font-size: 26rpx;
    line-height: 52rpx;
    color: #999999;
}

.comingBirthday .birthdayInfo {
    padding-top: 30rpx;
    width: 100%;
    height: 140rpx;
    border-bottom: 1px solid #EAEAEA;
    box-sizing: border-box;
}

.comingBirthday .birthdayInfo:last-child {
    border: none;
}

.comingBirthday .birthdayInfo .left {
    float: left;
}

.comingBirthday .birthdayInfo .left image {
    float: left;
    margin-right: 28rpx;
    width: 80rpx;
    height: 80rpx;
    border-radius: 50%;
}

.comingBirthday .birthdayInfo .left .msg {
    float: left;
    margin-top: -8rpx;
}

.comingBirthday .birthdayInfo .left .msg .name {
    margin-bottom: 10rpx;
    font-family: PingFangSC-Regular;
    font-size: 32rpx;
    color: #333333;
    /* width: 390rpx; */
    width: 190rpx;
    height: 44rpx;
    line-height: 44rpx;
    overflow: hidden;
    display: -webkit-box;
    -webkit-line-clamp: 1;
    -webkit-box-orient: vertical;
}

.comingBirthday .birthdayInfo .left .msg .date {
    font-family: PingFangSC-Light;
    font-size: 28rpx;
    color: #999999;
}

.comingBirthday .birthdayInfo .right {
    float: right;
}

.comingBirthday .birthdayInfo .day {
    text-align: right;
    font-family: PingFangSC-Regular;
    font-size: 24rpx;
    color: #FF3939;
}

.comingBirthday .birthdayInfo .nextBirthday {
    text-align: right;
    font-family: PingFangSC-Light;
    font-size: 24rpx;
    color: #999999;
}

.tobind-phone {
    margin: 0 auto;
    width: 630rpx;
    height: 336rpx;
    background-image: url('https://static.shengri.cn/uploads/xydd/web/srgjmp/find-birth-banner1.png?imageslim');
    background-position: left bottom;
    background-size: 100% 260rpx;
    background-repeat: no-repeat;
}

.mayFriends {
    padding: 0.1rpx;
    width: 100%;
    height: 680rpx;
    background-color: #F9F9F9;
    box-sizing: border-box;
}

.mayFriends .title {
    margin: 40rpx auto 30rpx;
    width: 630rpx;
    font-family: PingFangSC-Regular;
    font-size: 28rpx;
    color: #999999;
}

.mayFriends .friendsInfo {
    float: right;
    width: 690rpx;
    height: 500rpx;
    white-space: nowrap;
}

.mayFriends .friendsInfo .item {
    display: inline-block;
    position: relative;
    margin-right: 10rpx;
    width: 310rpx;
    height: 100%;
    padding-top: 0.1px;
    background-color: #ffffff;
    box-sizing: border-box;
}

.mayFriends .friendsInfo .item .more {
    width: 310rpx;
    height: 100%;
    background: url('https://static.shengri.cn/uploads/xydd/web/srgjmore@2x.jpg');
    background-repeat: no-repeat;
    background-size: 100%;
}

.mayFriends .friendsInfo .item image {
    position: absolute;
    top: 40rpx;
    left: 95rpx;
    width: 120rpx;
    height: 120rpx;
    border-radius: 50%;
}

.mayFriends .friendsInfo .item .name {
    position: absolute;
    top: 200rpx;
    left: 0;
    width: 100%;
    height: 34rpx;
    line-height: 34rpx;
    text-align: center;
    font-family: PingFangSC-Regular;
    font-size: 32rpx;
    color: #333333;
    overflow: hidden;
}

.mayFriends .friendsInfo .item .desc {
    position: absolute;
    top: 250rpx;
    left: 35rpx;
    width: 240rpx;
    height: 64rpx;
    line-height: 32rpx;
    text-align: center;
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
    position: absolute;
    top: 360rpx;
    left: 30rpx;
    width: 230rpx;
    height: 68rpx;
    border: 1px solid #333333;
    line-height: 68rpx;
    text-align: center;
    font-family: PingFangSC-Regular;
    font-size: 28rpx;
    color: #333333;
}

.mayFriends .friendsInfo .item .ignore-btn {
    position: absolute;
    right: 14rpx;
    top: 14rpx;
    width: 37rpx;
    height: 37rpx;
    background-image: url('https://static.shengri.cn/uploads/xydd/web/srgjmp/close-recommand.png?imageslim');
    background-size: 17rpx 17rpx;
    background-repeat: no-repeat;
    background-position: center center;
}

.mayFriends .friendsInfo .item .new-icon {
    position: absolute;
    left: 10rpx;
    top: 10rpx;
    width: 76rpx;
    height: 44rpx;
    background-image: url('https://static.shengri.cn/uploads/xydd/web/srgjmp/new-friends.png?imageslim');
    background-size: 100% 100%;
}

.recentBirthday {
    margin: 0 auto;
    width: 630rpx;
}

.recentBirthday .title {
    margin: 40rpx 0 5rpx 0;
    width: 100%;
    font-family: PingFangSC-Regular;
    font-size: 28rpx;
    color: #999999;
}

.recentBirthday .birthdayInfo {
    padding-top: 30rpx;
    width: 100%;
    height: 140rpx;
    border-bottom: 1px solid #EAEAEA;
    box-sizing: border-box;
}

.recentBirthday .birthdayInfo:last-child {
    border-bottom: none;
}

.recentBirthday .birthdayInfo .left {
    float: left;
}

.recentBirthday .birthdayInfo .left image {
    float: left;
    margin-right: 28rpx;
    width: 80rpx;
    height: 80rpx;
    border-radius: 50%;
}

.recentBirthday .birthdayInfo .left .msg {
    float: left;
}

.recentBirthday .birthdayInfo .left .msg .name {
    margin-bottom: 6rpx;
    font-family: PingFangSC-Regular;
    font-size: 32rpx;
    color: #333333;
    /* width: 390rpx; */
    width: 190rpx;
    height: 44rpx;
    line-height: 44rpx;
    overflow: hidden;
    display: -webkit-box;
    -webkit-line-clamp: 1;
    -webkit-box-orient: vertical;
}

.recentBirthday .birthdayInfo .left .msg .date {
    font-family: PingFangSC-Light;
    font-size: 28rpx;
    color: #999999;
}

.recentBirthday .birthdayInfo .right {
    float: right;
}

.recentBirthday .birthdayInfo .day {
    text-align: right;
    font-family: PingFangSC-Regular;
    font-size: 24rpx;
    color: #FF3939;
}

.recentBirthday .birthdayInfo .nextBirthday {
    text-align: right;
    font-family: PingFangSC-Light;
    font-size: 24rpx;
    color: #999999;
}

.monthBirthday {
    margin: 0 auto;
    width: 630rpx;
}

.monthBirthday .title {
    margin: 10rpx 0 17rpx 0;
    width: 100%;
    font-family: PingFangSC-Regular;
    font-size: 28rpx;
    line-height: 52rpx;
    color: #999999;
}

.monthBirthday .birthdayInfo {
    padding-top: 30rpx;
    width: 100%;
    height: 140rpx;
    border-bottom: 1px solid #EAEAEA;
    box-sizing: border-box;
}

.monthBirthday .birthdayInfo:last-child {
    border-bottom: none;
}

.monthBirthday .birthdayInfo .left {
    float: left;
}

.monthBirthday .birthdayInfo .left image {
    float: left;
    margin-right: 28rpx;
    width: 80rpx;
    height: 80rpx;
    border-radius: 50%;
}

.monthBirthday .birthdayInfo .left .msg {
    float: left;
}

.monthBirthday .birthdayInfo .left .msg .name {
    margin-bottom: 6rpx;
    font-family: PingFangSC-Regular;
    font-size: 32rpx;
    color: #333333;
    /* width: 390rpx; */
    width: 190rpx;
    height: 44rpx;
    line-height: 44rpx;
    overflow: hidden;
    display: -webkit-box;
    -webkit-line-clamp: 1;
    -webkit-box-orient: vertical;
}

.monthBirthday .birthdayInfo .left .msg .date {
    font-family: PingFangSC-Light;
    font-size: 28rpx;
    color: #999999;
}

.monthBirthday .birthdayInfo .right {
    float: right;
}

.monthBirthday .birthdayInfo .day {
    text-align: right;
    font-family: PingFangSC-Regular;
    font-size: 24rpx;
    color: #FF3939;
}

.monthBirthday .birthdayInfo .nextBirthday {
    text-align: right;
    font-family: PingFangSC-Light;
    font-size: 24rpx;
    color: #999999;
}

.addBtn {
    position: fixed;
    bottom: 40rpx;
    left: 630rpx;
    width: 78rpx;
    height: 78rpx;
}

.today-star {
    font-family: PingFangSC-Regular;
    height: 110rpx;
    line-height: 110rpx;
    color: #999;
    font-size: 28rpx;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 60rpx;
}

.star-box {
    width: 690rpx;
    white-space: nowrap;
    margin-left: 60rpx;
    font-size: 28rpx;
    color: #333;
}

.star-info {
    font-family: PingFangSC-Light;
    display: inline-block;
    vertical-align: top;
    width: 288rpx;
    text-align: center;
}

.star-name-in {
    font-size: 44rpx;
    padding-top: 44rpx;
    padding-bottom: 20rpx;
    line-height: 48rpx;
    width: 100%;
    text-overflow: ellipsis;
    white-space: nowrap;
    overflow: hidden;
}

.star-birth-in {
    padding-bottom: 30rpx;
    line-height: 24rpx;
    font-size: 24rpx;
    color: #999;
}

.star-like {
    width: 200rpx;
    height: 68rpx;
    line-height: 68rpx;
    color: #CC9E3D;
    border: 1rpx solid #CC9E3D;
    box-sizing: border-box;
    margin-left: auto;
    margin-right: auto;
}

.single-star {
    width: 630rpx;
    height: 300rpx;
    padding: 30rpx;
    display: inline-block;
    box-sizing: border-box;
    border: 1rpx solid #E8E8E8;
    margin-right: 10rpx;
}

.star-avatar {
    width: 240rpx;
    height: 240rpx;
    border-radius: 100%;
    display: inline-block;
    float: right;
}

.star-container {
    margin-bottom: 40rpx;
}

.today-star .left {
    position: relative;
}

.today-star .left image {
    width: 46rpx;
    height: 42rpx;
    display: inline-block;
    position: absolute;
    top: 48%;
    transform: translate3d(0,-50%,0);
}

.today-star .left .today-birth {
    padding-left: 50rpx;
    line-height: 42rpx;
    margin-right: 20rpx;
}

.ad-wrap ad {
    margin: 20rpx auto;
    border: 20rpx solid #f9f9f9;
}

.some-border {
    height: 20rpx;
    padding: 0 -60rpx;
    background: #f9f9f9;
}

.ta-luo {
    padding: 40rpx 60rpx;
    border-bottom: 20rpx solid #f9f9f9;
}

.ta-luo .title,.today-star .title {
    height: 52rpx;
    margin-bottom: 30rpx;
    font-family: PingFangSC-Regular;
    font-size: 28rpx;
    color: #999999;
    line-height: 52rpx;
    padding-left: 60rpx;
    background: url(https://static.shengri.cn/uploads/image/taLuo/taluo-icon.png) no-repeat 0 0;
    background-size: 52rpx;
}

.today-star .title {
    margin-bottom: 0;
    background-image: url(https://static.shengri.cn/uploads/image/todayLuck/weapp/dynamic_idols.png);
}

.luck .title {
    background-image: url(https://static.shengri.cn/uploads/image/todayLuck/weapp/icon-tit.png);
}

.ta-luo .ta-luo-inner {
    height: 300rpx;
    background: url(https://static.shengri.cn/uploads/image/taLuo/cardbg.png) no-repeat 0 0;
    background-size: 100%;
    display: flex;
    justify-content: space-between;
    padding: 30rpx 30rpx 30rpx 60rpx;
    box-sizing: border-box;
    font-size: 28rpx;
    color: #333333;
    font-weight: normal;
}

.ta-luo-left {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
    max-width: 240rpx;
    padding-bottom: 10rpx;
}

.ta-luo-left .ta-luo-title {
    display: flex;
    flex-direction: column;
    font-size: 36rpx;
    font-family: PingFang-SC-Regular;
    text-align: center;
    letter-spacing: 0;
    line-height: 40rpx;
    margin-top: 20rpx;
    flex: 1;
}

.ta-luo-left .ta-luo-title2 {
    justify-content: center;
}

.ta-luo-left .ta-luo-date {
    font-size: 24rpx;
    line-height: 24rpx;
    letter-spacing: 0;
    margin-top: 12rpx;
    flex: 0;
}

.ta-luo-left .ta-luo-btn {
    width: 200rpx;
    height: 68rpx;
    box-sizing: border-box;
    border: 1rpx solid #666;
    border-radius: 1px;
    font-family: PingFang-SC-Regular;
    font-size: 28rpx;
    line-height: 68rpx;
    text-align: center;
    line-height: center;
    margin-top: 30rpx;
    flex: 0;
}

.ta-luo-right {
    position: relative;
    width: 240rpx;
    height: 100%;
}

.ta-luo-right .ta-luo-right-bg {
    width: 100%;
    height: 100%;
    background-color: rgba(251,216,88,.3);
    border-radius: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
}

.ta-luo-right .ta-luo-right-bg view {
    width: 200rpx;
    height: 200rpx;
    background-color: rgba(251,216,88,.7);
    border-radius: 50%;
}

.ta-luo-right .ta-luo-img {
    width: 140rpx;
    height: 240rpx;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-50%);
}

.to-dangao-btn {
    margin-top: -23rpx;
    float: right;
    width: 116rpx;
    background-image: url('https://static.shengri.cn/uploads/image/app/wxapp/brwall/dingdangao-btn.png');
    background-repeat: no-repeat;
    background-size: 116rpx 116rpx;
    font-family: PingFangSC-Light;
    font-size: 24rpx;
    line-height: 24rpx;
    text-align: center;
    padding-top: 100rpx;
    color: #FF3939;
}

.jijiang .birthdayInfo .left .msg .name {
    width: auto;
    display: flex;
    align-items: center;
}

.jijiang .birthdayInfo .left .msg .name>text {
    display: block;
}

.jijiang .birthdayInfo .left .msg .name .text-name {
    display: -webkit-box;
    -webkit-line-clamp: 1;
    -webkit-box-orient: vertical;
    max-width: 240rpx;
    margin-right: 20rpx;
}

.jijiang .birthdayInfo .left .msg .name .text-date {
    font-family: PingFangSC-Light;
    font-size: 28rpx;
    color: #999999;
    line-height: 28rpx;
    padding-left: 20rpx;
    border-left: 1px solid #999;
}

.jijiang .birthdayInfo .left .msg .date {
    max-width: 360rpx;
    display: -webkit-box;
    -webkit-line-clamp: 1;
    -webkit-box-orient: vertical;
    overflow: hidden;
}

.date-red {
    font-family: PingFangSC-Regular;
    font-size: 40rpx;
    color: #FF3939;
    text-align: right;
    line-height: 40rpx;
    margin-right: 8rpx;
}

.date-font {
    font-family: PingFangSC-Regular;
    font-size: 24rpx;
    color: #999999;
    text-align: right;
}
</style>
