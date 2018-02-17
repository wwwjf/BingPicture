package com.wengjianfeng.bingpicture;

import android.service.notification.StatusBarNotification;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.right_drawer_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.right_drawer_recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.left_drawer_listView)
    ListView mListView;
    @BindView(R.id.drawer)
    DrawerLayout mDrawerLayout;
    private PictureAdapter mPictureAdapter;
    private List<String> mDataList;
    private String pictureListPath = "/v1/blur?d=%s&r=0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mToolbar.setNavigationIcon(R.mipmap.ic_launcher);
//        setSupportActionBar(mToolbar);
        mDataList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String url = AppConstants.BASE_URL + String.format(pictureListPath, i);
            if (i == 3)
//                url="https://bing.ioliu.cn/v1/blur?d=3&w=1054&h=283&r=0";
                Logger.d(TAG + "------url:" + url);
            mDataList.add(url);
        }
        mPictureAdapter = new PictureAdapter(R.layout.item_picture, mDataList);
        mPictureAdapter.openLoadAnimation();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.setAdapter(mPictureAdapter);
        mPictureAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemClick: adapter click");
            }
        });

    }
}
