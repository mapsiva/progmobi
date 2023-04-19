package br.ufms.facom.fruitsimpleapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listFruits = findViewById(R.id.list_fruits);
        ArrayList<String> basketFruits = new ArrayList<String>();
        basketFruits.add("Manga");
        basketFruits.add("Melancia");
        basketFruits.add("Laranja");
        basketFruits.add("Goiaba");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, basketFruits);
        listFruits.setAdapter(adapter);
        listFruits.setOnItemClickListener((adapterView, view, i, l) -> {
            //AlertDialog.Builder message = new AlertDialog.Builder(this);
            //message.setMessage("Cliquei na: " + basketFruits.get(i)).show();
            Toast.makeText(this, "Cliquei na: " + basketFruits.get(i), Toast.LENGTH_SHORT).show();
        });

//        listFruits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//        });
    }

}