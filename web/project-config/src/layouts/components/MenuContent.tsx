import { computed, defineComponent, h, PropType } from "vue";
import { getActive } from "@/router";
import { MenuRoute } from "@/types/interface";
import { prefix } from "@/config/global";

/**
 * 获取菜单列表
 * @desc 获取菜单列表数组，返回有序、可见的菜单列表
 * @param list
 * @param basepath
 */
const getMenuList = (list: MenuRoute[], basepath?: string): MenuRoute[] => {
  if (!list) return [];
  // 遍历list排序
  list.sort((a, b) => {
    return (a.meta?.orderNo || 0) - (b.meta?.orderNo || 0);
  });
  return list.map((item) => {
    const path = basepath ? `${basepath}/${item.path}` : item.path;
    return {
      path,
      title: item.meta?.title,
      icon: item.meta?.icon || "",
      children: getMenuList(item.children, path),
      meta: item.meta,
      redirect: item.redirect
    };
  }).filter((item) => item.meta && item.meta.hidden !== true);
};
/**
 * 渲染icon菜单
 * @param item
 */
const renderIcon = (item: any) => {
  if (typeof item.icon === "string") return () => item.icon && <t-icon name={item.icon}/>;

  if (item.icon && typeof item.icon.render === "function") {
    return () => h(item.icon.render(), { class: "t-icon" });
  }
  return () => "";
};

/**
 * 获取激活的item的path
 * @param active
 * @param item
 */
const getPath = (active: string, item: MenuRoute) => {
  if (active.startsWith(item.path)) {
    return active;
  }
  return item.meta?.single ? item.redirect : item.path;
};

/**
 * 使用active
 * @param active
 * @param list
 */
const useRenderNav = (active: string, list: Array<MenuRoute>) => {
  return list.map((item: MenuRoute) => {
    // 如果item没有children 或者直meta属性是single
    if (!item.children || !item.children.length || item.meta?.single) {
      const href = item.path.match(/(http|https):\/\/([\w.]+\/?)\S*/);
      if (href) {
        return (
          <t-menu-item href={href?.[0]} name={item.path} value={getPath(active, item)} icon={renderIcon(item)}/>
        );
      }
      // 若匹配不到
      return (
        <t-menu-item name={item.path} value={getPath(active, item)} to={item.path} icon={renderIcon(item)}/>
      );
    }
    return (
      <t-menu-item name={item.path} value={getPath(active, item)} to={item.path}
                   icon={renderIcon(item)}>{item.title}</t-menu-item>
    );
  });
};
export default defineComponent({
  props: {
    navData: {
      type: Array as PropType<MenuRoute[]>,
      default: () => []
    }
  },
  setup (props) {
    // 激活的菜单节点
    const active = computed(() => getActive());
    // 菜单列表
    const list = computed(() => {
      const { navData } = props;
      return getMenuList(navData);
    });
    return {
      prefix,
      active,
      list,
      useRenderNav
    };
  },
  render () {
    return <div>{this.useRenderNav(this.active, this.list)}</div>;
  }
});
