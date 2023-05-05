package br.ufms.facom.doguinhos;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class DogAdapter extends BaseAdapter {
    private Context ctx;
    private int[]dogList;
    public DogAdapter(Context ctx, int[] dogList) {
        this.ctx = ctx;
        this.dogList = dogList;
    }

    @Override
    public int getCount() {
        return dogList.length;
    }
    @Override
    public Object getItem(int position) {
        return dogList[position];
    }
    @Override
    public long getItemId(int posisition) {
        return posisition;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView iv = new ImageView(ctx);
        iv.setImageResource(dogList[position]);
        iv.setLayoutParams(new ViewGroup.LayoutParams(250,250));
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setPadding(5,5,5,5);
        return iv;
    }
}
