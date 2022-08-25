import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import HomeView from "@/pages/HomeView.vue";
import baseRouters from "./modules/baseRouters";

// 示例路由代码，仅做展示用
const examplesRoutes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "home",
    component: HomeView
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ "@/pages/AboutView.vue")
  }
];

// 异步路由
const asyncRouters: Array<RouteRecordRaw> = [
  ...baseRouters
  // ...componentsRouters,
  // ...othersRouters
];

// 默认路由（常驻路由）
const defaultRouters: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "home",
    component: HomeView
  },
  ...asyncRouters
];

/**
 * 路由配置项
 */
const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes: defaultRouters
});

export default router;
