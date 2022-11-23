package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button1,button2;
    EditText edt1,edt2;
    Spinner sp1,sp2;
    String a,aa,aaa=null;
    String c,d=null;
    String chuoi="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.textView);
        button1=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);
        edt1=(EditText) findViewById(R.id.editTextTextPersonName);
        edt2=(EditText) findViewById(R.id.editTextTextPersonName2);
        sp1=(Spinner) findViewById(R.id.spinner);
        sp2=(Spinner) findViewById(R.id.spinner2);


        List<Kichthuoc> kt=new ArrayList<>();
        kt.add(new Kichthuoc(1,"S"));
        kt.add(new Kichthuoc(2,"m"));
        kt.add(new Kichthuoc(3,"l"));

        List<Mausac> ms=new ArrayList<>();
        ms.add(new Mausac(1,"xanh"));
        ms.add(new Mausac(2,"do"));
        ms.add(new Mausac(3,"vang"));
        ArrayAdapter<Kichthuoc> spinnerAdapter = new ArrayAdapter<Kichthuoc>(this, android.R.layout.simple_spinner_dropdown_item, kt);
        sp1.setSelection(0);
        sp1.setAdapter(spinnerAdapter);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                a=String.valueOf(kt.get(i).makichthuoc);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<Mausac>mausacArrayAdapter = new ArrayAdapter<Mausac>(this, android.R.layout.simple_spinner_dropdown_item, ms);
        sp2.setSelection(0);
        sp2.setAdapter(mausacArrayAdapter);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                aa=String.valueOf(ms.get(i).mamausac);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c=edt1.getText().toString();
                d=edt2.getText().toString();
                aaa=a+":"+aa+":"+c+":"+d;
                chuoi+=aaa+"/";
                Log.d("TAG", "onClick: >>>"+chuoi);
                textView.setText(""+chuoi);


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "thêm sản phẩm theo định dang : >>> "+chuoi, Toast.LENGTH_SHORT).show();
          textView.setText("");
            }
        });




    }
}