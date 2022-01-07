<!-- 添加表单 -->
<template>
	<view class="container">
		<image @click="getPhoto" class="avatarIcon" src="{{userAvatar}}"></image>

		<view class="userInfo">
			<text class="userInfo-title">姓名</text>
			<input @input="nameOnTouch" class="userInfo-content name" placeholder="请输入姓名" placeholderStyle="color:#999"
				type="text" value="{{userName}}"></input>
		</view>

		<view class="userInfo">
			<text class="userInfo-title">性别</text>
			<view class="userInfo-content">
				<view class="userInfo-content-male">
					<image @click="maleOnTouch" class="userInfo-content-icon" mode="aspectFit"
						:src="maleSelected?'../../static/birthwall_checked.png':'../../static/birthwall_unchecked.png'">
					</image>
					<text class="userInfo-content-name" :style="maleSelected?'color:#333;':'color:#999;'">男</text>
				</view>
				<view class="userInfo-content-female">
					<image @click="femaleOnTouch" class="userInfo-content-icon" mode="aspectFit"
						:src="femaleSelected?'../../static/birthwall_checked.png':'../../static/birthwall_unchecked.png'">
					</image>
					<text class="userInfo-content-name" :style="femaleSelected?'color:#333;':'color:#999;'">女</text>
				</view>
			</view>
		</view>

		<view class="userInfo">
			<text class="userInfo-title">生日</text>
			<view @click="birthOnTouch" class="userInfo-content" style="color:#999;">{{birthContent}}</view>
		</view>

		<view class="userInfo">
			<text class="userInfo-title">手机</text>
			<input @input="phoneOnTouch" class="userInfo-content phone" maxlength="11" placeholder="可开启TA的生日祝福墙"
				placeholderStyle="color:#999" type="number" value={{userPhone}}></input>
		</view>

		<!-- 		<view class="separateLine"></view>
		<view @click="showMore" class="more-info" wx:if="{{!moreFlag}}">
			<text class="more-desc">更多设置</text>
			<view class="more-guideIcon"></view>
		</view>
		<view class="userInfo userInfo-relation" wx:if="{{notme&&moreFlag}}">
			<text class="userInfo-title">关系</text>
			<view @click="relationOnTouch" class="userInfo-content"
				style="{{has_relationContent?'color: #333;':'color:#999;'}}">{{relationContent}}</view>
		</view>
		<view class="userInfo userInfo-relation" wx:if="{{moreFlag}}">
			<text class="born-title">出生时间</text>
			<picker bindchange="bindTimeChange" class="userInfo-content" end="23:59" mode="time" start="00:00"
				value="{{time}}">
				<view class="picker" style="{{time?'color: #333;':'color:#999;'}}">
					{{time!=''?time:'选择时间'}}
				</view>
			</picker>
		</view> -->

		<view class="birthBehavior">
			<view @click="saveOnTouch" class="birthBehavior-save">保存</view>
		</view>

		<view class="hint-bg" v-if="showHint">
			<view class="hint-main">
				<view class="hint-title">温馨提示</view>
				<view class="hint-content">{{hintContent}}</view>
				<view @click="closeOnTouch" class="hint-close">知道了</view>
			</view>
		</view>

		<!-- <view class="hint-bg" wx:if="{{showDeleteHint}}">
			<view class="hint-main">
				<view class="hint-title">提示</view>
				<view class="hint-content">确定删除此生日?</view>
				<view class="hint-behavior">
					<view @click="cancelDeleteOnTouch" class="hint-behavior-cancel">否</view>
					<view @click="ensureDeleteOnTouch" class="hint-behavior-ensure">是</view>
				</view>
			</view>
		</view> -->

		<!-- <view @click="dateCancelOnTouch" class="date-bg" v-if="showDate"> -->
		<view class="date-bg" v-if="showDate">
			<view class="date-main">
				<view class="date-behavior">
					<view class="date-behavior-item-calendar">
						<view @click="gregorianDateOnTouch" class="date-behavior-item-normal"
							:style="showGregorianDate?'color: #fff;background-color: #157EFB;':'color: #157EFB;background-color: #fff;'">
							公历</view>
						<view @click="lunarDateOnTouch" class="date-behavior-item-lunar"
							:style="showGregorianDate?'color: #157EFB;background-color: #fff;':'color: #fff;background-color: #157EFB;'">
							农历</view>
					</view>

					<view @click="yearContentOnTouch" class="date-behavior-item-year">
						{{yearContent}}
					</view>
					<view @click="dateCancelOnTouch" class="date-behavior-item" style="color: #0A98D5; margin-right:0">
						取消</view>
					<view @click="dateEnsureOnTouch" class="date-behavior-item">确定</view>
				</view>

				<picker-view @change="dateChange" class="date-content"
					indicatorStyle="height: {{pickerIndicatorHeight}};" value="{{calValues}}">
					<picker-view-column>
						<view class="date-content-item" style="line-height: {{pickerIndicatorHeight}}"
							v-for="(item, index) in calYears">{{item.name}}</view>
					</picker-view-column>

					<picker-view-column>
						<view class="date-content-item" style="line-height: {{pickerIndicatorHeight}}"
							v-for="(item, index) in calMonths">{{item.name}}</view>
					</picker-view-column>

					<picker-view-column>
						<view class="date-content-item" style="line-height: {{pickerIndicatorHeight}}"
							v-for="(item, index) in calDays">{{item.name}}</view>
					</picker-view-column>

				</picker-view>
			</view>
		</view>

		<!-- <view class="picker-layout" wx:if="{{isShowDivision}}">
			<view class="confirm-layout">
				<view @click="confirmCover" class="confirm-btn">确认</view>
			</view>
			<picker-view bindchange="bindAddressChange" @click="confirmCover" class="picker-view"
				indicatorStyle="height: 40px;" style="width: 100%; height: 200px;" value="{{divisionValues}}">
				<picker-view-column>
					<view class="addr-item" wx:for="{{cityRenderprovinceArr}}">{{item.name}}</view>
				</picker-view-column>
				<picker-view-column>
					<view class="addr-item" wx:for="{{cityRendercityArr}}">{{item.name}}</view>
				</picker-view-column>
				<picker-view-column>
					<view class="addr-item" wx:for="{{cityRendercountyArr}}">{{item.name}}</view>
				</picker-view-column>
			</picker-view>
			<view @click="cancelCover" class="picker-cover" style="height:{{coverHeight}}px;"
				wx:if="{{isShowDivision}}"></view>
		</view> -->
	</view>
</template>

<script>
	var a = (require("../../utils/md5.min"),
		// require("../../utils/aes.js"), 
		// require("../../utils/zeropadding.js"), 
		require("../../utils/lunar.js"))
	var e = require("../../utils/cal.js")
	var domain = 'http://192.168.2.28:8001';
	export default {
		data() {
			return {
				uid: uni.getStorageSync('uid') || 169952,
				username: uni.getStorageSync('username') || 'shukejian',

				// 日历。。。。。
				showDate: !1,
				calYears: [],
				year: 1990,
				calMonths: [],
				month: 1,
				calDays: [],
				day: 1,
				showGregorianDate: !0, // 显示阳历
				calValues: [0, 0, 0],
				yearContent: "", // 忽略年份",
				birthContent: "点击设置生日",
				calTip: "",
				pickerIndicatorHeight: "100rpx",
				// 日历 over。。。。。


				userAvatar: '../../static/avatar_default.png',
				has_birthContent: false,
				maleSelected: !1,
				femaleSelected: !1,

				uuid: '', // this.uuid(20, 4),
				userName: "",
				userPhone: "",
				userOwnPhone: "",
				is_createBirth: !0,
				showHint: !1,
				hintContent: ',',
				userBirth_l: false, // 是否使用农历

			}
		},
		onLoad(option) {
			console.log('option', option); //打印出上个页面传递的参数。
			// var e = parseInt(wx.getSystemInfoSync().screenWidth / 15);
			var isCreate = true
			 if(option.uuid){
				isCreate = false
				this.updateCalendarWheel(1990, 1, 1, 0);
			 }
			this.uuid = option.uuid || this.getUUID(20, 30)
			this.initData(isCreate)
		},

		methods: {

			initData: function(isCreate) {
				console.log('initData')

				if(isCreate){
					return
				}
				uni.request({
					url: `${domain}/wxapp/addressbook/get/${this.uid}/${this.uuid}`,
					method: 'GET',
					// data: data, 
					header: {
						'Authorization': uni.getStorageSync('api2_token')
					},
					success: (res) => {
						var data = res.data.data
						console.log("=====get:", data)
						this.uuid = data.item.id;
						this.userAvatar = data.item.avatar
						this.userName = data.item.name
						this.userPhone = data.item.tel || ''
						this.year = data.item.year
						this.month = data.item.month
						this.day = data.item.day
						this.userBirth_l = data.item.isLunar // 是否农历生日
						this.has_birthContent = true
						this.birthContent = data.item.isLunar ? data.item.lunarbirthday : data.item
							.birthday
						this.showGregorianDate = !data.item.isLunar
						this.maleSelected = data.item.gender == 'M'
						this.femaleSelected = data.item.gender == 'F'
						this.is_createBirth = true

						this.updateCalendarWheel(this.year, this.month, this.day, this.userBirth_l);
						
					},
				});

			},

			getPhoto: function() {
				console.log('getPhoto')
				uni.setStorageSync("shouldClearBirthData", !1);
				var t = this; //, a = t.upload_token;
				uni.chooseImage({
					count: 1,
					success: function(e) {
						var n = e.tempFilePaths[0],
							i = n.split("wxfile://")[1];
						//t.userAvatar = n;
						uni.uploadFile({
							url: `${domain}/wxapp/upload`,
							filePath: n,
							name: "file0",
							formData: {
								uploadType: 'addressbook',
								fileName: t.uuid
							},
							header: {
								'Authorization': uni.getStorageSync('api2_token')
							},
							success: function(a) {
								var res = JSON.parse(a.data)
								// console.log(res)
								// console.log(res.data.image_src)
								t.userAvatar = res.data.image_src
							}
						});
					}
				});
			},

			// 点击生日
			birthOnTouch: function() {
				console.log('birthOnTouch')
				this.showDate = true
			},

			// -------日历选择开始-----------
			yearContentOnTouch: function() {
				console.log('yearContentOnTouch');
				var t = this,
					a = t.yearContent;
				// a = "忽略年份" == a ? "显示年份" : "忽略年份";

				var e = t.userBirth_l,
					n = this.year,
					i = this.month,
					r = this.day;
				// "显示年份" == a ? n = 0 : 0 == n && (n = 2e3)

				console.log('n', n)
				this.yearContent = ''; //a
				this.year = n
				this.updateCalendarWheel(n, i, r, e)
			},

			dateEnsureOnTouch: function() {
				console.log('dateEnsureOnTouch')
				var t = this.year,
					a = this.month;
				if (0 == t && 0 == a) {
					this.year = 1990
					this.month = 1
					this.day = 1
				}
				var e = this.calTip;
				this.has_birthContent = !0
				this.showDate = !1
				this.birthContent = e
				console.log(this.birthContent)
			},

			dateCancelOnTouch: function() {
				console.log('dateCancelOnTouch');
				this.showDate = false;
			},
			// t, a, n, i 分表代表年、月、日、是否农历
			updateCalendarWheel: function(t, a, n, i) {

				0 == t && 0 == a && (t = 1990, a = 1, n = 1),
					console.log("updateCalendarWheel--\x3e" + i);

				var r = [],
					o = [],
					d = [],
					s = "",
					h = "",
					l = "";

				i ? (r = e.calendar.createLunarYears(), o = e.calendar.createLunarMonths(t), d = e.calendar
						.createLunarDays(t, a)) : (r = e.calendar.createSolarYears(),
						o = e.calendar.createSolarMonths(), d = e.calendar.createSolarDays(t, a)), console.log(
						"years--------\x3e" + t),
					console.log("months--------\x3e" + a), console.log("days--------\x3e" + n);

				var u = 0,
					c = 0,
					m = 0;
				r.forEach(function(a, e) {
					t == a.id && (u = e, s = a.name, console.log("year index-------\x3e" + u));

				}), o.forEach(function(t, e) {
					console.log("month id->" + t.id + "----name---" + t.name), a == t.id && (c = e,
						h = t.name, console.log("month---get--" + c));

				}), d.forEach(function(t, a) {
					n == t.id && (m = a, l = t.name);
				}), "显示年份" == this.yearContent && (s = "");

				var y = s + h + l;

				this.calTip = y
				this.calYears = r
				this.calMonths = o
				this.calDays = d

				this.year = t
				this.month = a
				this.day = n
				this.calValues = [u, c, m]
			},
			dateChange: function(t) {
				var a = t.detail.value,
					e = a[0],
					n = a[1],
					i = a[2],
					r = this.userBirth_l;
				this.refreshCalendarWheel(e, n, i, r);
			},
			refreshCalendarWheel: function(t, a, n, i) {
				var r = this.calYears,
					o = this.calMonths,
					d = this.calDays,
					s = 0,
					h = 0,
					l = 0,
					u = "",
					c = "",
					m = "";
				"显示年份" != this.yearContent ? r.forEach(function(a, e) {
					t == e && (s = a.id, u = a.name, console.log("year id-------\x3e" + s));

				}) : s = this.year, o.forEach(function(t, e) {
					console.log("month id->" + t.id + "----name---" + t.name), a == e && (h = t.id,
						c = t.name, console.log("month---get--" + h));

				}), this.calValues[0] == t && this.calValues[1] == a || (i ? (o = e.calendar.createLunarMonths(s),
					d = e.calendar.createLunarDays("显示年份" == this.yearContent ? 0 : s, h)) : (o = e.calendar
					.createSolarMonths(s),
					d = e.calendar.createSolarDays("显示年份" == this.yearContent ? 0 : s, h))), d.forEach(function(t,
					a) {
					n == a && (l = t.id, m = t.name);
				}), "显示年份" == this.yearContent && (u = "");

				var y = u + c + m;
				
				this.calTip = y
				this.calYears = r
				this.calMonths = o
				this.calDays = d

				this.calValues = [t, a, n]
				this.year = s
				this.month = h
				this.day = l
			},
			// 选择阳历（公历）
			gregorianDateOnTouch: function() {
				var t = this;
				if (!this.showGregorianDate) {
					var e = t.year,
						n = t.month,
						i = t.day;
					this.showGregorianDate = !0
					this.userBirth_l = !1
					var r = {},
						o = (r = a.Calendar.leapMonth(e) > 0 && n < 0 ? a.Calendar.lunar2solar(e, Math.abs(n), i, !0) :
							a.Calendar.lunar2solar(e, n, i, !1)).lYear,
						d = r.lMonth,
						s = r.lDay;
					this.updateCalendarWheel(o, d, s, 0);
				}
			},
			// 选择农历
			lunarDateOnTouch: function() {
				console.log("lunarDateOnTouch");
				var t = this,
					e = this.showGregorianDate,
					n = t.yearContent;
				if (e) {
					var i = t.year,
						r = t.month,
						o = t.day;
					this.showGregorianDate = !1
					this.userBirth_l = !0

					// if("忽略年份" == n) {
					var d = a.Calendar.solar2lunar(i, r, o),
						s = d.lYear,
						h = d.lMonth,
						l = d.lDay;
					this.updateCalendarWheel(s, h, l, 1);
					// } else this.updateCalendarWheel(s, r, o, 1);
				}
			},

			// -------日历选择结束-----------

			// 保存
			saveOnTouch: function() {
				console.log('saveOnTouch')
				var t = this.is_createBirth,
					a = this.userName,
					e = this.notme;

				if (a.length <= 0) {
					this.showHint = !0
					this.hintContent = "还没有填写名字呢~"
				} else {
					var n = 'F' // 默认为女性
					if (!this.maleSelected && !this.femaleSelected) {
						this.showHint = !0;
						this.hintContent = "还没有选择性别呢~";
						return
					}
					if (this.maleSelected) {
						n = 'M'
					}

					// 验证生日 手机
					if (this.has_birthContent) {
						var i = new Date(),
							r = i.getFullYear(),
							o = i.getMonth() + 1,
							d = i.getDate(),
							s = this.year,
							h = this.month,
							l = this.day;
						if (s > r) {
							this.showHint = !0
							this.hintContent = "生日日期不可以大于当前日期哦"
						} else if (s == r && h > o) {
							this.showHint = !0
							this.hintContent = "生日日期不可以大于当前日期哦"
						} else if (s == r && h == o && l > d) {
							this.showHint = !0
							this.hintContent = "生日日期不可以大于当前日期哦"
						} else if (this.userPhone.length > 0 && !/^1[3|4|5|7|8][0-9]\d{8}$/.test(this.userPhone)) {
							this.showHint = !0
							this.hintContent = "手机号填写不对哦"
						} else {

							// 整理数据
							var u = this.userOwnPhone.length > 0 ? this.userOwnPhone : this.userPhone,
								c = this.userOwnPhone.length > 0 ? this.userPhone : "",
								m = [],
								data = {
									name: a,
									gender: n,
									avatar: this.userAvatar,
									tel: this.userPhone,

									// 生日信息
									year: s,
									month: h,
									day: l,
									is_lunar: this.userBirth_l, // 是否是农历
									birth_t: this.birthContent,

									uuid: this.uuid,
									uid: this.uid,
									username: this.username,
									source: 'wxapp',

									pinyin: '#',
								};
							console.log('data=', data)

							uni.request({
								url: `${domain}/wxapp/addressbook/create`,
								method: 'POST',
								data: data,
								header: {
									'Content-Type': 'application/x-www-form-urlencoded',
									//application/x-www-form-urlencoded是以表格的形式请求，
									// 而application/json则将数据序列化后才进行传递，
									// 如果使用了@RequestParam会在Content里面查找对应的数据，结果因为传递的数据已经被序列化所以不能找到，
									// 所以当要使用@RequestParam注解时候应当使用application/x-www-form-urlencoded，
									// 而如果想要使用application/json则应当使用@RequestBody获取被序列化的参数
									'Authorization': uni.getStorageSync('api2_token')
								},
								success: (res) => {
									console.log("=====save:", res)
									uni.showToast({
									    title: '恭喜，操作完成',
									    duration: 5000,
										complete:function(){
											uni.navigateTo({
												url:'../addressbook/addressbook'
											})
										}
									});
								},
							});

						}

					} else {

						this.showHint = !0
						this.hintContent = "还没有添加生日呢~"
					}

				}
			},
			closeOnTouch: function() {
				this.showHint = !1;
			},

			nameOnTouch: function(t) {
				this.userName = t.detail.value
			},

			maleOnTouch: function() {
				console.log('maleOnTouch')
				this.maleSelected = true
				this.femaleSelected = false
			},

			femaleOnTouch: function() {
				console.log('femaleOnTouch')
				this.maleSelected = false
				this.femaleSelected = true
			},

			phoneOnTouch: function(t) {
				this.userPhone = t.detail.value
			},
			
			getUUID: function(len, radix) {
				var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
				var uuid = [],
					i;
				radix = radix || chars.length;

				if (len) {
					// Compact form
					for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random() * radix];
				} else {
					// rfc4122, version 4 form
					var r;

					// rfc4122 requires these characters
					uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
					uuid[14] = '4';

					// Fill in random data.  At i==19 set the high bits of clock sequence as
					// per rfc4122, sec. 4.1.5
					for (i = 0; i < 36; i++) {
						if (!uuid[i]) {
							r = 0 | Math.random() * 16;
							uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
						}
					}
				}

				return uuid.join('');
			}
		}
	}
</script>

<style>
	page {
		width: 100%;
		height: 100%;
		background-color: #fff;
	}

	.container {
		width: 100%;
		height: 100%;
	}

	.avatarIcon {
		margin: 60rpx auto 60rpx;
		width: 160rpx;
		height: 160rpx;
		border-radius: 50%;
		background-repeat: no-repeat;
		background-size: contain;
	}

	.userInfo {
		display: flex;
		justify-content: space-between;
		align-items: center;
		margin: 0 60rpx;
		height: 112rpx;
		border-bottom: 2rpx solid #e9e9e9;
	}

	.userInfo-title {
		width: 70rpx;
		height: 110rpx;
		line-height: 110rpx;
		font-family: PingFangSC-Regular;
		font-size: 32rpx;
		color: #333;
	}

	.userInfo-content {
		position: relative;
		width: 80%;
		height: 110rpx;
		line-height: 110rpx;
		font-family: PingFangSC-Regular;
		font-size: 32rpx;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
	}

	.born-title {
		width: 140rpx;
		height: 110rpx;
		line-height: 110rpx;
		font-family: PingFangSC-Regular;
		font-size: 32rpx;
		color: #333;
	}

	.userInfo-content-male,
	.userInfo-content-female {
		position: absolute;
		padding-right: 80rpx;
		color: #999;
	}

	.userInfo-content-female {
		margin-left: 170rpx;
	}

	.userInfo-content-icon {
		position: absolute;
		margin-top: 34rpx;
		padding-right: 10rpx;
		width: 40rpx;
		height: 40rpx;
	}

	.userInfo-content-name {
		position: absolute;
		margin-left: 60rpx;
		width: 70%;
		height: 110rpx;
		line-height: 110rpx;
		font-family: PingFangSC-Regular;
		font-size: 32rpx;
	}

	.userInfo-content .name {
		color: #333;
	}

	.userInfo-content .phone {
		color: #333;
	}

	.userInfo-relation {
		border-bottom: 0;
	}

	.separateLine {
		width: 100%;
		height: 8rpx;
		background: #f9f9f9;
	}

	.more-info {
		padding: 40rpx 60rpx;
		display: flex;
		justify-content: space-between;
		align-items: center;
	}

	.more-desc {
		height: 32rpx;
		width: 400rpx;
		line-height: 32rpx;
		font-family: PingFangSC-Regula;
		font-size: 30rpx;
		color: #333;
	}

	.more-guideIcon {
		width: 12rpx;
		height: 32rpx;
		background-repeat: no-repeat;
		background-image: url("https://static.shengri.cn/uploads/xydd/web/birthwall_rightArrow.png");
		background-size: contain;
	}

	.otherInfo {
		margin: 0 60rpx;
		height: 110rpx;
		display: flex;
		justify-content: space-between;
		align-items: center;
	}

	.otherInfo-desc {
		height: 32rpx;
		width: 400rpx;
		line-height: 32rpx;
		font-family: PingFangSC-Regula;
		font-size: 32rpx;
		color: #333;
	}

	.otherInfo-content {
		width: 150rpx;
		height: 32rpx;
		line-height: 32rpx;
		font-family: PingFangSC-Light;
		font-size: 28rpx;
		text-align: right;
		color: #999;
	}

	.otherInfo-guideIcon {
		width: 12rpx;
		height: 32rpx;
		background-repeat: no-repeat;
		background-image: url("https://static.shengri.cn/uploads/xydd/web/birthwall_rightArrow.png");
		background-size: contain;
	}

	.birthBehavior {
		display: flex;
		justify-content: space-between;
		align-items: center;
		margin: 100rpx 60rpx;
		height: 80rpx;
	}

	.birthBehavior-delete {
		width: 306rpx;
		height: 80rpx;
		line-height: 80rpx;
		font-family: PingFangSC-Regular;
		font-size: 32rpx;
		text-align: center;
		color: #333;
		border: 2rpx solid #E9E9E9;
	}

	.birthBehavior-save {
		width: 100%;
		height: 80rpx;
		line-height: 80rpx;
		font-family: PingFangSC-Regular;
		font-size: 32rpx;
		text-align: center;
		color: #ff3939;
		border: 2rpx solid #ff3939;
	}

	.hint-bg {
		position: fixed;
		z-index: 5;
		left: 0;
		top: 0;
		width: 100%;
		height: 100%;
		background: rgba(51, 51, 51, 0.2);
	}

	.hint-main {
		margin: 348rpx 30rpx 0;
		padding-top: 90rpx;
		height: 414rpx;
		background: #fff;
		border-radius: 8rpx;
	}

	.hint-title {
		margin: 0rpx auto 0;
		width: 70%;
		height: 40rpx;
		line-height: 40rpx;
		font-family: PingFangSC-Medium;
		font-size: 40rpx;
		text-align: center;
		color: #333;
	}

	.hint-content {
		margin: 60rpx auto 0;
		width: 70%;
		height: 32rpx;
		line-height: 32rpx;
		font-family: PingFangSC-Regular;
		font-size: 32rpx;
		text-align: center;
		color: #333;
	}

	.hint-close {
		margin: 80rpx auto 0;
		width: 450rpx;
		height: 80rpx;
		line-height: 80rpx;
		font-family: PingFangSC-Regular;
		font-size: 32rpx;
		text-align: center;
		color: #fff;
		background-color: #ff3939;
	}

	.hint-behavior {
		display: flex;
		justify-content: space-between;
		align-items: center;
		margin: 60rpx 40rpx 70rpx;
		height: 80rpx;
	}

	.hint-behavior-cancel,
	.hint-behavior-saveAdd {
		width: 270rpx;
		height: 80rpx;
		line-height: 80rpx;
		font-family: PingFangSC-Regular;
		font-size: 32rpx;
		text-align: center;
		color: #333;
		border: 2rpx solid #333;
		border-radius: 2rpx;
	}

	.hint-behavior-ensure,
	.hint-behavior-saveLook {
		width: 270rpx;
		height: 80rpx;
		line-height: 80rpx;
		font-family: PingFangSC-Regular;
		font-size: 32rpx;
		text-align: center;
		color: #ff3939;
		border: 2rpx solid #ff3939;
		border-radius: 2rpx;
	}

	.hint-title-tag {
		margin: -10rpx auto 0;
		width: 80rpx;
		height: 80rpx;
	}

	.hint-content-save {
		margin: 40rpx auto 0;
		width: 80%;
		height: 40rpx;
		line-height: 40rpx;
		font-family: PingFangSC-Medium;
		font-size: 40rpx;
		text-align: center;
		color: #333;
	}

	.hint-behavior-save {
		display: flex;
		justify-content: space-between;
		align-items: center;
		margin: 80rpx 40rpx 20rpx;
		height: 80rpx;
	}

	.date-bg {
		position: fixed;
		z-index: 5;
		left: 0;
		top: 0;
		width: 100%;
		height: 100%;
		background: rgba(51, 51, 51, 0.2);
	}

	.date-main {
		position: absolute;
		z-index: 5;
		bottom: 0;
		width: 100%;
		height: 600rpx;
	}

	.date-behavior {
		padding: 0 10rpx;
		width: 100%;
		height: 100rpx;
		display: flex;
		justify-content: space-between;
		align-items: center;
		background-color: #e9e9e9;
	}

	.date-behavior-item-calendar,
	.date-behavior-item,
	.date-behavior-item-year {
		margin: 0 20rpx;
		width: 80rpx;
		height: 100rpx;
		line-height: 100rpx;
		font-family: PingFangSC-Regular;
		font-size: 32rpx;
		text-align: center;
		color: #157EFB;
	}

	.date-behavior-item-calendar {
		position: relative;
		margin-top: 20rpx;
		margin-bottom: 20rpx;
		width: 150rpx;
		height: 60rpx;
		border: 2rpx solid #157EFB;
	}

	.date-behavior-item-normal,
	.date-behavior-item-lunar {
		position: absolute;
		width: 76rpx;
		height: 60rpx;
		line-height: 60rpx;
		font-family: PingFangSC-Regular;
		font-size: 28rpx;
		text-align: center;
	}

	.date-behavior-item-lunar {
		margin-left: 75rpx;
	}

	.date-behavior-item-year {
		margin: 0 10rpx;
		width: 50%;
		text-align: left;
	}

	.date-lunar {
		margin: 0 0;
		text-align: left;
	}

	.date-indicator {
		margin-top: 10rpx;
		height: 80rpx;
	}

	.date-content {
		width: 100%;
		height: 500rpx;
		background-color: #fff;
	}

	.date-content-item {
		line-height: 100rpx;
		font-size: 30rpx;
		text-align: center;
	}

	.picker-view {
		position: fixed;
		left: 0;
		bottom: 0;
		background-color: #FFF;
	}

	.confirm-layout {
		bottom: 200px;
		position: fixed;
		background-color: #eee;
		height: 40px;
		width: 100%;
	}

	.picker-layout {
		position: fixed;
		left: 0;
	}

	.confirm-btn {
		position: absolute;
		right: 40rpx;
		ont-size: 16px;
		top: 12px;
		color: blue;
	}

	.addr-item {
		line-height: 40px;
		text-align: center;
		font-size: 30rpx;
	}

	.choose {
		margin-left: 180rpx;
		width: 400rpx;
		min-height: 60rpx;
		text-align: left;
		font-size: 32rpx;
		color: #333;
		margin-top: 18rpx;
		overflow: hidden;
		word-break: keep-all;
		white-space: nowrap;
		text-overflow: ellipsis;
		flex: 1;
	}

	.picker-cover {
		background-color: #000;
		width: 750rpx;
		position: fixed;
		left: 0;
		top: 0;
		z-index: 100;
		opacity: 0.1;
	}
</style>
