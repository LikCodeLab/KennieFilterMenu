package com.kennie.library.filtermenu.entity;

import java.util.List;


public abstract class BaseFilterTab<T extends BaseFilterTab> {


    public abstract int getItemId(); // item对应的ID

    public abstract String getItemName(); // item对应的名称

    public abstract int getSelectStatus(); // 选择状态

    public abstract void setSelectStatus(int status); // 设置选择状态


    /**
     * 多选排序标题  例如：面积，朝向，楼龄，装修等
     *
     * @return 多选排序标题
     */
    public String getSortTitle() {
        return null;
    }

    /**
     * 多选排序标题key 对应SortTitle
     *
     * @return 多选排序标题key
     */
    public String getSortKey() {
        return null;
    }

    /**
     * 二级分类数据
     *
     * @return 二级分类数据
     */
    public List<T> getChildList() {
        return null;
    }

    /**
     * 对于Grid样式的是否支持多选
     *
     * @return false 默认 不支持 true 支持多选
     */
    public boolean isCanMulSelect() {
        return false;
    }
}
