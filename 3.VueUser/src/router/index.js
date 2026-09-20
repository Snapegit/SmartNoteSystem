import { createRouter, createWebHashHistory } from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'
import login from '../views/pages/login.vue'
import yonghuList from '@/views/pages/yonghu/list'
import yonghuDetail from '@/views/pages/yonghu/formModel'
import yonghuAdd from '@/views/pages/yonghu/formAdd'
import yonghuRegister from '@/views/pages/yonghu/register'
import yonghuCenter from '@/views/pages/yonghu/center'
import bijifenleiList from '@/views/pages/bijifenlei/list'
import bijifenleiDetail from '@/views/pages/bijifenlei/formModel'
import bijifenleiAdd from '@/views/pages/bijifenlei/formAdd'
import bijibiaoqianList from '@/views/pages/bijibiaoqian/list'
import bijibiaoqianDetail from '@/views/pages/bijibiaoqian/formModel'
import bijibiaoqianAdd from '@/views/pages/bijibiaoqian/formAdd'
import bijixinxiList from '@/views/pages/bijixinxi/list'
import bijixinxiDetail from '@/views/pages/bijixinxi/formModel'
import bijixinxiAdd from '@/views/pages/bijixinxi/formAdd'
import storeupList from '@/views/pages/storeup/list'
import menuList from '@/views/pages/menu/list'
import menuDetail from '@/views/pages/menu/formModel'
import menuAdd from '@/views/pages/menu/formAdd'
import discussbijixinxiList from '@/views/pages/discussbijixinxi/list'
import discussbijixinxiDetail from '@/views/pages/discussbijixinxi/formModel'
import discussbijixinxiAdd from '@/views/pages/discussbijixinxi/formAdd'

const routes = [{
		path: '/',
		redirect: '/index/home'
	},
	{
		path: '/index',
		component: index,
		children: [{
			path: 'home',
			component: home
		}
		, {
			path: 'yonghuList',
			component: yonghuList
		}, {
			path: 'yonghuDetail',
			component: yonghuDetail
		}, {
			path: 'yonghuAdd',
			component: yonghuAdd
		}
		, {
			path: 'yonghuCenter',
			component: yonghuCenter
		}
		, {
			path: 'bijifenleiList',
			component: bijifenleiList
		}, {
			path: 'bijifenleiDetail',
			component: bijifenleiDetail
		}, {
			path: 'bijifenleiAdd',
			component: bijifenleiAdd
		}
		, {
			path: 'bijibiaoqianList',
			component: bijibiaoqianList
		}, {
			path: 'bijibiaoqianDetail',
			component: bijibiaoqianDetail
		}, {
			path: 'bijibiaoqianAdd',
			component: bijibiaoqianAdd
		}
		, {
			path: 'bijixinxiList',
			component: bijixinxiList
		}, {
			path: 'bijixinxiDetail',
			component: bijixinxiDetail
		}, {
			path: 'bijixinxiAdd',
			component: bijixinxiAdd
		}
		, {
			path: 'storeupList',
			component: storeupList
		}
		, {
			path: 'menuList',
			component: menuList
		}, {
			path: 'menuDetail',
			component: menuDetail
		}, {
			path: 'menuAdd',
			component: menuAdd
		}
		, {
			path: 'discussbijixinxiList',
			component: discussbijixinxiList
		}, {
			path: 'discussbijixinxiDetail',
			component: discussbijixinxiDetail
		}, {
			path: 'discussbijixinxiAdd',
			component: discussbijixinxiAdd
		}
		]
	},
	{
		path: '/login',
		component: login
	}
	,{
		path: '/yonghuRegister',
		component: yonghuRegister
	}
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router
