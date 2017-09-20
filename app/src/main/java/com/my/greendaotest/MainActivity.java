package com.my.greendaotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bt_add, bt_delete, bt_update, bt_query;
    private ListView lv_content;
    private ShopListAdapter adapter;
    private List<UserBean> shops;
    private static int i = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_add = (Button) findViewById(R.id.bt_add);
        bt_delete = (Button) findViewById(R.id.bt_delete);
        bt_update = (Button) findViewById(R.id.bt_update);
        bt_query = (Button) findViewById(R.id.bt_query);
        lv_content = (ListView) findViewById(R.id.lv_content);
        bt_add.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_query.setOnClickListener(this);

      queryDate();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add:
                addDate();
                break;
            case R.id.bt_delete:
                deleteDate();
                break;
            case R.id.bt_update:
                updateDate();
                break;
            case R.id.bt_query:
                queryDate();
                break;
        }
    }

    private void deleteDate() {
        LoveDao.deleteLove(shops.get(0).getId());

        queryDate();
    }

    private void queryDate() {
        shops = new ArrayList<>();
        shops = LoveDao.queryLove();
        adapter = new ShopListAdapter(this, shops);
        lv_content.setAdapter(adapter);
    }

    private void addDate() {
        UserBean shop = new UserBean();
        shop.setType(UserBean.TYPE_LOVE);
        shop.setText("20");
        shop.setName("奥特曼 3个包邮" + i++);
        LoveDao.insertLove(shop);
        queryDate();
    }

    private void updateDate() {
        UserBean shop = shops.get(0);
        shop.setName("我是修改后的名字");
        LoveDao.updateLove(shop);

        queryDate();
    }
}
