package com.wengjianfeng.bingpicture.mvvm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.wengjianfeng.bingpicture.mvvm.data.ImageRepertory;
import com.wengjianfeng.bingpicture.mvvm.entity.Data;
import com.wengjianfeng.bingpicture.mvvm.entity.ImageBean;
import com.wengjianfeng.bingpicture.mvvm.entity.ImagesBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ImageViewModel extends ViewModel {
    public static final String TAG = ImageViewModel.class.getSimpleName();

    private MutableLiveData<Data<ImagesBean>> mImage;
    private ImageRepertory mRepertory;
    private int idx;
    private int n;

    public ImageViewModel() {
        mImage = new MutableLiveData<>();
        mRepertory = new ImageRepertory();
        idx = 0;
    }

    public MutableLiveData<Data<ImagesBean>> getImage() {
        return mImage;
    }

    public void loadImage() {
        mRepertory.getImage("js", idx, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ImageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ImageBean imageBean) {
                        Log.e(TAG, "onNext: ===imageBean:"+imageBean.getImages().get(0).getUrl());
                        mImage.setValue(new Data<ImagesBean>(imageBean.getImages().get(0), null
                        ));
                    }

                    @Override
                    public void onError(Throwable e) {
                        mImage.setValue(new Data<ImagesBean>(
                                null, e.getMessage()
                        ));
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void nextImage() {
        mRepertory.getImage("js", ++idx, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ImageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ImageBean imageBean) {
                        Log.e(TAG, "onNext: ===imageBean:"+imageBean.getImages().get(0).getUrl());
                        mImage.setValue(new Data<ImagesBean>(
                                imageBean.getImages().get(0), null
                        ));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.getMessage());
                        mImage.setValue(new Data<ImagesBean>(
                                null, e.getMessage()
                        ));
                        idx--;
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void previousImage() {
        if (idx <= 0) {
            mImage.setValue(new Data<ImagesBean>(
                    null, "已经是第一个了"
            ));
            return;
        }
        mRepertory.getImage("js", --idx, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ImageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ImageBean imageBean) {
                        Log.e(TAG, "onNext: ===imageBean:"+imageBean.getImages().get(0).getUrl());
                        mImage.setValue(new Data<ImagesBean>(
                                imageBean.getImages().get(0), null
                        ));
                    }

                    @Override
                    public void onError(Throwable e) {
                        mImage.setValue(new Data<ImagesBean>(
                                null, e.getMessage()
                        ));
                        idx++;
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

}