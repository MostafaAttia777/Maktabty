package com.Maktaba.MyBooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OpenBooks extends AppCompatActivity {
    static PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_books);
        pdfView=findViewById(R.id.pdfView);
        Intent intent=getIntent();
        String link=intent.getStringExtra("key".toString());


        new retrevpdfstrem.execute(link);
    }
    private class  MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }

    static class  retrevpdfstrem  extends AsyncTask<String,Void, InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;

            URL url= null;
            try {

                url = new URL(strings[0]);
                HttpURLConnection httpURLConnection= null;
                httpURLConnection = (HttpURLConnection)url.openConnection();
                if (httpURLConnection.getResponseCode()==200){
                    inputStream=new BufferedInputStream(httpURLConnection.getInputStream());
                }

            }

            catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
        }

        public static class execute {
            public execute(String pdf) {
                new retrevpdfstrem().execute(pdf);
            }
        }
    }
}

