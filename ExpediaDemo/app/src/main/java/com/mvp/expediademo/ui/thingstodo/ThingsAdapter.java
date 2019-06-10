package com.mvp.expediademo.ui.thingstodo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvp.expediademo.R;
import com.mvp.expediademo.http.thingstodo.model.ThingItem;

import java.util.List;


public class ThingsAdapter extends RecyclerView.Adapter<ThingViewHolder> {

    private List<ThingItem> itemList;
    private Context context;

    public ThingsAdapter(Context context, List<ThingItem> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public ThingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        ThingViewHolder viewHolder = new ThingViewHolder(layoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ThingViewHolder holder, int position) {
        holder.title.setText(itemList.get(position).getTitle());
//        holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}

