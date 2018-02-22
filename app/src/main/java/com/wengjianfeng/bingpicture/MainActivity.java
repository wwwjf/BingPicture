package com.wengjianfeng.bingpicture;

import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
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
    @BindView(R.id.left_drawer_navigationView)
    NavigationView mNavigationView;
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
//        setSupportActionBar(mToolbar);

        mDataList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String url = AppConstants.BASE_URL + String.format(pictureListPath, i);
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
        //设置DrawerLayout
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

    }
}
