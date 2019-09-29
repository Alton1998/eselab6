package com.example.alton.eselab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t=(TextView) findViewById(R.id.textView2);
        Bundle extras=getIntent().getExtras();
        String name=extras.getString("name");
        String source=extras.getString("source");
        String destination= extras.getString("destination");
        String date=extras.getString("date");
        String no=extras.getString("Numpass");
        String cost=extras.getString("cost");
        String details=name+"\n"+source+"\n"+destination+"\n"+date+"\n"+no+"\n"+cost;
        t.setText(details);
    }
}
