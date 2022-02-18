package com.asier.aranda.miproyectosettingsactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferencias;
    private TextView tv1,tv2,tv3,tv4,tv5;
    private Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        bt1 = findViewById(R.id.bt1);
        preferencias = getSharedPreferences("/data/data/com.asier.aranda.miproyectosettingsactivity/shared_prefs/com.asier.aranda.miproyectosettingsactivity_preferences.xml", Context.MODE_PRIVATE);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperarDatos();
            }
        });

    }

    public void recuperarDatos(){
        String email = preferencias.getString("email", "por_defecto@email.com");
        String sexo = preferencias.getString("sexo", "Otro");
        String aficiones = preferencias.getString("aficiones", "Ninguna");
        String sonido = preferencias.getString("sonido", "False");
        String notificaciones = preferencias.getString("notificaciones", "False");

        tv1.setText(email);
        tv2.setText(sexo);
        tv3.setText(aficiones);
        tv4.setText(sonido);
        tv5.setText(notificaciones);
    }
}