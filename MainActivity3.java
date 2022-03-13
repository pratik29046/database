package com.example.sql1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {
    DatabaseHelper mdb;
    EditText name,add,phone,id;
    Button update,delete,shows;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mdb=new DatabaseHelper(this);
        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        add=findViewById(R.id.add);
        phone=findViewById(R.id.phone);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
        shows=findViewById(R.id.shows);

        String id1=getIntent().getStringExtra("id");
        String name1=getIntent().getStringExtra("name");
        String add1=getIntent().getStringExtra("add");
        String phone1=getIntent().getStringExtra("phone");

        id.setText(id1);
        name.setText(name1);
        add.setText(add1);
        phone.setText(phone1);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean up=mdb.update(id.getText().toString(),name.getText().toString(),add.getText().toString(),phone.getText().toString());
                if(up == true){
                    Toast.makeText(getApplicationContext(), "data is updated", Toast.LENGTH_SHORT).show();
                    id.setText("");
                    name.setText("");
                    add.setText("");
                    phone.setText("");
                }
                else{
                    Toast.makeText(getApplicationContext(), "data is not updated", Toast.LENGTH_SHORT).show();
                }

            }
        });

        shows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
//        updates();
        deletes();
    }

//    public void updates(){
//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                boolean up=mdb.update(id.getText().toString(),name.getText().toString(),add.getText().toString(),phone.getText().toString());
//                if(up == true){
//                    Toast.makeText(getApplicationContext(), "data is updated", Toast.LENGTH_SHORT).show();
//                    id.setText("");
//                    name.setText("");
//                    add.setText("");
//                    phone.setText("");
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "data is not updated", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//    }

    public void deletes(){
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer row= mdb.delete(id.getText().toString());
                if(row>0){
                    Toast.makeText(getApplicationContext(), "data is deleted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "data is not deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void back(){
        super.onBackPressed();
        return;
    }

}