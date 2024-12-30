package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    double resultado;
    double arrastrado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText Cifra1=findViewById(R.id.Cifra1);
        EditText Cifra2=findViewById(R.id.Cifra2);
        Button btMostrar=findViewById(R.id.btMostrar);
        Button btGuardar=findViewById(R.id.btGuardar);
        Button btCalcular=findViewById(R.id.btCalcular);
        Button btBorrar=findViewById(R.id.btBorrar);
        TextView Resultado_Final=findViewById(R.id.Resultado_Final);
        TextView NumArrastrado=findViewById(R.id.NumArrastrado);
        RadioGroup radio=findViewById(R.id.radioGroup);
        final String [] OperadorSeleccionado={""};
        RadioButton suma=findViewById(R.id.suma);
        RadioButton resta=findViewById(R.id.resta);
        RadioButton dividir=findViewById(R.id.dividir);
        RadioButton multipicar=findViewById(R.id.multiplicar);

        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.suma) {
                    OperadorSeleccionado[0] = "+";
                } else if (i == R.id.resta) {
                    OperadorSeleccionado[0] = "-";
                } else if (i == R.id.dividir) {
                    OperadorSeleccionado[0] = "/";
                } else if (i == R.id.multiplicar) {
                    OperadorSeleccionado[0] = "*";
                }


            }
        });

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double num1=Double.parseDouble(Cifra1.getText().toString());
                double num2=Double.parseDouble(Cifra2.getText().toString());
                if(OperadorSeleccionado[0].equals("+")){
                    resultado=num1+num2;
                    arrastrado=resultado;
                }
                else if(OperadorSeleccionado[0].equals("-")){
                    resultado=num1-num2;
                    arrastrado=resultado;
                }
                else if(OperadorSeleccionado[0].equals("*")){
                    resultado=num1*num2;
                    arrastrado=resultado;

                }

                Resultado_Final.setText(String.valueOf(resultado));
            }


        });

        btBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cifra1.setText("");
                Cifra2.setText("");
                NumArrastrado.setText("");
                Resultado_Final.setText("");
            }
        });

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumArrastrado.setText(String.valueOf(arrastrado));

            }
        });

        btMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Resultado: " + resultado, Toast.LENGTH_LONG).show();

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Sumar), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}