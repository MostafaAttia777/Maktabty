package com.Maktaba.MyBooks;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        AlertDialog.Builder builder=new AlertDialog.Builder(getApplicationContext());
        //View view= LayoutInflater.from(getBaseContext()).inflate(R.layout.custome_alret_dailog,null);
        Button button_one=findViewById(R.id.changelanguage_one);
        Button button_two=findViewById(R.id.changelanguage2);
        TextView textView=findViewById(R.id.my_text_lang);
        textView.setText("change Language ");
        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,0);
                startActivity(getIntent());
                overridePendingTransition(0,0);
                setAppLocale("ar");
            }
        });
        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,0);
                startActivity(getIntent());
                overridePendingTransition(0,0);
                setAppLocale("en");
            }
        });
    }
    private void setAppLocale(String language) {
        Locale locale=new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration=new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.activity_language);
        recreate();

    }
}
