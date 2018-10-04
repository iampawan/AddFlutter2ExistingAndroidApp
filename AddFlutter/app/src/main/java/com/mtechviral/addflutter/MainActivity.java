package com.mtechviral.addflutter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import io.flutter.facade.Flutter;

public class MainActivity extends AppCompatActivity {


    Button flutterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flutterButton = findViewById(R.id.flutterButton);
        flutterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View flutterView = Flutter.createView(MainActivity.this,getLifecycle(),"" +
                        "r1");


                FrameLayout.LayoutParams frameLayout = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
                frameLayout.topMargin = 200;
                addContentView(flutterView,frameLayout);
            }
        });

    }
}
