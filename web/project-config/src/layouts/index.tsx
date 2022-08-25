import { computed, defineComponent } from "vue";
import { prefix } from "@/config/global";
import LayoutHeader from "./components/Header.vue";
import { useSettingStore } from "@/store";
import { storeToRefs } from "pinia";

const name = `${prefix}-base-lyaout`;

export default defineComponent({
  name,
  setup () {
    const settingStore = useSettingStore();
    // const { routers: menuRouters } = storeToRefs(permissionStore);
    const setting = storeToRefs(settingStore);

    const mainLayoutCls = computed(() => [
      {
        "t-layout--with-sider": true
      }
    ]);

    const headerMenu = computed(() => {
      return menuRouters.value;
    });
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
