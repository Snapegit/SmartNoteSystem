const config = {
    get() {
        return {
            url : process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
            name: process.env.VUE_APP_BASE_API,
			menuList:[
				{
					name: '笔记信息管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'笔记信息',
							url:'/index/bijixinxiList'
						},
					]
				},
			]
        }
    },
    getProjectName(){
        return {
            projectName: "基于springboot的智能笔记的开发与应用"
        } 
    }
}
export default config
