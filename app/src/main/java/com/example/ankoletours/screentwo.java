package com.example.ankoletours;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class screentwo extends AppCompatActivity {
TextView view;
Button joy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screentwo);
      view = findViewById(R.id.read);
        joy=(Button)findViewById(R.id.show);
        joy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text="myc_code.c";
                try{
                    InputStream input=getAssets().open("myc_code.c");
                    int size=input.available();
                    byte[] buffer=new byte[size];
                    input.read(buffer);
                    input.close();
                    text=new String(buffer);


                } catch (IOException e) {
                    e.printStackTrace();

                }

            }

        });
    }
    
}
