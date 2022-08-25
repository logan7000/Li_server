// eslint-disable-next-line semi
import { createApp } from "vue";
import App from "./App.vue";
import TDesign from "tdesign-vue-next";

import "./registerServiceWorker";
import router from "./router";
import store from "./store";

// 项目启动入口
const app = createApp(App);
// 引入tDeisgn
app.use(TDesign);
app.use(store);
app.use(router);
app.mount("#app");
