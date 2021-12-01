package com.kennie.library.filtermenu.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;

import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.kennie.library.filtermenu.R;
import com.kennie.library.filtermenu.entity.BaseFilterTab;
import com.kennie.library.filtermenu.util.SpUtils;

import java.util.List;


public class ItemSelectAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<BaseFilterTab> mList;
    private boolean isCanMulSelect;

    public ItemSelectAdapter(Context context, List<BaseFilterTab> list, boolean isCanMulSelect) {
        mContext = context;
        mList = list;
        this.isCanMulSelect = isCanMulSelect;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_mul_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        try {
            final BaseFilterTab bean = mList.get(position);
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.mItemNameTv.setText(bean.getItemName());

            // 是否设置“不限”为选中
            boolean isSelectFirst = true;
            for (int i = 0; i < mList.size(); i++) {
                BaseFilterTab entity = mList.get(i);
                if (entity.getSelectStatus() == 1) {
                    isSelectFirst = false;
                    break;
                }
            }

            if (isSelectFirst) {
                mList.get(0).setSelectStatus(1);
            }

            if (bean.getSelectStatus() == 0) {
                GradientDrawable unselectDrawable = new GradientDrawable();
                unselectDrawable.setCornerRadius(R.dimen.dp_24);
                unselectDrawable.setColor(ContextCompat.getColor(mContext, R.color.app_gray1));
                viewHolder.mItemNameTv.setTextColor(ContextCompat.getColor(mContext, R.color.app_default_text));
                viewHolder.mItemNameTv.setBackgroundDrawable(unselectDrawable);
            } else {
                GradientDrawable selectDrawable = new GradientDrawable();
                selectDrawable.setCornerRadius(R.dimen.dp_24);
                selectDrawable.setColor(ContextCompat.getColor(mContext, R.color.app_default_green_primary));
                viewHolder.mItemNameTv.setTextColor(ContextCompat.getColor(mContext, R.color.white));
                viewHolder.mItemNameTv.setBackgroundDrawable(selectDrawable);
            }

            viewHolder.mItemNameTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (isCanMulSelect) {
                        if (position == 0) {
                            // 不限
                            for (int i = 0; i < mList.size(); i++) {
                                mList.get(i).setSelectStatus(0);
                            }
                        } else {
                            mList.get(0).setSelectStatus(0);
                            if (mList.get(position).getSelectStatus() == 0) {
                                mList.get(position).setSelectStatus(1);
                            } else {
                                mList.get(position).setSelectStatus(0);
                            }
                        }
                    } else {
                        for (int i = 0; i < mList.size(); i++) {
                            if (i == position) {
                                if (mList.get(position).getSelectStatus() == 0) {
                                    mList.get(position).setSelectStatus(1);
                                } else {
                                    mList.get(position).setSelectStatus(0);
                                }
                            } else {
                                mList.get(i).setSelectStatus(0);
                            }
                        }
                    }
                    notifyDataSetChanged();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView mItemNameTv;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemNameTv = itemView.findViewById(R.id.tv_item_name);


        }
    }
}
