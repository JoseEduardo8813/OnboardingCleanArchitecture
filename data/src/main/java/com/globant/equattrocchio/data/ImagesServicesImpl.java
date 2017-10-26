package com.globant.equattrocchio.data;

import com.globant.equattrocchio.data.response.Result;
import com.globant.equattrocchio.data.service.api.SplashbaseApi;
import com.globant.equattrocchio.domain.domian.ImageDomain;
import com.globant.equattrocchio.domain.service.ImagesServices;

import java.util.List;

import io.reactivex.Observer;
import mappers.ImageMapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImagesServicesImpl implements ImagesServices {

    private static final String URL = "http://splashbase.co/";

    @Override
    public void getLatestImages(final Observer<List<ImageDomain>> observer) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(URL).
                addConverterFactory(GsonConverterFactory.create())
                .build();

        SplashbaseApi api = retrofit.create(SplashbaseApi.class);

        Call<Result> call = api.getImages();

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                observer.onNext(ImageMapper.imageToDomainImage(response.body().getImages()));
                observer.onComplete();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                observer.onError(t);
                observer.onComplete();
            }
        });


    }
}
