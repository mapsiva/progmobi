package br.ufms.facom.fruitcustomapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    public FruitAdapter (Context context, ArrayList<Fruit> basketFruits){
        super(context, 0, basketFruits);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentItemView = convertView;
        if (currentItemView ==  null){
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view_fruits,
                    parent, false);
        }
        Fruit fruitAtPosition = getItem(position);

        ImageView thumb = currentItemView.findViewById(R.id.fruit_image);
        thumb.setImageResource(fruitAtPosition.getDrawableId());

        TextView nameFruit = currentItemView.findViewById(R.id.name_fruit);
        nameFruit.setText(fruitAtPosition.getName());

        TextView descFruit = currentItemView.findViewById(R.id.desc_fruit);
        descFruit.setText(fruitAtPosition.getDescription());

        return currentItemView;
    }
}
