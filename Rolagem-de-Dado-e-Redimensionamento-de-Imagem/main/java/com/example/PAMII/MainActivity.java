package com.example.PAMII;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botaoMostrar();
        botaoLancarDado();
        redimensionarimagem();
    }

    public void botaoMostrar() {
        Button botaoMostrar = findViewById(R.id.btnMostrar);

        botaoMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imagemDado = findViewById(R.id.imagemDado);

                if (imagemDado.getVisibility() == View.VISIBLE) {
                    imagemDado.setVisibility(View.INVISIBLE);
                } else {
                    imagemDado.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void botaoLancarDado() {
        Button botaoLancarDado = findViewById(R.id.btnLancar);

        botaoLancarDado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                int resultadoRand = rand.nextInt(6) + 1;

                TextView txtResultado = findViewById(R.id.txtResultado);
                ImageView imagemDado = findViewById(R.id.imagemDado);

                txtResultado.setText("Resultado: " + resultadoRand);
                switch (resultadoRand) {
                    case 1:
                        imagemDado.setImageResource(R.drawable.f1);
                        break;
                    case 2:
                        imagemDado.setImageResource(R.drawable.f2);
                        break;
                    case 3:
                        imagemDado.setImageResource(R.drawable.f3);
                        break;
                    case 4:
                        imagemDado.setImageResource(R.drawable.f4);
                        break;
                    case 5:
                        imagemDado.setImageResource(R.drawable.f5);
                        break;
                    case 6:
                        imagemDado.setImageResource(R.drawable.f6);
                        break;
                }
            }
        });
    }

    public void redimensionarimagem() {
        SeekBar seekBar = findViewById(R.id.sbTamanhoImagem);
        ImageView imagemDado = findViewById(R.id.imagemDado);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                imagemDado.setScaleX(i);
                imagemDado.setScaleY(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                imagemDado.setVisibility(View.VISIBLE);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                imagemDado.setVisibility(View.INVISIBLE);
            }
        });
    }
}