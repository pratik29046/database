package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
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
    ArrayList<String> lists1= new ArrayList<>();
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

                String d=edit.getText().toString();
//                String s=edit2.getText().toString();
                lists.add(d);

                StringBuilder sb= new StringBuilder();
                for(String item:lists){
                    sb.append(item+ "\n");
                }
                SharedPreferences sp=getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor e=sp.edit();
                e.putString("p",d);
                e.apply();
                edit.setText("");

            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("data",MODE_PRIVATE);
                String name=sp.getString("p","");
//                texts.setText(name);
                lists1.add(name);
                show();
            }
        });

    }
    public void show(){
        ad=new ArrayAdapter<String>(MainActivity.this,R.layout.activity_main2,R.id.text2,lists1);
        list.setAdapter(ad);
        ad.notifyDataSetChanged();



    }

}