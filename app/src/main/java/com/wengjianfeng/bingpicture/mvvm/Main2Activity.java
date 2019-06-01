package com.wengjianfeng.bingpicture.mvvm;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.wengjianfeng.bingpicture.R;
import com.wengjianfeng.bingpicture.databinding.ActivityMain2Binding;
import com.wengjianfeng.bingpicture.mvvm.entity.Data;
import com.wengjianfeng.bingpicture.mvvm.entity.ImagesBean;

import io.reactivex.annotations.Nullable;


public class Main2Activity extends AppCompatActivity {

    private ActivityMain2Binding mBinding;
    private ImageViewModel mViewModel;
    private ProgressDialog mProgressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        mViewModel = ViewModelProviders.of(this,
                new ViewModelProvider.AndroidViewModelFactory(getApplication())
        ).get(ImageViewModel.class);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("加载中");

        mViewModel.getImage().observe(this, new Observer<Data<ImagesBean>>() {
            @Override
            public void onChanged(@Nullable Data<ImagesBean> imagesBeanData) {
                if (imagesBeanData.getErrorMsg() != null) {
                    Toast.makeText(Main2Activity.this, imagesBeanData.getErrorMsg(), Toast.LENGTH_SHORT).show();
                    mProgressDialog.dismiss();
                    return;
                }
                mBinding.setImageBean(imagesBeanData.getData());
                setTitle(imagesBeanData.getData().getCopyright());
                mProgressDialog.dismiss();
            }
        });

        mBinding.setPresenter(new Presenter());

        mProgressDialog.show();
        mViewModel.loadImage();
    }

    public class Presenter {

        public void onClick(View view) {
            mProgressDialog.show();
            switch (view.getId()) {
                case R.id.btn_load:
                    mViewModel.loadImage();
                    break;
                case R.id.btn_previous:
                    mViewModel.previousImage();
                    break;
                case R.id.btn_next:
                    mViewModel.nextImage();
                    break;
                default:
                    break;
            }
        }

    }
}
