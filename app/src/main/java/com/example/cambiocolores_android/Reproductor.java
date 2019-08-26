package com.example.cambiocolores_android;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Reproductor extends AppCompatActivity {

    /*1: se crean los objetos*/
    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion = 0;

    MediaPlayer vectorMp [] = new MediaPlayer[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        /*2: relacion parte logica y la parte grafica*/
        play_pause = (Button)findViewById(R.id.btnplay);
        btn_repetir = (Button)findViewById(R.id.btnrepeat);
        iv = (ImageView)findViewById(R.id.imageView);

        /*3: introduccion de canciones*/
        vectorMp[0] = MediaPlayer.create(this, R.raw.monster);
        vectorMp[1] = MediaPlayer.create(this, R.raw.bornforthis);
        vectorMp[2] = MediaPlayer.create(this, R.raw.partii);
    }

    /*3: creacion de metodos*/
    public void playPause(View view){
        if(vectorMp[posicion].isPlaying()){
            /*4: si la cancion esta sonando y apretamos el boton pausar, se pausará la cancion*/
            vectorMp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
        }
        else{
            vectorMp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();

        }
    }

    /*4: Metodo para el boton stop*/
    public void stop(View view){
        if(vectorMp[posicion] != null){
            vectorMp[posicion].stop();

            vectorMp[0] = MediaPlayer.create(this, R.raw.monster);
            vectorMp[1] = MediaPlayer.create(this, R.raw.bornforthis);
            vectorMp[2] = MediaPlayer.create(this, R.raw.partii);
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.paramorem);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }

    /*5: Creacion del metodo repetir*/
    public void repeat(View view){
        if(repetir == 1){
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "No repeat", Toast.LENGTH_SHORT).show();
            vectorMp[posicion].setLooping(false);
            repetir = 2;
        }
        else{
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repeat", Toast.LENGTH_SHORT).show();
            vectorMp[posicion].setLooping(true);
            repetir = 1;
        }
    }

    /*6: Metodo para la siguiente cancion*/
    public void next(View view){
        if(posicion < vectorMp.length -1){
            if(vectorMp[posicion].isPlaying()){
                vectorMp[posicion].stop();
                posicion ++;
                vectorMp[posicion].start();
                if(posicion == 0){
                    iv.setImageResource(R.drawable.paramorem);
                }
                else if(posicion == 1){
                    iv.setImageResource(R.drawable.paramorer);
                }
                else if(posicion == 2){
                    iv.setImageResource(R.drawable.paramorep);
                }
            }
            else{
                posicion++;
                if(posicion == 0){
                    iv.setImageResource(R.drawable.paramorem);
                }
                else if(posicion == 1){
                    iv.setImageResource(R.drawable.paramorer);
                }
                else if(posicion == 2){
                    iv.setImageResource(R.drawable.paramorep);
                }
            }
        }
        else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();

        }
    }

    /*7: Metodo para la cancion anterior*/
    public void previous(View view){
        if(posicion >= 1){
            if(vectorMp[posicion].isPlaying()){
                vectorMp[posicion].stop();
                vectorMp[0] = MediaPlayer.create(this, R.raw.monster);
                vectorMp[1] = MediaPlayer.create(this, R.raw.bornforthis);
                vectorMp[2] = MediaPlayer.create(this, R.raw.partii);
                posicion--;

                if(posicion == 0){
                    iv.setImageResource(R.drawable.paramorem);
                }
                else if(posicion == 1){
                    iv.setImageResource(R.drawable.paramorer);
                }
                else if(posicion == 2){
                    iv.setImageResource(R.drawable.paramorep);
                }

                vectorMp[posicion].start();

            }
            else{
                posicion--;

                if(posicion == 0){
                    iv.setImageResource(R.drawable.paramorem);
                }
                else if(posicion == 1){
                    iv.setImageResource(R.drawable.paramorer);
                }
                else if(posicion == 2){
                    iv.setImageResource(R.drawable.paramorep);
                }
            }
        }
        else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }

    public void salir(View view){
        finish();
    }

}
