package com.wengjianfeng.bingpicture;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Created by wengjianfeng on 2018/2/16.
 */

public class PictureAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public static final String TAG = PictureAdapter.class.getSimpleName();

    public PictureAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        // 加载网络图片
        Logger.d(TAG+"------url:"+item);
        Glide.with(mContext)
                .load(item)
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background))
                .into((ImageView) helper.getView(R.id.imageView_item_picture));


    }
}
