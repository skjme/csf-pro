<template>
	<view class="content">

		<!-- <image class="logo" src="/static/logo.png"></image> -->

		<view class="text-area">
			<text class="title">{{title}}</text>
		</view>

		<navigator url="../testcloudfunc/testcloudfunc" hover-class="navigator-hover">
			<button type="default">跳转到云函数页面</button>
		</navigator>
		
		<navigator url="../addressbook/addForm?uuid=123456789"  hover-class="navigator-hover">
			<button type="default">addForm</button>
			
		</navigator><navigator url="../addressbook/addressbook" hover-class="navigator-hover">
			<button type="default">跳转到列表</button>
		</navigator>

		<view style="text-align: center;">
			<button size="default" @click="takeLocalPhoto">从相册或照相机选择照片</button>

			<image mode="aspectFit" :src="imagePath"></image>

			<view>
				<text>{{ selectedName}}</text>
			</view>

		</view>

		<!-- <view>
			<button size="default" :disabled="false" hover-start-time=20 @click="goto('baidu.com')">按钮</button>
		</view>

		<view class="">
			<picker mode="date" :value="date" start="2021-09-01" end="2022-09-01" @change="bindDateChange">
				<view class="picker">
					当前选择: {{date}}
				</view>
			</picker>
			<picker mode="time" :value="time" start="00:00" end="23:59" @change="bindTimeChange">
				<view class="picker">
					当前选择: {{time}}
				</view>
			</picker>

		</view>
 -->
		<!-- <view>
			<view class="uni-title uni-common-pl">地区选择器</view>
			<view class="uni-list">
				<view class="uni-list-cell">
					<view class="uni-list-cell-left">
						当前选择
					</view>
					<view class="uni-list-cell-db">
						<picker @change="bindPickerChange" :value="index" :range="array">
							<view class="uni-input">{{array[index]}}</view>
						</picker>
					</view>
				</view>
			</view>
		</view>

 -->
		<!-- <view>
			<template v-if="test">
				<view>test 为 true 时显示</view>
			</template>
			<template v-else>
				<view>test 为 false 时显示</view>
			</template>
		</view> -->

		<!-- <open-data type="userNickName"></open-data>
		<open-data type="userAvatarUrl"></open-data>
		<open-data type="userGender"></open-data>

		<view>
			<template>
				<uni-data-checkbox v-model="value" :localdata="options" multiple></uni-data-checkbox>
			</template>
		</view>
 -->
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello',
				test: true,
				date: '2022-01-05',
				time: '10:37',
				array: ['中国', '美国', '巴西', '日本'],
				index: 0,
				imagePath: "",
				selectedName: ""
			}
		},
		onLoad() {

		},
		methods: {

			// 1 从手机相册或拍照获得一张照片，并显示到页面
			takeLocalPhoto: function() {
				uni.chooseImage({
					count: 1,
					success: (res) => {
						console.log(res)
						this.imagePath = res.tempFilePaths[0];
						console.log(this.imagePath)
						this.image2base64(this.imagePath);
					}
				});
			},
			// 2 图片转base64
			image2base64(imagePath) {
				wx.getFileSystemManager().readFile({
					filePath: imagePath,
					encoding: "base64",
					success: (res) => {
						console.log(res)
						this.imageClassify(res.data)
					}
				})
			},
			//3.调用百度图像识别API来识别图片
			async imageClassify(b64) {

				// 1 access token
				// https://aip.baidubce.com/oauth/2.0/token
				var [err, res] = await uni.request({
					url: 'https://aip.baidubce.com/oauth/2.0/token',
					data: {
						grant_type: 'client_credentials',
						client_id: '7nUmiwr3W0AtvR7gANi3vUr5',
						client_secret: '23uir4CekCTXLGp1rpO5ciiMxWZa0Kaj'
					},
					header: {
						'Content-Type': 'application/x-www-form-urlencoded' //自定义请求头信息
					},
					// success: (res) => {
					// 	console.log(res.data);
					// 	this.text = 'request success';
					// }
				})

				var access_token = res.data.access_token;
				console.log('access_token', access_token)

				// 2 API 图像识别
				// https://aip.baidubce.com/rest/2.0/image-classify/v2/advanced_general
				var [err, res] = await uni.request({
					url: 'https://aip.baidubce.com/rest/2.0/image-classify/v2/advanced_general',
					method: 'POST',
					data: {
						image: b64,
						access_token: access_token
					},
					header: {
						'Content-Type': 'application/x-www-form-urlencoded' //自定义请求头信息
					},
					// success: (res) => {
					// 	this.parseResults(res.result);
					// }
				})
				console.log(res);
				this.parseResults(res.data.result);
				// var res = {"result_num":5,"result":[{"keyword":"拖鞋","score":0.769782,"root":"商品-鞋子"},{"keyword":"洞洞鞋","score":0.608569,"root":"商品-鞋子"},{"keyword":"男士凉鞋","score":0.441261,"root":"商品-鞋子"},{"keyword":"拖鞋/人字拖","score":0.264241,"root":"商品-鞋子"},{"keyword":"高跟鞋","score":0.036473,"root":"商品-鞋子"}],"log_id":1478646374890833082}
				// this.parseResults(res.result);
			},
			//4.展示图像识别的结果
			parseResults(result) {
				this.recResults = result;
				console.log(result);
				let itemlist = [];
				let abs_result_index;
				for (let i = 0; i < result.length; i++) {
					if (result[i].score > .7) {
						abs_result_index = i;
						break;
					}
					itemlist.push(result[i].keyword + "" + result[i].score);
				}

				if (abs_result_index >= 0) {
					this.selectRecResult(abs_result_index);
					return;
				}

				uni.showActionSheet({
					itemList: itemlist,
					success: (res) => {
						console.log(res);
						this.selectRecResult(res.tapIndex);
					}
				})
			},

			//5.使用图片识别结果去查询垃圾所属分类，展示结果
			async selectRecResult(index) {
				this.selectedName = this.recResults[index].keyword;

				console.log(this.selectedName);

				// const searchRes = await this.searchKeyword(this.selectedName);
				// this.searchResults = searchRes;
			},


			bindPickerChange: function(e) {
				console.log('picker发送选择改变，携带值为', e.target.value)
				this.index = e.target.value
			},
			bindDateChange(e) {
				console.log(e.detail);
				this.date = e.detail.value;
			},
			bindTimeChange(e) {
				console.log(e.detail);
				this.time = e.detail.value;
			},
			goto(url) {
				console.log("按钮被点击了，且传入的参数是：" + url)

			}
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>
