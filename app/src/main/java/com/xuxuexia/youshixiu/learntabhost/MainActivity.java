package com.xuxuexia.youshixiu.learntabhost;

import android.app.Dialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    private TabHost tabHost;
    private Button buttonTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        buttonTest = (Button) findViewById(R.id.btnTest);
        tabHost = getTabHost();

        addTab();// 添加标签
        // 设置TabHost背景颜色
        tabHost.setBackgroundColor(Color.argb(150, 20, 80, 150));
        // 设置TabHost背景图片资源
       // tabHost.setBackgroundResource(R.mipmap.ic_launcher);
        // 设置当前显示哪一个标签 我的理解就是当你第一次启动程序默认显示那个标签 这里是指定的选项卡的ID从0开始
        tabHost.setCurrentTab(0);
        // 标签切换事件处理，setOnTabChangedListener 注意是标签切换事件不是点击事件，而是从一个标签切换到另外一个标签会触发的事件
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                Dialog dia;
                builder.setTitle("提示");
                builder.setMessage("当前选中了" + tabId + "标签");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dia = builder.create();
                dia.show();
            }
        });
    }

    // 为TabHost添加标签 新建一个newTabSped(new TabSpec) 设置其标签和图标（setIndicator）、设置内容(setContent)
    // TabSpec是TabHost的内部类 TabHost对象的 newTabSpec()方法返回一个TabSpec对象
    // 源码里边是这么写的 public TabSpec newTabSpec(String tag)
    // { return new TabSpec(tag); }
    private void addTab() {
//        tabHost.addTab(tabHost
//                .newTabSpec("tab1")
//                .setIndicator("TAB1")// setIndicator()此方法用来设置标签和图表
//                .setContent(R.id.tab1));
        // 指定内容为一个TextView --->public TabHost.TabSpec setContent(int viewId) 此方法需要一个 viewId 作为参数
        tabHost.addTab(tabHost
                .newTabSpec("tab2")
                .setIndicator("游视秀")
                .setContent(new Intent(this,FirstActivity.class)));

        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("大米")
                .setContent(new Intent(this,SecondActivity.class)));

    }
}
