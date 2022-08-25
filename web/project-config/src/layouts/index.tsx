import { computed, defineComponent, onBeforeUnmount, onMounted } from "vue";
import { prefix } from "@/config/global";
import LayoutHeader from "./components/Header.vue";
import LayoutSideNav from "./components/SideNav";
import { useSettingStore, usePermissionStore, useTabsRouterStore } from "@/store";
import { storeToRefs } from "pinia";
import { useRoute } from "vue-router";

const name = `${prefix}-base-lyaout`;

export default defineComponent({
  name,
  setup () {
    const route = useRoute();
    const settingStore = useSettingStore();
    const permissionStore = usePermissionStore();
    const tabsRouterStore = useTabsRouterStore();
    const { routers: menuRouters } = storeToRefs(permissionStore);
    const setting = storeToRefs(settingStore);

    const mainLayoutCls = computed(() => [
      {
        "t-layout--with-sider": true
      }
    ]);
    const sideMenu = computed(() => {
      const { layout, splitMenu } = settingStore;
      let newMenuRouters = menuRouters.value;
      if (layout === "mix" && splitMenu) {
        newMenuRouters.forEach((menu) => {
          if (route.path.indexOf(menu.path) === 0) {
            newMenuRouters = menu.children.map((subMenu) => ({ ...subMenu, path: `${menu.path}/${subMenu.path}` }));
          }
        });
      }
      return newMenuRouters;
    });

    const appendNewRoute = () => {
      const { path, query, meta: { title }, name } = route;
      tabsRouterStore.appendTabRouterList({});
    };

    const headerMenu = computed(() => {
      return menuRouters.value;
    });
    const renderSidebar = () => {
      return (
        settingStore.showSidebar && (
          <LayoutSideNav
            showLogo={settingStore.showSidebarLogo}
            layout={settingStore.layout}
            isFixed={settingStore.isSidebarFixed}
            menu={sideMenu.value}
            theme={settingStore.displayMode}
            isCompact={settingStore.isSidebarCompact}
          />
        )
      );
    };
    const renderHeader = () => {
      return (
        <LayoutHeader
          showLogo={settingStore.showHeaderLogo}
          theme={settingStore.displayMode}
          layout={settingStore.layout}
          isFixed={settingStore.isHeaderFixed}
          menu={headerMenu.value}
          isCompact={settingStore.isSidebarCompact}
        />
      );
    };

    onMounted(() => {
      appendNewRoute();
    });
    // 拆分
    // 如果不需要持久化标签页可以注释掉以下的 onMounted 和 onBeforeUnmount 的内容
    onMounted(() => {
      // if (localStorage.getItem("tabRouterList")) getTabRouterListCache();
      // window.addEventListener("beforeunload", setTabRouterListCache);
    });

    onBeforeUnmount(() => {
      window.removeEventListener("beforeunload", setTabRouterListCache);
    });
    return {
      setting,
      mainLayoutCls,
      renderSidebar,
      renderHeader,
      renderContent
    };
  },
  render () {
    const header = this.renderHeader();
    const sidebar = this.renderSidebar();
    const content = this.renderContent();
    return (
      <div>
        <t-layout class={this.mainLayoutCls} key="side">
          <t-aside>{sidebar}</t-aside>
          <t-layout>{[header, content]}</t-layout>
        </t-layout>
        {/* <Setting /> */}
      </div>
    );
  }
});
