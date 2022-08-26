import { createRouter, createWebHistory, RouteRecordRaw, useRoute } from "vue-router";
import uniq from "lodash/uniq";
import baseRouters from "@/router/modules/baseRouters";

// 动态路由
export const asyncRouterList: Array<RouteRecordRaw> = [
  ...baseRouters
];

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
  routes: allRoutes
});
export default router;
