package br.ufms.facom.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtNome;
    private TextView txtIMC;
    private TextView txtClass;
    private TextView txtCons;

    private EditText edtPeso;
    private EditText edtAltura;

    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        txtNome = findViewById(R.id.txtNome);
        txtClass = findViewById(R.id.txtClassifica);
        txtCons = findViewById(R.id.txtConseq);
        txtIMC = findViewById(R.id.txtIMC);

        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(view -> {
            double peso = Double.parseDouble(edtPeso.getText().toString());
            double altura = Double.parseDouble(edtAltura.getText().toString());
            double imc = peso/(altura * altura);
            txtIMC.setText(String.format("%.1f", imc));

            if(imc < 17){
                txtClass.setText("Muito abaixo do peso");
                txtCons.setText("Queda de cabelo");
            }
            else if (imc < 18.5){
                txtClass.setText("Abaixo do Peso");
                txtCons.setText("Fadiga, stress e Ansiedade");
            } else if (imc < 25) {
                txtClass.setText("Normal");
                txtCons.setText("Menor risco de doenças cardíacas");
            } else if (imc < 30) {
                txtClass.setTextColor(Color.rgb(200, 0,0));
                txtClass.setText("Acima do peso");
                txtCons.setText("Fadiga, má circulação");
            } else if (imc < 35) {
                txtClass.setText("Obesidade Grau 1");
                txtCons.setText("Diabete e infarto");
            }
            else {
                txtClass.setText("Obesidade Grau 2");
                txtCons.setText("Procure o seu médico");
            }

            startActivity(new Intent(MainActivity.this, OtherActivity.class));
        });
    }
}