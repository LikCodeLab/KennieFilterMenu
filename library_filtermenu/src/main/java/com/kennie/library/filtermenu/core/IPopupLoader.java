package com.kennie.library.filtermenu.core;

import android.content.Context;
import android.widget.PopupWindow;


import com.kennie.library.filtermenu.FilterTabView;
import com.kennie.library.filtermenu.entity.BaseFilterTab;
import com.kennie.library.filtermenu.listener.OnFilterToViewListener;

import java.util.List;


public interface IPopupLoader<T extends BaseFilterTab> {

    PopupWindow getPopupEntity(Context context, List<T> data, int filterType, int position, OnFilterToViewListener onFilterToViewListener, FilterTabView view);
}
