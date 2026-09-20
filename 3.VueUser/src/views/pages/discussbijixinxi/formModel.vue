<template>
	<div class="app-contain" :style='{"padding":"0px 0","margin":"20px auto 40px","alignItems":"flex-start","borderRadius":"0px","flexWrap":"wrap","background":"none","display":"flex","width":"86%","position":"relative","justifyContent":"space-between"}'>
		<div class="bread_view">
			<el-breadcrumb separator=">" class="breadcrumb">
				<el-breadcrumb-item class="first_breadcrumb" :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item class="second_breadcrumb" v-for="(item,index) in breadList" :key="index">{{item.name}}</el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		<div class="back_view">
			<el-button class="back_btn" @click="backClick" type="primary">返回</el-button>
		</div>
		<div class="detail_view">
			<div class="swiper_view">
				<mySwiper :data="bannerList" :type="3"
				:loop="false"
				:navigation="false"
				:pagination="true"
				:paginationType="1"
				:scrollbar="false"
				:slidesPerView="1"
				:spaceBetween="20"
				:autoHeight="false"
				:centeredSlides="false"
				:freeMode="false"
				:effectType="5"
				:direction="horizontal"
				:autoplay="true"
				:slidesPerColumn="1">
				<template #default="scope">
					<img :style='{"border":"1px solid #ddd","width":"100%","objectFit":"contain","height":"480px"}' :src="scope.row?$config.url + scope.row:''">
				</template>
			</mySwiper>
			</div>
			
			<div class="info_view">
				<div class="title_view">
					<div class="detail_title">
					</div>
				</div>
				<div class="info_item">
					<div class="info_label">价格</div>
					<div class="info_price"><span>￥</span>{{detail.price}}</div>
				</div>
				<div class="info_item" v-if="detail.jf">
					<div class="info_label">积分</div>
					<div class="info_price">{{detail.jf}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">关联表id</div>
					<div  class="info_text" >{{detail.refid}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">用户名</div>
					<div  class="info_text" >{{detail.nickname}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">评论内容</div>
					<div  class="info_text" >{{detail.content}}</div>
				</div>
				<div class="info_item">
					<div class="info_label">回复内容</div>
					<div  class="info_text" >{{detail.reply}}</div>
				</div>
				<div class="btn_view">
					<el-input-number class="inputNumber" v-model="buyNumber" :min="1" ></el-input-number>
					<el-button class="addCart_btn"  type="primary" @click="addCart">加入购物车</el-button>
				</div>
				<div class="btn_view">
					<el-button class="edit_btn" v-if="centerType&&btnAuth('discussbijixinxi','修改')" type="primary" @click="editClick">修改</el-button>
					<el-button class="del_btn" v-if="centerType&&btnAuth('discussbijixinxi','删除')" type="danger" @click="delClick">删除</el-button>
				</div>
			</div>
		</div>
		<el-tabs type="border-card" v-model="activeName" class="tabs_view">
			<el-tab-pane label="评论" name="commentActive">
				<div class="my_comment_view">
					<el-form ref="commentFormRef" :model="commentForm" class="my_comment_form"
						:rules="commentRules">
						<el-form-item prop="content">
							<el-input class="comment_inp" v-model="commentForm.content" type="textarea"
								placeholder="请输入评论内容"></el-input>
						</el-form-item>
					</el-form>
					<div class="comment_btn">
						<el-button class="add_btn" type="primary" @click="commentSave">立即评论</el-button>
						<el-button class="reset_btn" @click="resetForm">重置</el-button>
					</div>
				</div>
				<div class="comment_list">
					<div class="comment" v-for="(item,index) in commentList" :key="index">
						<div class="comment_top">
							<div class="comment_user">
								<div class="comment_user_img">
									<img :src="item.avatarurl?$config.url + item.avatarurl:'../../../assets/avatar.png'" alt="">
								</div>
								<div class="comment_user_info">
									{{item.nickname}}
								</div>
							</div>
							<div class="comment_time">{{item.addtime}}</div>
						</div>
						<div class="comment_bottom">
							<div class="comment_content">{{item.content}}</div>
							<div class="comment_reply" v-if="item.reply">
								回复：{{item.reply}}
							</div>
						</div>
					</div>
				</div>
				<el-pagination
					background 
					:layout="layouts.join(',')"
					:total="commentTotal" 
					:page-size="commentQuery.limit"
					prev-text="上一页"
					next-text="下一页"
					:hide-on-single-page="false"
					:style='{"border":"0px solid #eee","padding":"4px 0","margin":"10px 0 20px","whiteSpace":"nowrap","color":"#333","textAlign":"center","flexWrap":"wrap","background":"none","display":"flex","width":"100%","fontWeight":"500","justifyContent":"center"}'
					@size-change="commentSizeChange"
					@current-change="commentCurrentChange" 
					@prev-click="commentPrevClick"
					@next-click="commentNextClick"  />
			</el-tab-pane>
		</el-tabs>
	</div>
</template>
<script setup>
	import axios from 'axios'
	import {
		ref,
		getCurrentInstance,
		watch,
		onUnmounted,
		onMounted,
		nextTick,
		computed
	} from 'vue';
	import {
		ElMessageBox
	} from 'element-plus'
	import {
		useRoute,
		useRouter
	} from 'vue-router';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const route = useRoute()
	const router = useRouter()
	//基础信息
	const tableName = 'discussbijixinxi'
	const formName = '笔记信息评论表'
	//基础信息
	const breadList = ref([{
		name: formName
	}])
	//权限验证
	const btnAuth = (e,a)=>{
		if(centerType.value){
			return context?.$toolUtil.isBackAuth(e,a)
		}else{
			return context?.$toolUtil.isAuth(e,a)
		}
	}
	//查看权限验证
	const btnFrontAuth = (e,a)=>{
		if(centerType.value){
			return context?.$toolUtil.isBackAuth(e,a)
		}else{
			return context?.$toolUtil.isFrontAuth(e,a)
		}
	}
	// 返回
	const backClick = () =>{
		history.back()
	}
	// 轮播图
	const bannerList = ref([])
	// 详情
	const title = ref('')
	const detail = ref({})
    const activeName = ref('first')
	const getDetail = () => {
		context?.$http({
			url: `${tableName}/detail/${route.query.id}`,
			method: 'get'
		}).then(res => {
			detail.value = res.data.data
			getInCartList();
		})
	}
	// 下载文件
	const downClick = (file) => {
		if(!file){
			context?.$toolUtil.message('文件不存在','error')
		}
		let arr = file.replace(new RegExp('file/', "g"), "")
		axios.get((location.href.split(context?.$config.name).length>1 ? location.href.split(context?.$config.name)[0] :'') + context?.$config.name + '/file/download?fileName=' + arr, {
			headers: {
				token: context?.$toolUtil.storageGet('frontToken')
			},
			responseType: "blob"
		}).then(({
			data
		}) => {
			const binaryData = [];
			binaryData.push(data);
			const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
				type: 'application/pdf;chartset=UTF-8'
			}))
			const a = document.createElement('a')
			a.href = objectUrl
			a.download = arr
			// a.click()
			// 下面这个写法兼容火狐
			a.dispatchEvent(new MouseEvent('click', {
				bubbles: true,
				cancelable: true,
				view: window
			}))
			window.URL.revokeObjectURL(data)
		})
	}
	// 判断是否从个人中心跳转
	const centerType = ref(false)
	const init = () => {
		if(route.query.centerType){
			centerType.value = true
		}
		getDetail()
		// 评论
		getCommentList()
	}
	//评论
	const commentForm = ref({
		content: '',
		refid: route.query.id,
		userid: context?.$toolUtil.storageGet('userid'),
		nickname: context?.$toolUtil.storageGet('frontName'),
		avatarurl: context?.$toolUtil.storageGet('headportrait') ? context?.$toolUtil.storageGet('headportrait') : ''
	})
	const commentRules = ref({
		content: [{
			required: true,
			message: '请输入',
			trigger: 'blur'
		}, ]
	})
	const commentQuery = ref({
		page: 1,
		limit: 10,
		refid: route.query.id
	})
	const layouts = ref(["prev","pager","next","total","jumper"])
	const commentList = ref([])
	const commentTotal = ref(0)
	const commentFormRef = ref(null)
	const commentSizeChange = (size) =>{
		commentQuery.value.limit = size
		getCommentList()
	}
	const commentCurrentChange = (page) =>{
		commentQuery.value.page = page
		getCommentList()
	}
	const commentPrevClick = () =>{
		commentQuery.value.page = commentQuery.value.page - 1
		getCommentList()
	}
	const commentNextClick = () =>{
		commentQuery.value.page = commentQuery.value.page + 1
		getCommentList()
	}
	const getCommentList = () => {
		context?.$http({
			url: `discuss${tableName}/list`,
			params: commentQuery.value,
			method: 'get'
		}).then(res => {
			commentList.value = res.data.data.list
			commentTotal.value = res.data.data.total
	
		})
	}
	//提交评论
	const commentSave = () => {
		let sensitiveWords = "";
		let sensitiveWordsArr = [];
		if(sensitiveWords) {
		    sensitiveWordsArr = sensitiveWords.split(",");
		}
		for(var i=0; i<sensitiveWordsArr.length; i++){
		    //全局替换
		    var reg = new RegExp(sensitiveWordsArr[i],"g");
		    //判断内容中是否包括敏感词
		    if (commentForm.value.content.indexOf(sensitiveWordsArr[i]) > -1) {
		        // 将敏感词替换为 **
		        commentForm.value.content = commentForm.value.content.replace(reg,"**");
		    }
		}
		commentFormRef.value.validate((valid) => {
			if (valid) {
				context?.$http({
					url: `discuss${tableName}/add`,
					method: 'post',
					data: commentForm.value
				}).then(res => {
					context?.$toolUtil.message('评论成功', 'success', () => {
						resetForm()
						getCommentList()
					})
				})
			}
		})
	}
	const resetForm = () => {
		commentFormRef.value.resetFields()
	}
	//查找是否已添加购物车
	const isInCart = ref(false)
	const getInCartList = () => {
		context?.$http({url:'cart/list',method:'get',params:{userid:context?.$toolUtil.storageGet('userid'),tablename:tableName,goodid: detail.value.id}}).then(res=>{
			if(res.data.data.list.length){
				isInCart.value = true
			}else{
				isInCart.value = false
			}
		})
	}
	const cartForm = ref({
		userid:context?.$toolUtil.storageGet('userid')
	})
	const addCart = () => {
		if(isInCart.value){
			context?.$toolUtil.message('该商品已在购物车，请前往购买','error')
			return false
		}
		cartForm.value.buynumber = buyNumber.value
		cartForm.value.goodid = detail.value.id
		cartForm.value.goodname = title.value
		cartForm.value.tablename = tableName
		cartForm.value.picture = bannerList.value[0]
        cartForm.value.price = detail.value.price;
		context?.$http({
			url: 'cart/save',
			method: 'post',
			data:cartForm.value
		}).then(res=>{
			context?.$toolUtil.message('添加成功','success')
			getInCartList()
		})
	}
	//修改
	const editClick = () => {
		router.push(`/index/${tableName}Add?id=${detail.value.id}&&type=edit`)
	}
	//删除
	const delClick = () => {
		ElMessageBox.confirm(`是否删除此${formName}？`, '提示', {
			confirmButtonText: '是',
			cancelButtonText: '否',
			type: 'warning',
		}).then(()=>{
			context?.$http({
				url: `${tableName}/delete`,
				method: 'post',
				data: [detail.value.id]
			}).then(res=>{
				context?.$toolUtil.message('删除成功','success',()=>{
					history.back()
				})
			})
			
		})
	}
	onMounted(()=>{
		init()
	})
</script>
<style lang="scss" scoped>
	// 返回盒子
	.back_view {
		border-radius: 0px;
		padding: 0 20px;
		margin: 0 auto 20px;
		background: none;
		display: block;
		width: 100%;
		text-align: right;
		// 返回按钮
		.back_btn {
			border: 1px solid #ddd;
			cursor: pointer;
			border-radius: 0px;
			padding: 0 30px;
			outline: none;
			color: #666;
			background: #f9f9f9;
			width: auto;
			font-size: 14px;
			height: 32px;
		}
		// 返回按钮-悬浮
		.back_btn:hover {
		}
	}
	// 面包屑盒子
	.bread_view {
		border-radius: 0px;
		padding: 12px 20px;
		margin: 0px auto;
		background: none;
		width: 100%;
		border-color: #eee;
		border-width: 0 0 0px;
		position: relative;
		border-style: solid;
		:deep(.breadcrumb) {
			font-size: 14px;
			line-height: 1;
			.el-breadcrumb__separator {
				margin: 0 9px;
				color: #999;
				font-weight: 500;
			}
			.first_breadcrumb {
				.el-breadcrumb__inner {
					color: #333;
					display: inline-block;
				}
			}
			.second_breadcrumb {
				.el-breadcrumb__inner {
					color: #999;
					display: inline-block;
				}
			}
		}
	}
	
	.detail_view{
		border-radius: 0;
		padding: 20px 0;
		background: none;
		display: flex;
		width: 100%;
		border-color: #ddd;
		border-width: 0px;
		justify-content: space-between;
		position: relative;
		border-style: solid;
		flex-wrap: wrap;
		// 轮播图
		.swiper_view {
			border: 0px solid #ddd;
			padding: 0px;
			margin: 0 auto;
			background: none;
			width: 480px;
			float: left;
			height: auto;
			order: 0;
		}
		
		// 文字区
		.info_view {
			border: 1px solid #ddd;
			padding: 30px 4% 10px;
			margin: 0 0 0px;
			background: url(http://clfile.zggen.cn/20231113/974a5cd5eb9840c9b1a4576231567b5c.png);
			width: calc(100% - 520px);
			box-sizing: border-box;
			float: right;
			order: 3;
		
			.title_view {
				border: 0px solid #ddd;
				padding: 0 20px;
				margin: 0 0 20px;
				background: #fff;
				display: flex;
				width: 100%;
				border-width: 1px 1px 4px;
				line-height: 40px;
				justify-content: space-between;
				align-items: center;
		
				.detail_title {
					color: #333;
					font-weight: 600;
					font-size: 16px;
				}
			}
		
			.info_item {
					border-radius: 0px;
					padding: 0 0 10px;
					margin: 0 0 10px;
					background: none;
					display: flex;
					border-color: #ddd;
					border-width: 0 0 1px;
					align-items: center;
					border-style: dashed;
		
				.info_label {
					margin: 0 12px 0 0;
					color: #666;
					font-weight: 500;
					width: auto;
				}
				.info_text {
				}
			}
			.btn_view {
				padding: 0;
				margin: 20px 0 20px;
				display: block;
				width: 100%;
				flex-wrap: wrap;
				// 数量输入框
				.inputNumber {
					margin: 0 5px 10px 0;
					display: block;
					width: 150px;
					line-height: 32px;
					position: relative;
					:deep(.el-input-number__decrease) {
						cursor: pointer;
						z-index: 1;
						display: flex;
						border-color: #DCDFE6;
						border-radius: 4px 0 0 4px;
						top: 1px;
						left: 1px;
						background: #f5f5f5;
						width: 40px;
						justify-content: center;
						border-width: 0 1px 0 0;
						align-items: center;
						position: absolute;
						border-style: solid;
						text-align: center;
						height: 30px;
						i {
							color: #666;
							font-size: 14px;
						}
					}
					:deep(.el-input-number__increase) {
						cursor: pointer;
						z-index: 1;
						display: flex;
						border-color: #DCDFE6;
						right: 1px;
						border-radius: 0 4px 4px 0;
						top: 1px;
						background: #f5f5f5;
						width: 40px;
						justify-content: center;
						border-width: 0 0 0 1px;
						align-items: center;
						position: absolute;
						border-style: solid;
						text-align: center;
						height: 30px;
						i {
							color: #666;
							font-size: 14px;
						}
					}
					:deep(.el-input) {
						.el-input__wrapper {
							border: 1px solid #DCDFE6;
							border-radius: 4px;
							padding: 0 20px;
							outline: none;
							color: #666;
							background: #FFF;
							display: inline-block;
							width: 100%;
							font-size: 14px;
							line-height: 32px;
							text-align: center;
							height: 32px;
						}
					}
				}
				// 加入购物车-按钮
				.addCart_btn {
					border: 1px solid #113961;
					padding: 0 10px;
					color: #113961;
					background: #fff;
					display: inline-block;
					line-height: 32px;
					transition: all 0.3s;
					height: 32px;
				}
				// 悬浮
				.addCart_btn:hover {
					transform: scale(0.9) translate3d(0px, -3px, 0px);
				}
				// 修改-按钮
				.edit_btn {
					border: 1px solid #2da065;
					padding: 0 10px;
					color: #2da065;
					background: #fff;
					line-height: 32px;
					transition: all 0.3s;
					height: 32px;
				}
				// 悬浮
				.edit_btn:hover {
					transform: scale(0.9) translate3d(0px, -3px, 0px);
				}
				// 删除-按钮
				.del_btn {
					border: 1px solid #f68b8b;
					padding: 0 10px;
					color: #f68b8b;
					background: #fff;
					line-height: 32px;
					transition: all 0.3s;
					height: 32px;
				}
				// 悬浮
				.del_btn:hover {
					transform: scale(0.9) translate3d(0px, -3px, 0px);
				}
			}
		}
	}
	

	//底部盒子
	.tabs_view {
		border: 1px solid #ddd;
		border-radius: 0px;
		padding: 20px 0;
		box-shadow: none;
		margin: 0px auto;
		background: url(http://clfile.zggen.cn/20231113/974a5cd5eb9840c9b1a4576231567b5c.png);
		width: 100%;
		:deep(.el-tabs__header) {
			background: transparent;
			border: none;
		}
		// 头部
		:deep(.el-tabs__nav-scroll) {
			border-radius: 0;
			padding: 2px 20px 0;
			margin: 0;
			background: none;
			display: flex;
			border-color: #ddd;
			border-width: 0px 0px 0px;
			border-style: solid;
			flex-wrap: wrap;
			height: 50px;
			.el-tabs__nav {
				.el-tabs__item {
					border: 1px solid #ddd;
					padding: 0 20px;
					margin: 0 10px 0 0;
					color: #333;
					font-weight: 500;
					display: inline-block;
					font-size: 14px;
					line-height: 48px;
					transition: all 0.3s;
					border-radius: 0px;
					background: #fff;
					border-width: 1px 1px 3px;
					position: relative;
					list-style: none;
					text-align: center;
					min-width: 140px;
					height: 48px;
				}
				.el-tabs__item:hover {
					border: 1px solid #113961;
					color: #113961;
					background: #fff;
					border-width: 1px 1px 3px;
				}
				.is-active {
					border: 1px solid #113961;
					border-radius: 0px;
					padding: 0 20px;
					margin: 0 10px 0 0;
					color: #113961;
					background: #fff;
					border-width: 1px 1px 3px;
					line-height: 48px;
					text-align: center;
					min-width: 140px;
					height: 48px;
				}
			}
		}
		// 内容区
		:deep(.el-tabs__content) {
			border-radius: 4px;
			padding: 20px;
			margin: 20px;
			color: #666;
			background: none;
			font-size: 14px;
			border-color: #eee;
			border-width: 0px;
			border-style: solid;
		}
		//评论
		//我的评论
		.my_comment_view {
			border: 0px solid #eee;
			border-radius: 4px;
			box-shadow: none;
			padding: 0px;
			margin: 0px;
			background: none;
			width: 100%;
		
			.my_comment_form {
				border: 0px solid #eee;
				border-radius: 0px;
				padding: 0px;
				box-shadow: none;
				background: #fff;
				width: 100%;
				box-sizing: border-box;
				// 输入框
				:deep(.el-textarea__inner) {
					border: 1px solid #eee;
					border-radius: 0;
					padding: 12px;
					box-shadow: none;
					color: #333;
					width: 100%;
					font-size: 14px;
					min-height: 120px;
				}
			}
			// 按钮盒子
			.comment_btn {
				margin: 20px 0 0;
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				// 评论按钮
				.add_btn {
					border: none;
					border-radius: 0px;
					padding: 0 30px;
					margin: 0 20px 0 0;
					color: #fff;
					background: #113961;
					line-height: 40px;
					transition: all 0.3s;
					height: 40px;
				}
				// 悬浮
				.add_btn:hover {
					transform: rotate(0deg) scale(0.9) skew(0deg, 0deg) translate3d(0px, -10px, 0px);
				}
				// 重置按钮
				.reset_btn {
					border: 1px solid #113961;
					border-radius: 0px;
					padding: 0 30px;
					color: #113961;
					background: #fff;
					line-height: 40px;
					transition: all 0.3s;
					min-width: 120px;
					height: 40px;
				}
				// 悬浮
				.reset_btn:hover {
					transform: rotate(0deg) scale(0.9) skew(0deg, 0deg) translate3d(0px, -10px, 0px);
				}
			}
		}
		
		//评论列表
		.comment_list {
			border: 0px solid #eee;
			border-radius: 0px;
			padding: 0px;
			margin: 30px auto;
			background: none;
			display: flex;
			width: 100%;
			justify-content: space-between;
			flex-wrap: wrap;
		
			.comment {
				border: 0px solid #2da06530;
				border-radius: 4px;
				padding: 0 0 10px;
				margin: 0 0 20px;
				background: none;
				width: 48%;
				box-sizing: border-box;
				.comment_top {
					border-radius: 0px;
					padding: 0 0 0px;
					background: #fff;
					display: flex;
					width: 100%;
					font-size: 14px;
					border-color: #ddd;
					border-width: 1px 1px 3px;
					justify-content: space-between;
					align-items: center;
					border-style: solid;
		
					.comment_user {
						border-radius: 4px;
						padding: 4px 30px 4px 10px;
						display: block;
						align-items: center;
						.comment_user_img {
							margin: 0 10px 0 0;
							font-size: 0;
							float: left;
		
							img {
								border-radius: 50%;
								width: 40px;
								height: 40px;
							}
						}
						.comment_user_info {
							color: #333;
							font-weight: 600;
							font-size: 14px;
							line-height: 40px;
							float: left;
						}
					}
					.comment_time{
						border: 0px solid #eee;
						border-radius: 4px;
						padding: 0px 20px;
						color: #999;
						font-size: 14px;
						float: right;
					}
				}
		
				.comment_bottom {
					border: 0px solid #eee;
					border-radius: 4px;
					padding: 0px 10px;
					margin: 10px 0 0;
					flex-direction: column;
					display: flex;
					width: 100%;
					align-items: flex-start;
					.comment_content {
						color: #666;
						font-weight: 600;
						font-size: 14px;
					}
					.comment_reply {
						padding: 10px 0 0;
						flex-direction: column;
						color: #999;
						text-indent: 2rem;
						display: flex;
						width: 100%;
						font-size: 14px;
						align-items: flex-start;
					}
				}
			}
		}
		// 分页器
		.el-pagination {
			// 总页码
			:deep(.el-pagination__total) {
				margin: 0 10px 0;
				color: #666;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
			// 上一页
			:deep(.btn-prev) {
				border: 1px solid #ddd;
				border-radius: 2px;
				padding: 0 4px;
				margin: 0 2px;
				color: #666;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 28px;
				height: 28px;
			}
			// 下一页
			:deep(.btn-next) {
				border: 1px solid #ddd;
				border-radius: 2px;
				padding: 0 4px;
				margin: 0 2px;
				color: #666;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 14px;
				line-height: 28px;
				min-width: 28px;
				height: 28px;
			}
			// 上一页禁用
			:deep(.btn-prev:disabled) {
				border: 1px solid #ddd;
				cursor: not-allowed;
				padding: 0 4px;
				margin: 0 2px;
				color: #C0C4CC;
				display: inline-block;
				vertical-align: top;
				font-size: 14px;
				line-height: 28px;
				border-radius: 2px;
				background: none;
				min-width: 28px;
				height: 28px;
			}
			// 下一页禁用
			:deep(.btn-next:disabled) {
				border: 1px solid #ddd;
				cursor: not-allowed;
				padding: 0 4px;
				margin: 0 2px;
				color: #C0C4CC;
				display: inline-block;
				vertical-align: top;
				font-size: 14px;
				line-height: 28px;
				border-radius: 2px;
				background: none;
				min-width: 28px;
				height: 28px;
			}
			// 页码
			:deep(.el-pager) {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
				// 数字
				.number {
					cursor: pointer;
					padding: 0 4px;
					margin: 0 5px;
					color: #666;
					display: inline-block;
					vertical-align: top;
					font-size: 13px;
					line-height: 28px;
					border-radius: 2px;
					background: #f4f4f5;
					text-align: center;
					min-width: 28px;
					height: 28px;
				}
				// 数字悬浮
				.number:hover {
					cursor: pointer;
					padding: 0 4px;
					margin: 0 5px;
					color: #fff;
					display: inline-block;
					vertical-align: top;
					font-size: 13px;
					line-height: 28px;
					border-radius: 2px;
					background: #113961;
					text-align: center;
					min-width: 28px;
					height: 28px;
				}
				// 选中
				.number.is-active {
					cursor: default;
					padding: 0 4px;
					margin: 0 5px;
					color: #fff;
					display: inline-block;
					vertical-align: top;
					font-size: 13px;
					line-height: 28px;
					border-radius: 2px;
					background: #113961;
					text-align: center;
					min-width: 28px;
					height: 28px;
				}
			}
			// sizes
			:deep(.el-pagination__sizes) {
				box-shadow: none;
				margin: 0 0 0 5px;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
				.el-select {
					border: 0px solid #DCDFE6;
					cursor: pointer;
					padding: 0;
					color: #606266;
					display: inline-block;
					font-size: 13px;
					line-height: 28px;
					border-radius: 2px;
					outline: 0;
					background: #f4f4f5;
					width: 100%;
					text-align: center;
					height: 28px;
				//去掉默认样式
				.select-trigger{
					height: 100%;
					.el-input{
						height: 100%;
						.el-input__wrapper{
							border: none;
							box-shadow: none;
							background: none;
							border-radius: 0;
							height: 100%;
							padding: 0;
						}
						.is-focus {
							box-shadow: none !important;
						}
					}
				}
				}
			}
			// 跳页
			:deep(.el-pagination__jump) {
				margin: 0 0 0 24px;
				color: #606266;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
				// 输入框
				.el-input {
					border: 1px solid #ddd;
					cursor: pointer;
					padding: 0 3px;
					margin: 0 6px;
					color: #606266;
					display: inline-block;
					font-size: 14px;
					line-height: 28px;
					border-radius: 3px;
					outline: 0;
					background: #fff;
					width: 38px;
					text-align: center;
					height: 28px;
					//去掉默认样式
					.el-input__wrapper{
						border: none;
						box-shadow: none;
						background: none;
						border-radius: 0;
						height: 100%;
						padding: 0;
					}
					.is-focus {
						box-shadow: none !important;
					}
				}
			}
		}
	}
	


</style>