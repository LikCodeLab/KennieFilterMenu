package com.kennie.library.filtermenu.popupwindow;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.kennie.library.filtermenu.entity.FilterResultBean;
import com.kennie.library.filtermenu.FilterTabView;
import com.kennie.library.filtermenu.R;
import com.kennie.library.filtermenu.adapter.AreaChildAdapter;
import com.kennie.library.filtermenu.adapter.AreaParentAdapter;
import com.kennie.library.filtermenu.entity.BaseFilterTab;
import com.kennie.library.filtermenu.core.BasePopupWindow;
import com.kennie.library.filtermenu.listener.OnAdapterRefreshListener;
import com.kennie.library.filtermenu.listener.OnFilterToViewListener;

import java.util.List;

/**
 * 区域联动筛选Popupwindow
 */
public class AreaSelectPopupWindow extends BasePopupWindow implements OnAdapterRefreshListener {


    private RecyclerView rv_parent;
    private RecyclerView rv_child;
    private AreaParentAdapter mParentAdapter;
    private AreaChildAdapter mChildAdapter;
    /**
     * 一级数据
     */
    private List<BaseFilterTab> mParentList;
    /**
     * 当前点击的一级分类数据
     */
    private BaseFilterTab mCurrentClickParentBean;
    /**
     * 当前点击的一级Position
     */
    private int mCurrentClickParentPosition;


    public AreaSelectPopupWindow(Context context, List data, int filterType, int position, OnFilterToViewListener onFilterToViewListener, FilterTabView view) {
        super(context, data, filterType, position, onFilterToViewListener);
        view.setOnAdapterRefreshListener(this);
    }

    @Override
    public View initView() {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.popup_area_select, null, false);
        rv_parent = rootView.findViewById(R.id.rv_parent);
        mParentList = getData();
        Handler mHandler = new Handler() {
            @Override
            public void dispatchMessage(Message msg) {
                if (msg.what == 1) {
                    int position = (int) msg.obj;
                    if (position != -1) {
                        BaseFilterTab clickParentBean = mParentList.get(position);
                        if (clickParentBean.getChildList() != null && clickParentBean.getChildList().size() > 0) {
                            mChildAdapter.addData(clickParentBean.getChildList());
                        }
                    }
                }
            }
        };

        // 获取默认显示的值
        if (mParentList != null && mParentList.size() > 0) {
            int size = mParentList.size();
            for (int i = 0; i < size; i++) {
                BaseFilterTab bean = mParentList.get(i);
                if (bean.getSelectStatus() == 1 && bean.getItemId() != -1) {
                    mCurrentClickParentBean = bean;
                    mCurrentClickParentPosition = i;
                    break;
                }
            }
        }

        mParentAdapter = new AreaParentAdapter(getContext(), mParentList, mHandler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv_parent.setLayoutManager(linearLayoutManager);
        rv_parent.setAdapter(mParentAdapter);

        rv_child = rootView.findViewById(R.id.rv_child);
        mChildAdapter = new AreaChildAdapter(getContext());
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        rv_child.setLayoutManager(linearLayoutManager1);
        rv_child.setAdapter(mChildAdapter);


        return rootView;
    }

    @Override
    public void initSelectData() {
        mParentAdapter.setOnItemClickListener(new AreaParentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                try {
                    mCurrentClickParentBean = mParentList.get(position);
                    mCurrentClickParentPosition = position;
                    List<BaseFilterTab> childList = mCurrentClickParentBean.getChildList();
                    if (childList != null && childList.size() > 0) {
                        mChildAdapter.addData(childList);
                    } else {
                        mChildAdapter.cleanData();
                    }

                    // -1 即为点击“不限”
                    if (mCurrentClickParentBean.getItemId() == -1) {
                        FilterResultBean resultBean = new FilterResultBean();
                        resultBean.setPopupType(getFilterType());
                        resultBean.setPopupIndex(getPosition());
                        getOnFilterToViewListener().onFilterToView(resultBean);
                        dismiss();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mChildAdapter.setOnItemClickListener(new AreaChildAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                try {
                    if (mCurrentClickParentBean != null) {

                        // 点击之前需要清除其他一级分类下选择的二级分类
                        int size = mParentList.size();
                        for (int i = 0; i < size; i++) {
                            if (i != mCurrentClickParentPosition) {
                                BaseFilterTab bean = mParentList.get(i);
                                List<BaseFilterTab> childList = bean.getChildList();
                                if (childList != null && childList.size() > 0) {
                                    int childSize = childList.size();
                                    for (int j = 0; j < childSize; j++) {
                                        BaseFilterTab childBean = childList.get(j);
                                        childBean.setSelectStatus(0);
                                    }
                                }
                            }
                        }


                        // 二级数据
                        List<BaseFilterTab> childList = mCurrentClickParentBean.getChildList();
                        BaseFilterTab childBean = childList.get(position);

                        FilterResultBean resultBean = new FilterResultBean();
                        resultBean.setItemId(mCurrentClickParentBean.getItemId());
                        resultBean.setPopupType(getFilterType());
                        resultBean.setChildId(childBean.getItemId());
                        resultBean.setPopupIndex(getPosition());
                        if (childBean.getItemId() == -1) {
                            resultBean.setName(mCurrentClickParentBean.getItemName());
                        } else {
                            resultBean.setName(childBean.getItemName());
                        }
                        getOnFilterToViewListener().onFilterToView(resultBean);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dismiss();
            }
        });
    }

    @Override
    public void onRefresh(BaseFilterTab selectBean) {
        mCurrentClickParentBean = selectBean;
        mParentAdapter.notifyDataSetChanged();
    }

    @Override
    public void refreshData() {

    }
}
