package com.Maktaba.MyBooks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.Maktaba.MyBooks.BarFragments.AskForBook;
import com.Maktaba.MyBooks.BarFragments.EnglishFragment;
import com.Maktaba.MyBooks.BarFragments.FavoriteFragment;
import com.Maktaba.MyBooks.BarFragments.HomeFragment;
import com.Maktaba.MyBooks.BarFragments.IslamicFragment;
import com.Maktaba.MyBooks.BarFragments.NovelsFragment;
import com.Maktaba.MyBooks.LoginActivity.LoginScreen;
import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    CircleImageView circleImageView;
    TextView textView_name, textView_email;
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        drawerLayout = findViewById(R.id.dr_layout);
        NavigationView view = findViewById(R.id.my_nav);
        circleImageView = findViewById(R.id.my_image_head);
        textView_name = findViewById(R.id.text_name_for_head);
        textView_email = findViewById(R.id.text_name_for_email);
        view.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        // sliderimages = findViewById(R.id.imageSlider_test);
        if (firebaseAuth.getCurrentUser() == null) {
            startActivity(new Intent(getBaseContext(), LoginScreen.class));
            finish();
        }

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new HomeFragment()).commit();
        }


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (firebaseUser != null) {
            updatanavheader();

        } else {
            Toast.makeText(this, "no user", Toast.LENGTH_SHORT).show();
        }


//        textView_name.setText(name);
        //  Glide.with(getApplicationContext()).load(image).into(circleImageView);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {

            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.out:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(getApplicationContext(), LoginScreen.class));
                break;
            case R.id.home_x:
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new HomeFragment()).commit();
                break;
            case R.id.Islamic:
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new IslamicFragment()).commit();
                break;
            case R.id.Favorite:
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new FavoriteFragment()).commit();
                break;
            case R.id.Novels:
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new NovelsFragment()).commit();
                break;
            case R.id.settings:
                startActivity(new Intent(getApplicationContext(), LanguageActivity.class));
                break;
            case R.id.english:
                //startActivity(new Intent(getApplicationContext(),EnglishBooks.class));
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new EnglishFragment()).commit();
                break;
//            case R.id.authors:
//                Toast.makeText(this, "authors", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(getApplicationContext(), AuthorsActivity.class));
//                break;
            case R.id.about:
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new AskForBook()).commit();
                break;
                case R.id.donwload:
                    //getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new downloaFragment()).commit();
                    Toast.makeText(this, "under working", Toast.LENGTH_SHORT).show();
                break;
                case R.id.studying_subjects:
                    //getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new downloaFragment()).commit();
                    Toast.makeText(this, "under working", Toast.LENGTH_SHORT).show();
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;

    }

    public void updatanavheader() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.my_nav);
        View headview = navigationView.getHeaderView(0);
        final TextView tx_name = headview.findViewById(R.id.text_name_for_head);
        final TextView tx_email = headview.findViewById(R.id.text_name_for_email);
        final CircleImageView imageView = headview.findViewById(R.id.my_image_head);
        tx_name.setText(firebaseUser.getDisplayName());
        tx_email.setText(firebaseUser.getEmail());
        Glide.with(getApplicationContext()).load(firebaseUser.getPhotoUrl()).into(imageView); //from facebooke and google
    }
}
