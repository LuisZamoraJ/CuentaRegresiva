package com.example.cuentaregresiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_min, et_seg;
    Button iniciar;
    TextView mostrar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_min = findViewById(R.id.et_min);
        et_seg = findViewById(R.id.et_seg);
        iniciar = findViewById(R.id.iniciar);
        mostrar = findViewById(R.id.mostrar);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarCuenta();
            }
        });



    }

    private void iniciarCuenta() {

        int minu=(Integer.valueOf(et_min.getText().toString()) *60 ) * 1000;
        final int segu= Integer.valueOf(et_seg.getText().toString()) * 1000;
        long valor = minu + segu;
        CountDownTimer cuenta = new CountDownTimer(valor, 1000 ) {
            @Override
            public void onTick(long l) {
                long tiempo = l/1000;
                int minutos = (int) (tiempo / 60);
                long segundos = tiempo % 60;
                String minutos_mostrar = String.format("%02d", minutos);
                String segundos_mostrar = String.format("%02d", segundos);
                mostrar.setText("" + minutos_mostrar + " : "+ segundos_mostrar);


            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Finalizó", Toast.LENGTH_SHORT).show();
                mostrar.setText("00:00");
            }
        }   .start();


    }
}
