package com.qianfanyun.recyclerviewdivider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author luys
 * @describe
 * @date 2019/3/7
 * @email samluys@foxmail.com
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    private final int mLayoutResId;
    private final List<T> mList;
    private OnItemClickListener onItemClickListener;


    public BaseAdapter(int layoutResId) {
        this(layoutResId, null);
    }

    public BaseAdapter(int layoutResId, List<T> data) {
        mLayoutResId = layoutResId;
        if (data != null) {
            mList = data;
        } else {
            mList = new ArrayList<>();
        }
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(mLayoutResId, parent, false);
        final BaseViewHolder holder = new BaseViewHolder(parent.getContext(), view);

        if (onItemClickListener != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(v, holder.getLayoutPosition());
                }
            });
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        convert(holder, mList.get(position));
    }

    public void updateList(List<T> list) {
        this.mList.clear();
        this.mList.addAll(list);
    }

    public List<T> getList(){
        return this.mList;
    }
    public T getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    protected abstract void convert(BaseViewHolder helper, T item);


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
