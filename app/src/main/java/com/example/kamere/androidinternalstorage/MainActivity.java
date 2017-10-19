package com.example.kamere.androidinternalstorage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
EditText name,email,pass,cpass;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.email);
        pass=(EditText) findViewById(R.id.password);
        cpass=(EditText) findViewById(R.id.cpass);
        register=(Button) findViewById(R.id.Register);

    }

    public void register(View view){
        String uname,uemail,upass,ucpass;
        uname=name.getText().toString();
        uemail=email.getText().toString();
        upass=pass.getText().toString();
        ucpass=cpass.getText().toString();

        if(uname.isEmpty() || uemail.isEmpty()||upass.isEmpty()||ucpass.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please fill all fields correctly",Toast.LENGTH_LONG).show();
        return;
        }
        if(!upass.equals(ucpass)){
            Toast.makeText(getApplicationContext(),"Password should be the same",Toast.LENGTH_LONG).show();
            return;
        }

        FileOutputStream fileOutputStream = null;
        try {
            File file=null;
        uname=uname+ " ";
            uemail=uemail+" ";
            upass=upass+" ";

            file=getFilesDir();
            fileOutputStream = openFileOutput("register.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(uname.getBytes());
            fileOutputStream.write(uemail.getBytes());
            fileOutputStream.write(upass.getBytes());

            //indicate that data was correctly saved
            Toast.makeText(this,"Your data was correctly saved",Toast.LENGTH_LONG).show();


            //empty the fields
            name.setText(" ");
            email.setText(" ");
            pass.setText(" ");

            //navigate to the next activity
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            startActivity(intent);

        }
            catch(Exception e){
                e.printStackTrace();
        }






    }
}
