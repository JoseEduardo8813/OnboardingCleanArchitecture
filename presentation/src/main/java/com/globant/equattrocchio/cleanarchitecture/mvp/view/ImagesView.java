package com.globant.equattrocchio.cleanarchitecture.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.globant.equattrocchio.cleanarchitecture.R;
import com.globant.equattrocchio.cleanarchitecture.mvp.view.base.ItemImageAdapter;
import com.globant.equattrocchio.cleanarchitecture.util.bus.RxBus;
import com.globant.equattrocchio.cleanarchitecture.util.bus.observers.CallServiceButtonObserver;
import com.globant.equattrocchio.domain.domian.ImageDomain;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImagesView extends ActivityView {

    @BindView(R.id.recycler_view_image_list) RecyclerView imagesRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ItemImageAdapter imagesAdapter;

    public ImagesView(AppCompatActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public void showImages(List<ImageDomain> images) {
        imagesAdapter.updateDataSet(images);
        imagesAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.btn_call_service)
    public void callServiceBtnPressed() {
        RxBus.post(new CallServiceButtonObserver.CallServiceButtonPressed());
    }

    public void showError() {
        Toast.makeText(getContext(), R.string.connection_error, Toast.LENGTH_LONG).show();
    }

    public void onCreate() {
        imagesRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        imagesRecyclerView.setLayoutManager(layoutManager);
        imagesAdapter = new ItemImageAdapter(Collections.EMPTY_LIST, getContext());
        imagesRecyclerView.setAdapter(imagesAdapter);
    }
}
