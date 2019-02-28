package com.example.ajay.firebase_authantication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(1500);
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                    Splash.super.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}