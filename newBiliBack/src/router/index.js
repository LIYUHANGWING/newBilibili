import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from "@/components/main";
import Home from "@/components/admin/home";
import Video from "@/components/admin/video";

Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    redirect: "/main"
  },
  {
    path:"/main",
    component: Main,
    children:[
      {path:"/home", component: Home},
      {path:"/video", component: Video}
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
