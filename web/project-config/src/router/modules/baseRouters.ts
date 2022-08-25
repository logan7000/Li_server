import { DashboardIcon } from "tdesign-icons-vue-next";

// import Layout from "@/layouts/index.vue";
import BlankLayout from "@/layouts/blank.vue";

export default [
  {
    path: "/base",
    component: BlankLayout,
    redirect: "/base/hello",
    name: "base",
    meta: {
      title: "基础",
      icon: DashboardIcon
    },
    children: [
      {
        path: "hello",
        name: "Hello",
        component: () => import("@/pages/HomeView.vue"),
        meta: { title: "基本设置" }
      }
    ]
  }
];
