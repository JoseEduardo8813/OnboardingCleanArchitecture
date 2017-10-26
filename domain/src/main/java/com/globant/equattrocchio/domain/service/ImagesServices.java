package com.globant.equattrocchio.domain.service;


import com.globant.equattrocchio.domain.domian.ImageDomain;

import java.util.List;

import io.reactivex.Observer;

public interface ImagesServices {

    void getLatestImages(Observer<List<ImageDomain>> observer);
}
