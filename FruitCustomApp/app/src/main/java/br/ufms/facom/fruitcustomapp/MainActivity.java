package br.ufms.facom.fruitcustomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listFruits = findViewById(R.id.list_fruits);
        ArrayList<Fruit> basketFruits = new ArrayList<>();
        basketFruits.add(new Fruit("Manga", "Fruta famosa do Brasil", R.drawable.manga));
        basketFruits.add(new Fruit("Guavira", "Fruta famosa do cerrado", R.drawable.guavira));
        basketFruits.add(new Fruit("Jaca", "Fruta famosa pelo cheiro.", R.drawable.melancia));

        FruitAdapter adapter = new FruitAdapter(this, basketFruits);
        listFruits.setAdapter(adapter);
    }
}