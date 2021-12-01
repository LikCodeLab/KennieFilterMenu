package com.kennie.library.filtermenu.core;

import android.content.Context;
import android.widget.PopupWindow;


import com.kennie.library.filtermenu.FilterTabView;
import com.kennie.library.filtermenu.config.FilterTabType;
import com.kennie.library.filtermenu.entity.BaseFilterTab;
import com.kennie.library.filtermenu.listener.OnFilterToViewListener;
import com.kennie.library.filtermenu.popupwindow.GridSelectPopupWindow;
import com.kennie.library.filtermenu.popupwindow.MulSelectPopupwindow;
import com.kennie.library.filtermenu.popupwindow.PriceSelectPopupWindow;
import com.kennie.library.filtermenu.popupwindow.SingleSelectPopupWindow;

import java.util.List;


public class PopupEntityLoaderImp implements IPopupLoader<BaseFilterTab> {


    @Override
    public PopupWindow getPopupEntity(Context context, List<BaseFilterTab> data, int filterType, int position, OnFilterToViewListener onFilterToViewListener, FilterTabView view) {

        PopupWindow popupWindow = null;

        switch (filterType) {
            case FilterTabType.TYPE_SINGLE:
                popupWindow = new SingleSelectPopupWindow(context, data, filterType, position, onFilterToViewListener);
                break;
            case FilterTabType.TYPE_MUL:
                popupWindow = new MulSelectPopupwindow(context, data, filterType, position, onFilterToViewListener);
                break;
            case FilterTabType.TYPE_SINGLE_GIRD:
                popupWindow = new GridSelectPopupWindow(context, data, filterType, position, onFilterToViewListener);
                break;
            case FilterTabType.FILTER_TYPE_PRICE:
                popupWindow = new PriceSelectPopupWindow(context, data, filterType, position, onFilterToViewListener);
                break;
            default:
                break;
        }

        return popupWindow;
    }
}
