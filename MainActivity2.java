package com.example.sql1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity2 extends AppCompatActivity {

    DatabaseHelper mdb;
    TextView show1;
    Button shows2,back,update;

    ArrayList<String> items=new ArrayList<>();
    ArrayAdapter ad;
    ListView user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mdb=new DatabaseHelper(this);
        show1=findViewById(R.id.shows);
        back=findViewById(R.id.back);
        update=findViewById(R.id.update);
        user=findViewById(R.id.user);

        shows();

        user.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text=user.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(),""+text,Toast.LENGTH_SHORT).show();
                Intent s=new Intent(getApplicationContext(),MainActivity3.class);

                s.putExtra("id",text);
                s.putExtra("name",text);
                s.putExtra("add",text);
                s.putExtra("phone",text);
                startActivity(s);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });

//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(getApplicationContext(),MainActivity3.class);
//                startActivity(i);
//            }
//        });

    }
//    public void shows(){
//        shows2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Cursor res= mdb.data_get();
//                if(res.getCount()==-1){
////                    message("Error","data is not found");
//                    Toast.makeText(getApplicationContext(), "data is not found", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                StringBuffer sb=new StringBuffer();
//                while(res.moveToNext()){
//                    sb.append("ID "+res.getString(0)+"\n");
//                    sb.append("name "+res.getString(1)+"\n");
//                    sb.append("address "+res.getString(2)+"\n");
//                    sb.append("phone "+res.getString(3)+"\n");
//                }
//                show1.setText(sb.toString());
//            }
//        });
//    }




    private void shows(){
        Cursor res= mdb.data_get();
        if(res.getCount()==-1){
//                    message("Error","data is not found");
            Toast.makeText(getApplicationContext(), "data is not found", Toast.LENGTH_SHORT).show();
            return;
        }
        while(res.moveToNext()){
            items.add(res.getString(0)+" "+ res.getString(1)+" "+ res.getString(2)+" "+ res.getString(3));
        }
//                show1.setText(sb.toString());
        ad=new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_list_item_1, items);
        user.setAdapter(ad);
    }




//    public void shows(){
//        shows2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Cursor res= mdb.data_get();
//                if(res.getCount()==-1){
//                    message("Error","data is not found");
//                    return;
//                }
//                StringBuffer sb=new StringBuffer();
//                while(res.moveToNext()){
//                    sb.append("ID "+res.getString(0)+"\n");
//                    sb.append("name "+res.getString(1)+"\n");
//                    sb.append("address "+res.getString(2)+"\n");
//                    sb.append("phone "+res.getString(3)+"\n");
//                }
//                message("data",sb.toString());
////                temp.setText(sb.toString());
//            }
//        });
//    }

        public void message(String titles,String message){
            AlertDialog.Builder b=new AlertDialog.Builder(this);
            b.setCancelable(true);
            b.setTitle(titles);
            b.setMessage(message);
            b.show();
        }

        public void back(){
            super.onBackPressed();
            return;
        }







}