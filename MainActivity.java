package com.abhayjeet.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String data[]={"apple","banana","mango"};
    ArrayList<String> lists= new ArrayList<>();
    ArrayAdapter<String> ad;
    ListView list;
    TextView texts;
    EditText edit,edit2;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.listview);
        texts=findViewById(R.id.text);
        edit=findViewById(R.id.edits1);

//        edit2=findViewById(R.id.edits1);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e=edit.getText().toString();
//                String s=edit2.getText().toString();
                lists.add(e);
                edit.setText("");

            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

    }
    public void show(){
        ad=new ArrayAdapter<String>(MainActivity.this,R.layout.activity_main2,R.id.text2,lists);
        list.setAdapter(ad);
    }
}