package com.mvp.expediademo.ui.thingstodo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mvp.expediademo.R;

public class ThingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView title;
    public ImageView countryPhoto;

    public ThingViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        title = (TextView) itemView.findViewById(R.id.title_tv);
        countryPhoto = (ImageView) itemView.findViewById(R.id.thing_photo_iv);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}

