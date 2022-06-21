package com.example.pokemon;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class LoadImg extends AsyncTask<String, Void, Bitmap> {

    ImageView imageView,loading;

    public LoadImg(ImageView imageView){
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        String url = urls[0];
        Bitmap pic = null;
        try{
            InputStream inputStream = (InputStream) new URL(url).getContent();
            pic = BitmapFactory.decodeStream(inputStream);
            //Log.v("msg","Loading image is complete");
            //loading.findViewById(R.id.loadingPanel).setVisibility(View.GONE);
            return pic;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void onPostExecute(Bitmap result){
        imageView.setImageBitmap(result);
    }
}