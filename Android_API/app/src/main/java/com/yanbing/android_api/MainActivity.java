package com.yanbing.android_api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] a={-1,2,4,5,6,7,8,9,100};

        int num =Arithmetic.rank(6,a);
        Log.d("yanbing","num =" +num);
        Log.d("yanbing","string =" +Arithmetic.IntToBinaryString_1(a.length));
        Log.d("yanbing","堆内存大小 =" +Arithmetic.MaxMermory());

    }
}
