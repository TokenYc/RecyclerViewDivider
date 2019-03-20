package com.qianfanyun.recyclerviewdivider;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author luys
 * @edit yc
 * @describe
 * @date 2019/3/7
 * @email samluys@foxmail.com
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    private final Context mContext;
    private final SparseArray<View> mViews;

    private View mItemView;
    public BaseViewHolder(Context context, @NonNull View itemView) {
        super(itemView);

        mContext = context;
        mItemView = itemView;
        mViews = new SparseArray<>();
    }

    public <T extends View> T findViewById(int resId) {

        View view = mViews.get(resId);
        if (view == null) {
            view = mItemView.findViewById(resId);
            mViews.put(resId, view);
        }

        return (T) view;
    }

    public BaseViewHolder setText(int textViewId, CharSequence value) {
        TextView view = findViewById(textViewId);
        view.setText(value);
        return this;
    }

    public BaseViewHolder setVisible(int viewId, boolean isVisible) {
        View view = findViewById(viewId);
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);

        return this;
    }
}
