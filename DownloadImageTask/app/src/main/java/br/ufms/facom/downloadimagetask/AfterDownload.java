package br.ufms.facom.downloadimagetask;

import android.graphics.Bitmap;

public interface AfterDownload {
    public void downloadCompleted(Bitmap bitmap);
}
