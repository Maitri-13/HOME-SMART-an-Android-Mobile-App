package com.example.maitrichattopadhyay.lowpower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final ImageView logo = (ImageView) findViewById(R.id.logo);
        logo.setImageDrawable(getResources().getDrawable(R.drawable.logo));
    }
}
