package com.example.servizidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Intent myServiceIntent;
    private boolean myServiceStarted=false;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= findViewById(R.id.button);
        myServiceIntent=new Intent(getApplicationContext(),MyService.class);
        button.setOnClickListener(view -> {

            if (!myServiceStarted){

                startService(myServiceIntent);
            }else {

                stopService(myServiceIntent);
            }
            myServiceStarted=!myServiceStarted;
        });
    }
}