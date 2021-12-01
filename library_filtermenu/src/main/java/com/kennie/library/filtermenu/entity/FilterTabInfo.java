package com.kennie.library.filtermenu.entity;


import java.util.List;


public class FilterTabInfo<T extends BaseFilterTab> {

    private String tabName; // tab名称

    private int popupType;  // PopupWindowTab类型

    private List<T> filterData; // PopupWindow数据


    public FilterTabInfo(String tabName, int popupType, List<T> filterData) {
        this.tabName = tabName;
        this.popupType = popupType;
        this.filterData = filterData;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public int getPopupType() {
        return popupType;
    }

    public void setPopupType(int popupType) {
        this.popupType = popupType;
    }

    public List getFilterData() {
        return filterData;
    }

    public void setFilterData(List<T> filterData) {
        this.filterData = filterData;
    }
}
