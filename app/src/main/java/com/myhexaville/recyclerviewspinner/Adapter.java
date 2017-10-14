package com.myhexaville.recyclerviewspinner;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Holder> {
    private List<Laptop> laptops;
    private Context context;

    public Adapter(Context context, List<Laptop> laptops) {
        this.context = context;
        this.laptops = laptops;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.list_item,
                parent,
                false);

        return new Holder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Laptop laptop = laptops.get(position);
        holder.binding.setLaptop(laptop);
    }

    @Override
    public int getItemCount() {
        return laptops.size();
    }
}
