package com.kennie.library.app.filtertabview;

import java.util.List;

/**
 * 筛选数据
 */
public class FilterEntity {

    private List<FilterSelectedEntity> date; // 日期

    private List<FilterSelectedEntity> price; // 总价

    private List<FilterSelectedEntity> houseType; // 户型

    private List<FilterMulSelectEntity> mulSelect; // 筛选


    public List<FilterSelectedEntity> getDate() {
        return date;
    }

    public void setDate(List<FilterSelectedEntity> date) {
        this.date = date;
    }

    public List<FilterSelectedEntity> getPrice() {
        return price;
    }

    public void setPrice(List<FilterSelectedEntity> price) {
        this.price = price;
    }

    public List<FilterSelectedEntity> getHouseType() {
        return houseType;
    }

    public void setHouseType(List<FilterSelectedEntity> houseType) {
        this.houseType = houseType;
    }

    public List<FilterMulSelectEntity> getMulSelect() {
        return mulSelect;
    }

    public void setMulSelect(List<FilterMulSelectEntity> mulSelect) {
        this.mulSelect = mulSelect;
    }
}
