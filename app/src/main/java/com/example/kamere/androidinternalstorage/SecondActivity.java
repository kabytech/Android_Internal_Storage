package com.example.kamere.androidinternalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.FileInputStream;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        try {
            FileInputStream fileInputStream = openFileInput("register.txt");
            int read=1;
            StringBuffer buffer=new StringBuffer();
            while((read=fileInputStream.read())!=-1){
                buffer.append((char)read);
            }

            Log.d("register", buffer.toString());
            String name= buffer.substring(0,buffer.indexOf(" "));
            String email = buffer.substring(buffer.indexOf(" ")+1);
            String pass = buffer.substring(buffer.indexOf(" ")+2);
            Toast.makeText(this,"name"+name+" "+"Email"+email+"password"+pass+" ",Toast.LENGTH_LONG).show();

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
