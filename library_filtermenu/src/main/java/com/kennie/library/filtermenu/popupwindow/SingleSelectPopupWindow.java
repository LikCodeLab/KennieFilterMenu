package com.kennie.library.filtermenu.popupwindow;

import android.content.Context;
import android.graphics.Rect;

import android.view.LayoutInflater;
import android.view.View;


import java.util.List;

import static android.view.View.MeasureSpec.AT_MOST;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kennie.library.filtermenu.entity.FilterResultBean;
import com.kennie.library.filtermenu.R;
import com.kennie.library.filtermenu.adapter.PopupSingleAdapter;
import com.kennie.library.filtermenu.entity.BaseFilterTab;
import com.kennie.library.filtermenu.core.BasePopupWindow;
import com.kennie.library.filtermenu.listener.OnFilterToViewListener;
import com.kennie.library.filtermenu.util.Utils;

/**
 * 竖直单选样式
 */
public class SingleSelectPopupWindow extends BasePopupWindow {

    private RecyclerView mContentRv;
    private PopupSingleAdapter mAdapter;

    public SingleSelectPopupWindow(Context context, List<BaseFilterTab> data, int filterType, int position, OnFilterToViewListener onFilterToViewListener) {
        super(context, data, filterType, position, onFilterToViewListener);
    }

    @Override
    public View initView() {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.popup_single_select, null, false);
        mContentRv = rootView.findViewById(R.id.rv_content);
        mAdapter = new PopupSingleAdapter(getContext(), getData());
        final int maxHeight = Utils.dp2px(getContext(), R.dimen.dp_270);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()) {
            @Override
            public void setMeasuredDimension(Rect childrenBounds, int wSpec, int hSpec) {
                super.setMeasuredDimension(childrenBounds, wSpec, View.MeasureSpec.makeMeasureSpec(maxHeight, AT_MOST));
            }
        };
        mContentRv.setLayoutManager(linearLayoutManager);
        mContentRv.setAdapter(mAdapter);

        View v_outside = rootView.findViewById(R.id.v_outside);
        v_outside.setOnClickListener(view -> {
            if (isShowing()) {
                dismiss();
            }
        });
        return rootView;
    }

    @Override
    public void initSelectData() {
        mAdapter.setOnItemClickListener(position -> {
            int itemId = getData().get(position).getItemId();
            String itemName = getData().get(position).getItemName();
            FilterResultBean resultBean = new FilterResultBean();
            resultBean.setPopupIndex(getPosition());
            resultBean.setPopupType(getFilterType());
            resultBean.setItemId(itemId);
            resultBean.setName(itemName);
            getOnFilterToViewListener().onFilterToView(resultBean);
            dismiss();
        });
    }

    @Override
    public void refreshData() {

    }
}
