package com.zouyingjun.samonkey.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.rv_mainactivity_rv)
    private RecyclerView rv;
    private ArrayList<String> data;
    private HomeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiData();
        initView();


    }

    private void initView() {
        //设置LayoutParams
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HomeAdapter();
        rv.setAdapter(adapter);
        //设置动画
//        rv.setAnimation();
        //设置边距
//        rv.addItemDecoration();
        //设置监听
    }

    private void intiData() {
        data = new ArrayList<>();
        for (int i = 'a'; i < 'Z'; i++) {
            data.add(i+"");
        }
    }
    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new MyViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.inflate_item,null));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            //用于绑定数据
            holder.tv.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            @InjectView(R.id.tv_item_show)
            TextView tv;
            public MyViewHolder(View itemView) {
                super(itemView);
                ButterKnife.inject(this,itemView);
            }
        }
    }
}
