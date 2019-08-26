package com.example.cambiocolores_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;

public class Extra extends AppCompatActivity {

    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);

        layout=(ConstraintLayout)findViewById(R.id.p2);
    }

    public void imagen1(View view){
        layout.setBackgroundResource(R.drawable.i2);
    }

    public void imagen2(View view){
     layout.setBackgroundResource(R.drawable.i4);
    }

    public void imagen3(View view){
        layout.setBackgroundResource(R.drawable.i5);
    }

    public void imagen4(View view){
        layout.setBackgroundResource(R.drawable.i6);
    }

}
