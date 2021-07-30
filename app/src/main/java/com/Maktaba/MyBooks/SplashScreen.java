package com.Maktaba.MyBooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.Maktaba.MyBooks.LoginActivity.LoginScreen;
import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {
    Animation top_animtion,bottom_animtion;
    LottieAnimationView lo;
    ImageView textView;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.book);
        top_animtion= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_animtion= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        lo=findViewById(R.id.animation_view);
        lo.setAnimation(top_animtion);
        textView.setAnimation(bottom_animtion);
        mediaPlayer=MediaPlayer.create(SplashScreen.this,R.raw.mu);
        //if there is not user Log in  go to Login Activity

        if (FirebaseAuth.getInstance().getCurrentUser()==null){
            mediaPlayer.start();

            final Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(4000);
                        startActivity(new Intent(getApplicationContext(), LoginScreen.class));
                        finish();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
            thread.start();

        }
        else
        {
            startActivity(new Intent(getApplicationContext(), HomeScreen.class));
            Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();
            finish();
        }


    }
}
