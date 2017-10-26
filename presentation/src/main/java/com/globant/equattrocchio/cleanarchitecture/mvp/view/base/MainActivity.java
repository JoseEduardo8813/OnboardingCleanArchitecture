package com.globant.equattrocchio.cleanarchitecture.mvp.view.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.globant.equattrocchio.cleanarchitecture.R;
import com.globant.equattrocchio.cleanarchitecture.mvp.presenter.ImagesPresenter;
import com.globant.equattrocchio.cleanarchitecture.mvp.view.ImagesView;
import com.globant.equattrocchio.data.ImagesServicesImpl;
import com.globant.equattrocchio.domain.GetLatestImagesUseCase;

import java.util.Collections;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    private ImagesPresenter presenter;
    private GetLatestImagesUseCase getLatestImagesUseCase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLatestImagesUseCase = new GetLatestImagesUseCase(new ImagesServicesImpl());
        ImagesView view = new ImagesView(this);
        presenter = new ImagesPresenter( view, getLatestImagesUseCase);
        view.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unregister();
    }
}