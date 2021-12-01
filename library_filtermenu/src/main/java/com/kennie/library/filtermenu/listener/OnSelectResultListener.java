package com.kennie.library.filtermenu.listener;


import com.kennie.library.filtermenu.FilterResultBean;

import java.util.List;


public interface OnSelectResultListener {

    void onSelectResult(FilterResultBean resultBean);

    void onSelectResultList(List<FilterResultBean> resultBeans);
}
