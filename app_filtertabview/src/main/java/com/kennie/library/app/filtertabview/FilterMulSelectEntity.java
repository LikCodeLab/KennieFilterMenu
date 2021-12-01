package com.kennie.library.app.filtertabview;

import com.google.gson.annotations.SerializedName;
import com.kennie.library.filtermenu.entity.BaseFilterTab;

import java.util.List;


/**
 * 筛选多选Entity
 */
public class FilterMulSelectEntity extends BaseFilterTab {

    /**
     * 分类名称
     */
    @SerializedName("sortname")
    private String sortName;
    /**
     * 分类Key
     */
    @SerializedName("sortkey")
    private String sortKey;
    /**
     * 分类数据
     */
    private List<FilterSelectedEntity> sortdata;

    private int isCan;

    public int getIsCan() {
        return isCan;
    }

    public void setIsCan(int isCan) {
        this.isCan = isCan;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }


    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public List<FilterSelectedEntity> getSortdata() {
        return sortdata;
    }

    public void setSortdata(List<FilterSelectedEntity> sortdata) {
        this.sortdata = sortdata;
    }

    @Override
    public String getItemName() {
        return null;
    }

    @Override
    public int getItemId() {
        return 0;
    }

    @Override
    public int getSelectStatus() {
        return 0;
    }

    @Override
    public void setSelectStatus(int status) {

    }

    @Override
    public String getSortTitle() {
        return sortName;
    }

    @Override
    public List getChildList() {
        return sortdata;
    }

    @Override
    public String getSortKey() {
        return sortKey;
    }

    @Override
    public boolean isCanMulSelect() {
        return isCan == 1;
    }
}
