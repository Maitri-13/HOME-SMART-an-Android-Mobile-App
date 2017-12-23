package com.example.maitrichattopadhyay.lowpower;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        final String[] newText = intent.getStringArrayExtra("json");
        TextView textView2 = (TextView) findViewById(R.id.textView3);

        for (String s : newText)
            Log.i("new text " , s);
        ListView logs = (ListView) findViewById(R.id.logs);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, newText);
        logs.setAdapter(arrayAdapter);

        logs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), newText[i], Toast.LENGTH_SHORT).show();

            }
        });

    }
}
