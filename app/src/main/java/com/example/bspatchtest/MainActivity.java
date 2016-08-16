package com.example.bspatchtest;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.valleypioneerbspatch.Bspatch;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String rootPath = Environment.getExternalStorageDirectory().getPath();
   /* public static final String rootPath = "/data/app";*/
    public static final String TAG = "MainActivity";
    public static final String success = "升级成功！";
    public static final String failure = "升级失败！";
    public static final String NOT_EXIST = "文件夹不存在！";

    private Button button;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                incrementalUpgrade();
                break;
            default:
        }
    }

    public void incrementalUpgrade() {
        File file = new File(rootPath + "/iReaderBspatchUpgrade");

        if (file.exists()) {
            Bspatch bspatch = new Bspatch();
            Log.d(TAG, "run to here1");
            if (bspatch.applyPatch(file.getPath() + "/old.apk", file.getPath() + "/new.apk", file.getPath() + "/ireader.patch") == 0) {
                Toast.makeText(this, success, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, failure, Toast.LENGTH_SHORT).show();
            }

            showText();
        } else {
            Toast.makeText(this, NOT_EXIST, Toast.LENGTH_SHORT).show();
        }
    }

    public void showText(){
        text = (TextView)findViewById(R.id.text);
        text.setVisibility(View.VISIBLE);
    }





}
