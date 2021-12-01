package com.kennie.library.app.filtertabview;


import com.kennie.library.filtermenu.entity.BaseFilterTab;

import java.util.List;


/**
 * 单条选择Entity
 */
public class FilterSelectedEntity extends BaseFilterTab {

    /**
     * 选项ID
     */
    private int tid;
    /**
     * 选项名称
     */
    private String name;
    /**
     * 选择状态
     */
    private int selected;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    @Override
    public String getItemName() {
        return name;
    }

    @Override
    public int getItemId() {
        return tid;
    }

    @Override
    public int getSelectStatus() {
        return selected;
    }

    @Override
    public void setSelectStatus(int status) {
        this.selected = status;
    }

    @Override
    public String getSortTitle() {
        return null;
    }

    @Override
    public List getChildList() {
        return null;
    }

    @Override
    public String getSortKey() {
        return null;
    }


    private int isMulSelect;

    public int getIsMulSelect() {
        return isMulSelect;
    }

    public void setIsMulSelect(int isMulSelect) {
        this.isMulSelect = isMulSelect;
    }

    @Override
    public boolean isCanMulSelect() {
        return isMulSelect == 1;
    }
}
