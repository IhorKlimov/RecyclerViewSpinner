package com.myhexaville.recyclerviewspinner;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.myhexaville.recyclerviewspinner.databinding.ListItemBinding;

public class Holder extends RecyclerView.ViewHolder{
    public ListItemBinding binding;

    public Holder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }
}
