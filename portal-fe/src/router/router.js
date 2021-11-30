import Vue from 'vue'
import Router from 'vue-router'
import Login from "../components/login/Login";
import Test from "../components/test";
import Index from "@/components/index/Index";
import Home from "@/components/home/Home";
import SystemMenu from "@/components/system/SystemMenu";
import Department from "@/components/system/Department";
import Employee from "@/components/system/user/User";
import Position from "@/components/system/Position";
import Role from "@/components/system/Role";
import Menu from "@/components/system/Menu";

Vue.use(Router)

// 解决重复点菜单报错问题
const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}

export default new Router({
    routes: [
        {path: '/', redirect: '/login'},
        {path: '/login', name: 'login', component: Login},
        {path: '/test', name: 'test', component: Test},
        {
            path: '/portal', name: 'index', component: Index,redirect:{name: 'home'}, children: [
                {path: 'home', name: 'home', component: Home},
                {
                    path: 'system', name: 'system', redirect:{name: 'employee'}, component: SystemMenu, children: [
                        {path: 'department', name: 'department', component: Department},
                        {path: 'employee', name: 'employee', component: Employee},
                        {path: 'position', name: 'position', component: Position},
                        {path: 'role', name: 'role', component: Role},
                        {path: 'menu', name: 'menu', component: Menu}
                    ]
                },
            ]
        },
    ]
})
