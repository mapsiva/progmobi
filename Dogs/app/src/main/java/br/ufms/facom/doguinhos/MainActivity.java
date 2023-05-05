package br.ufms.facom.doguinhos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridView grid;
    TextView txtBreed;

    int figures[] = {R.drawable.sample_10, R.drawable.sample_1, R.drawable.sample_2,
                    R.drawable.sample_3, R.drawable.sample_4, R.drawable.sample_5,
                    R.drawable.sample_6, R.drawable.sample_7, R.drawable.sample_8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = (GridView) findViewById(R.id.grid);
        txtBreed = (TextView) findViewById(R.id.txtBreed);

        DogAdapter dogAdapter = new DogAdapter(getApplicationContext(), figures);

        grid.setAdapter(dogAdapter);

        grid.setOnItemClickListener((adapterView, view, position, l) -> {
            switch (position){
                case 0:
                    txtBreed.setText("Raça: Buldog");
                    break;
                case 1:
                    txtBreed.setText("Raça: Poodle");
                    break;
                case 2:
                    txtBreed.setText("Raça: Labrador");
                    break;
                case 3:
                    txtBreed.setText("Raça: Beagle");
                    break;
                case 4:
                    txtBreed.setText("Raça: Chihuahua");
                    break;
                case 5:
                    txtBreed.setText("Raça: Maltês");
                    break;
                case 6:
                    txtBreed.setText("Raça: Pastor");
                    break;
                case 7:
                    txtBreed.setText("Raça: Pug");
                    break;
                case 8:
                    txtBreed.setText("Raça: Husky Siberiano");
                    break;
            }

        });
    }
}