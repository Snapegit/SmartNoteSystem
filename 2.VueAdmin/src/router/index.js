	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import bijibiaoqian from '@/views/bijibiaoqian/list'
	import bijixinxi from '@/views/bijixinxi/list'
	import discussbijixinxi from '@/views/discussbijixinxi/list'
	import yonghu from '@/views/yonghu/list'
	import storeup from '@/views/storeup/list'
	import config from '@/views/config/list'
	import bijifenlei from '@/views/bijifenlei/list'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页Home',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/bijibiaoqian',
			name: '笔记标签',
			component: bijibiaoqian
		}
		,{
			path: '/bijixinxi',
			name: '笔记信息',
			component: bijixinxi
		}
		,{
			path: '/discussbijixinxi',
			name: '笔记信息评论',
			component: discussbijixinxi
		}
		,{
			path: '/yonghu',
			name: '用户',
			component: yonghu
		}
		,{
			path: '/storeup',
			name: '我的收藏',
			component: storeup
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		,{
			path: '/bijifenlei',
			name: '笔记分类',
			component: bijifenlei
		}
		]
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
