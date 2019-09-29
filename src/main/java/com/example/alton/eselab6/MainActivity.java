package com.example.alton.eselab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String sourceItems[]={"China","America","Russia"};
    String destItems[]={"India","Hawaii","Canada"};
    int seats[][]={{9,6,3},{8,5,2},{7,4,1}};
    int sourceSelected=0;
    int destSelected=0;
    EditText e,e1;
    Button b;
    TextView t;
    DatePicker picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e=(EditText) findViewById(R.id.editText);
        e1=(EditText) findViewById(R.id.editText2);
        t=(TextView) findViewById(R.id.textView) ;
        b=(Button) findViewById(R.id.button);
        Spinner source=(Spinner) findViewById(R.id.spin1);
        Spinner dest=(Spinner) findViewById(R.id.spin2);
        picker=(DatePicker)findViewById(R.id.datePicker);
        source.setOnItemSelectedListener(this);
        dest.setOnItemSelectedListener(this);
        ArrayAdapter source1=new ArrayAdapter(this,android.R.layout.simple_spinner_item,sourceItems);
        source1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        source.setAdapter(source1);
        ArrayAdapter dest1=new ArrayAdapter(this,android.R.layout.simple_spinner_item,destItems);
        dest1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dest.setAdapter(dest1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=e.getText().toString();
                String pass_text=e1.getText().toString();
                int pass_no=Integer.parseInt(pass_text);
                if(seats[sourceSelected][destSelected]-pass_no>=0)
                {
                    seats[sourceSelected][destSelected]=seats[sourceSelected][destSelected]-pass_no;
                    Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                    i.putExtra("name",name);
                    i.putExtra("source",sourceItems[sourceSelected]);
                    i.putExtra("destination",destItems[destSelected]);
                    i.putExtra("date",picker.getDayOfMonth()+"/"+picker.getMonth()+"/"+picker.getYear());
                    i.putExtra("Numpass",pass_no+"");
                    i.putExtra("cost",100*pass_no+"");
                    startActivity(i);
                }
                else
                {
                    t.setText("No seats Available");
                }
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        if(arg0.getId()==R.id.spin1)
        {
            Log.i("Source:",sourceItems[position]);
            sourceSelected=position;
        }
        if(arg0.getId()==R.id.spin2)
        {
            Log.i("Destination:",destItems[position]);
            destSelected=position;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}
