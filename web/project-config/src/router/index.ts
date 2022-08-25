import { createRouter, createWebHistory, RouteRecordRaw, useRoute } from "vue-router";
import HomeView from "@/pages/HomeView.vue";
import uniq from "lodash/uniq";

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

// 自动导入modules文件夹下所有ts文件
const modules = require.context("./modules", true, /\.ts$/);
// const modules = import.meta.globEager("./modules/**/*.ts");

const routeModuleList: Array<RouteRecordRaw> = [];

Object.keys(modules).forEach((key) => {
  const mod = modules[key].default || {};
  const modList = Array.isArray(mod) ? [...mod] : [mod];
  routeModuleList.push(...modList);
});

// 动态路由
export const asyncRouterList: Array<RouteRecordRaw> = [...routeModuleList];

// 默认路由（常驻路由）
const defaultRouterList: Array<RouteRecordRaw> = [];

// 所有路由（常驻路由+动态路由）
export const allRoutes = [...defaultRouterList, ...asyncRouterList];

export const getRoutesExpanded = () => {
  const expandedRoutes = [];
  allRoutes.forEach((item) => {
    if (item.meta && item.meta.expanded) {
      expandedRoutes.push(item.path);
    }
    if (item.children && item.children.length > 0) {
      item.children
        .filter(child => child.meta && child.meta.expanded)
        .forEach((child: RouteRecordRaw) => {
          expandedRoutes.push(item.path);
          expandedRoutes.push(`${item.path}/${child.path}`);
        });
    }
  });
  return uniq(expandedRoutes);
};
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
};

/**
 * 路由配置项
 */
const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes: allRoutes,
  scrollBehavior () {
    return {
      el: "#app",
      top: 0,
      behavior: "smooth"
    };
  }
});
export default router;
