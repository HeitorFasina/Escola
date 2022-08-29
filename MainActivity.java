package com.example.bgapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorButtonListenerMethod();
    }

    public void colorButtonListenerMethod(){

        Button colorButton = (Button)findViewById(R.id.colorButton);

        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V){
                ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.activity_main);
                int corFundo = ((ColorDrawable) bgElement.getBackground()).getColor();

                if (corFundo == Color.RED) bgElement.setBackgroundColor(Color.BLUE);
                else bgElement.setBackgroundColor(Color.RED);
            }
        });
    }
}

