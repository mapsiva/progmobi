package br.ufms.facom.calc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText valA;
    private EditText valB;
    private EditText result;
    private Button calcBtn;
    AlertDialog.Builder message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        valA = findViewById(R.id.valA);
        valB = findViewById(R.id.valB);
        result = findViewById(R.id.result);
        calcBtn = findViewById(R.id.calcBtn);
        message = new AlertDialog.Builder(this);

        calcBtn.setOnClickListener(view -> {
            String a = valA.getText().toString();
            String b = valB.getText().toString();

            Double r = Double.parseDouble(a) + Double.parseDouble(b);

            result.setText(r.toString());
            message.setMessage("Clicou no botão");
            message.setPositiveButton("OK", null);
            message.show();
        });
    }
}