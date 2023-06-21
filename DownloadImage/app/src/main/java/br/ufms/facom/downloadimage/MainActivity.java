package br.ufms.facom.downloadimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private ProgressBar progress ;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = findViewById ( R.id.progressBar ) ;
        iv = findViewById(R.id.imgTeste);
    }
    public void baixarImagemWeb(View v){
        new Thread(){
            int value;
            public void run(){
                try{
                    URL url = new URL("https://ciclovivo.com.br/wp-content/uploads/2020/09/tree-3822149_1280.jpg");
                    HttpURLConnection connection;
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    InputStream input = connection.getInputStream();
                    final Bitmap imagem = BitmapFactory.decodeStream(input);

                    for ( int i = 1; i <= 10; i ++) {
                        value = i;
                        //Thread.sleep(1000);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progress.setProgress (value) ;
                                Log.i("My Activity","baixou");
                            }
                        });
                    }
                    progress.setVisibility(View.INVISIBLE);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            iv.setImageBitmap(imagem);
                        }
                    });
                    connection.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}