import { createRouter, createWebHistory, RouteRecordRaw, useRoute } from "vue-router";
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
  ...asyncRouters
];

/**
 * 路由配置项
 */
const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes: defaultRouters
});

/**
 * 获取当前焦点的路由
 * @param maxLevel
 */
export const getActive = (maxLevel = 3): string => {
  const route = useRoute();
  if (!route.path) return "";
  // 当前获取到焦点的过滤器
  const activeFilter = (item: string, index: number) => index <= maxLevel && index > 0;
  return route.path.split("/").filter(activeFilter).map((item: string) => `/${item}`).join("");
  return "";
};
export default router;
