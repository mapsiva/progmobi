package br.ufms.facom.downloadimagetask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements AfterDownload {

    private ProgressDialog dialog;
    private DownloadTask task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog=ProgressDialog.show(MainActivity.this,
                        "Download","Downloading image!");
                task=new DownloadTask(MainActivity.this,MainActivity.this,dialog);
                task.execute("https://ciclovivo.com.br/wp-content/uploads/2020/09/tree-3822149_1280.jpg");
            }
        });
    }

    @Override
    protected void onDestroy() {
        if(dialog!=null&&dialog.isShowing()){
            dialog.dismiss();
            dialog=null;
        }
        if(task!=null){
            task.cancel(true);
        }
        super.onDestroy();
    }

    @Override
    public void downloadCompleted(Bitmap bitmap) {
        ImageView img = findViewById(R.id.imageView1);
        img.setImageBitmap(bitmap);
    }
}