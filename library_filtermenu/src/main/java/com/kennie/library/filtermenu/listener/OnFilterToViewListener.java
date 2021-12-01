package com.kennie.library.filtermenu.listener;


import com.kennie.library.filtermenu.FilterResultBean;

import java.util.List;


public interface OnFilterToViewListener {

    /**
     * 筛选监听
     * @param resultBean
     */
    void onFilterToView(FilterResultBean resultBean);

    /**
     * 筛选集合监听
     * @param resultBean
     */
    void onFilterListToView(List<FilterResultBean> resultBean);

}
