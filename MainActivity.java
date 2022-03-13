package com.example.sql1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper mdb;
    EditText name,add,phone,id;
    Button save,show,update,delete;
    TextView temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdb=new DatabaseHelper(this);
        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        add=findViewById(R.id.add);
        phone=findViewById(R.id.phone);
        save=findViewById(R.id.save);
        show=findViewById(R.id.show);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
        temp=findViewById(R.id.temp);
        adds();
//        shows();
//        updates();
//        deletes();

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(i);
            }
        });


    }

    public void adds(){
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean b= mdb.insert(id.getText().toString(),name.getText().toString(),add.getText().toString(),phone.getText().toString());
               if(b== true){
                   Toast.makeText(getApplicationContext(), "save data", Toast.LENGTH_SHORT).show();
                   id.setText("");
                   name.setText("");
                   add.setText("");
                   phone.setText("");
               }
               else{
                   Toast.makeText(getApplicationContext(), "data is not save", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

//    public void shows(){
//        show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Cursor res= mdb.data_get();
//                if(res.getCount()==-1){
////                    message("Error","data is not found");
//                    return;
//                }
//                StringBuffer sb=new StringBuffer();
//                while(res.moveToNext()){
//                    sb.append("ID "+res.getString(0)+"\n");
//                    sb.append("name "+res.getString(1)+"\n");
//                    sb.append("address "+res.getString(2)+"\n");
//                    sb.append("phone "+res.getString(3)+"\n");
//                }
////                message("data",sb.toString());
//                temp.setText(sb.toString());
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

//    public void deletes(){
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               Integer row= mdb.delete(id.getText().toString());
//               if(row>=0){
//                   Toast.makeText(getApplicationContext(), "data is deleted", Toast.LENGTH_SHORT).show();
//               }else{
//                   Toast.makeText(getApplicationContext(), "data is not deleted", Toast.LENGTH_SHORT).show();
//               }
//            }
//        });
//    }
}
