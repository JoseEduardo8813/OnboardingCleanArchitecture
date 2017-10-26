package com.globant.equattrocchio.cleanarchitecture.mvp.view.base;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.globant.equattrocchio.cleanarchitecture.R;
import com.globant.equattrocchio.data.response.Image;
import com.globant.equattrocchio.domain.domian.ImageDomain;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemImageAdapter extends RecyclerView.Adapter<ItemImageAdapter.ImageViewHolder> {
    private List<ImageDomain> dataSet;
    private Context context;

    public ItemImageAdapter(List<ImageDomain> dataSet, Context context) {
        this.context = context;
        this.dataSet = dataSet;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);

        ImageViewHolder vh = new ImageViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        String url = dataSet.get(position).getUrl();
        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void updateDataSet(List<ImageDomain> images) {
        this.dataSet = images;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image) ImageView imageView;

        public ImageViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
