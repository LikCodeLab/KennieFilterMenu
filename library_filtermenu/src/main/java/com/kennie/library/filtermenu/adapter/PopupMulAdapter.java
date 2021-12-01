package com.kennie.library.filtermenu.adapter;

import android.content.Context;

import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.kennie.library.filtermenu.R;
import com.kennie.library.filtermenu.entity.BaseFilterTab;
import com.kennie.library.filtermenu.util.SpUtils;

import java.util.List;


public class PopupMulAdapter extends RecyclerView.Adapter {

    private Context mContext;

    private List<BaseFilterTab> mList;

    public PopupMulAdapter(Context context, List<BaseFilterTab> list) {
        mContext = context;
        mList = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_mul_select, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;

        BaseFilterTab bean = mList.get(position);
        if (SpUtils.getInstance(mContext).getTextStyle() == 1) {
            TextPaint textPaint = viewHolder.tv_classify_name.getPaint();
            textPaint.setFakeBoldText(true);
        }
        viewHolder.tv_classify_name.setText(bean.getSortTitle());

        final ItemSelectAdapter adapter = new ItemSelectAdapter(mContext, bean.getChildList(), bean.isCanMulSelect());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, SpUtils.getInstance(mContext).getColumnNum());
        viewHolder.rv_select.setLayoutManager(gridLayoutManager);
        viewHolder.rv_select.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_classify_name;
        RecyclerView rv_select;

        public ViewHolder(View itemView) {
            super(itemView);
            rv_select = itemView.findViewById(R.id.rv_select);
            tv_classify_name = itemView.findViewById(R.id.tv_classify_name);
        }
    }
}
