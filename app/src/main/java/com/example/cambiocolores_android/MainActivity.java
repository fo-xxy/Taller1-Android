package com.example.cambiocolores_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;


public class MainActivity extends AppCompatActivity {

    /*3: Declaramos la variable de la pantalla*/
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*4: Se inicializa la variable, y que busque la pantalla por id*/
        layout = (ConstraintLayout)findViewById(R.id.p1);

    }

    /*5: Creamos el primer método que sera el del primer boton, no olvdemos el parametro y nos vamos al package values y a archivo colors...*/
    public void color1(View view){
        /*7: Le decimos que cuando hagan click que llame a la avriable que contiene la pantalla, pero se llama al recurso (Resource)*/
        layout.setBackgroundResource(R.color.colorFuscia);
        /*8: Nos vamos al diseño y le asignamos este metodo al boton en onclick*/
    }

    /*9: Creamos el segundo metodo*/
    public void color2(View view){
        layout.setBackgroundResource(R.color.colorAzul);
        /*10: Nos vamos al diseño y le asignamos este metodo al boton en onclick*/
    }

    /*11: Creamos el tercer metodo*/
    public void color3(View view){
        layout.setBackgroundResource(R.color.colorVerde);
        /*12: Nos vamos al diseño y le asignamos este metodo al boton en onclick*/
    }

    /*13: Creamos el cuarto metodo*/
    public void color4(View view){
        layout.setBackgroundResource(R.color.colorNaranja);
        /*14: Nos vamos al diseño y le asignamos este metodo al boton en onclick*/
    }

    /*extra, metodo del boton*/
    public void extra(View view){
        Intent ventana = new Intent(this, Extra.class);
        startActivity(ventana);
    }

    public void reproductor(View view){
        Intent rep = new Intent(this, Reproductor.class);
        startActivity(rep);

    }
}
