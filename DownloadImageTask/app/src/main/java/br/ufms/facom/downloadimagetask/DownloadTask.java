package br.ufms.facom.downloadimagetask;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadTask extends AsyncTask<String,Void, Bitmap> {
    private Context context;
    private AfterDownload ti;
    private ProgressDialog dialog;
    private HttpURLConnection connection;
    public DownloadTask(Context context, AfterDownload ti, ProgressDialog dialog) {
        this.context = context;
        this.ti = ti;
        this.dialog = dialog;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.show();
    }
    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap bitmap=null;
        try{
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(input);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return bitmap;
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        Runnable progressRunn=new Runnable() {
            @Override
            public void run() {
                dialog.cancel();
            }
        };
        Handler pdCancell=new Handler();
        pdCancell.postDelayed(progressRunn,10000);
    }
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        connection.disconnect();

        dialog.dismiss();
        ti.downloadCompleted(bitmap);

        super.onPostExecute(bitmap);
    }
}