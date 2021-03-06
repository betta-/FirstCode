package com.example.administrator.mapleone.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.administrator.mapleone.MyApplication;
import com.example.administrator.mapleone.R;
import com.example.administrator.mapleone.utils.Myshow;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button, button2, button3, button4, button5, button6, button7, button8, button9;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFind();
    }

    private void initFind() {
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.bt4);
        button5 = (Button) findViewById(R.id.bt5);
        button6 = (Button) findViewById(R.id.bt6);
        button7 = (Button) findViewById(R.id.bt7);
        button8 = (Button) findViewById(R.id.bt8);
        button9 = (Button) findViewById(R.id.bt9);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                startActivitys(MyRecyclerViewActivity.class);
                Myshow.ts(this, "MyRecyclerViewActivity.class");
                break;
            case R.id.button2:
                startActivitys(MyShareActivity.class);
                Myshow.ts(this, "MyShareActivity.class");
                break;
            case R.id.button3:
                startActivitys(MyDataBaseActivity.class);
                Myshow.ts(this, "MyDataBaseActivity.class");
                break;
            case R.id.bt4:
                startActivitys(MyPermissionActivity.class);
                Myshow.ts(this, "MyPermissionActivity.class");
                break;
            case R.id.bt5:
                startActivitys(MyRunnableActivity.class);
                Myshow.ts(this, "MyRunnableActivity.class");
                break;
            case R.id.bt6:
                startActivitys(MyServiceActivity.class);
                Myshow.ts(MyApplication.getContext(), "全局context");
                break;
            case R.id.bt7:
                startActivitys(MyChangeActivity.class);
                Myshow.ts(MyApplication.getContext(), "MyChangeActivity.class");
                break;
            case R.id.bt8:
                startActivitys(MyLongClickActivity.class);
                Myshow.ts(MyApplication.getContext(), "MyLongClickActivity.class");
                break;
            case R.id.bt9:
                startActivitys(MyLongClickImpActivity.class);
                Myshow.ts(MyApplication.getContext(), "MyLongClickImpActivity.class");
                break;

        }
    }

    private void startActivitys(Class<?> cls) {
        Intent intent = new Intent(MainActivity.this, cls);
        startActivity(intent);
    }

}
