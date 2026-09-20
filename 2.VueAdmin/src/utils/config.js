const config = {
    get() {
        return {
            url : process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
            name: process.env.VUE_APP_BASE_API,
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/cl9362465/front/index.html'
        }
    },
    getProjectName(){
        return {
            projectName: "基于springboot的智能笔记的开发与应用"
        } 
    }
}
export default config
