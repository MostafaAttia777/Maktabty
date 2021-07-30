package com.Maktaba.MyBooks.LoginActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.Maktaba.MyBooks.HomeScreen;
import com.Maktaba.MyBooks.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginScreen extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private LoginButton loginButton;  //facebook_Btn
    private SignInButton signInButton; //google_btn
    private GoogleSignInClient mGoogleSignInClient;
    private final static String TAG = "MainActivity";
    private static final int RC_SIGN_IN = 1;
    CallbackManager callbackManager;
    private TextView textView_create_account;
    Button button_login_orgainl;
    TextInputLayout textView_email, textView_password;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        mAuth = FirebaseAuth.getInstance();////firebase Connecation
        loginButton = findViewById(R.id.login_button);
        signInButton = findViewById(R.id.login_button_google);
        textView_create_account = findViewById(R.id.createAccuont);
        button_login_orgainl = findViewById(R.id.btn_login);
        textView_email = findViewById(R.id.my_textbox_Email);
        textView_password = findViewById(R.id.my_textbox_password);
        FacebookSdk.sdkInitialize(getApplicationContext()); ///for facebook
        AppEventsLogger.activateApp(this);///for facebook
        GoogleSignInOptions(); ///for google login
        //  gethashkey();/////get key
        callbackManager = CallbackManager.Factory.create(); //for facebook login
        loginButton = (LoginButton) findViewById(R.id.login_button); //facebook btn
        loginButton.setReadPermissions("email");
        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handelFacebokAccessTokan(loginResult.getAccessToken());
                if (loginResult.getAccessToken() != null) {

                    Thread thread = new Thread();
                    try {
                        Thread.sleep(300);
                        Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                        startActivity(intent);
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    thread.start();
                }
            }


            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        textView_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), CreateAccuont.class));
            }
        });

        button_login_orgainl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = textView_email.getEditText().getText().toString();
                String password = textView_password.getEditText().getText().toString();
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
                    isuesr();

                } else if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {

                    textView_email.setError("enter your email");
                    textView_password.setError("enter your password");
                } else if (TextUtils.isEmpty(email)) {
                    textView_email.setError("enter your email");
                } else {
                    textView_password.setError("enter your password");

                }

            }
        });
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sginin();

            }
        });
    }


    ////////////////////////////////////
    private void GoogleSignInOptions() {
        GoogleSignInOptions gos = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gos);


    }  //for google

    private void sginin() {
        Intent sgininintent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(sgininintent, RC_SIGN_IN);
    } //for google

    private void handlesgininResult(Task<GoogleSignInAccount> completetask) {

        try {
            GoogleSignInAccount account = completetask.getResult(ApiException.class);

            firebasaegoogleAuth(account);

        } catch (ApiException e) {
            e.printStackTrace();

        }
    } //for google

    private void firebasaegoogleAuth(GoogleSignInAccount account) {
        AuthCredential authCredential = GoogleAuthProvider.getCredential(account.getIdToken(), null);

        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                    startActivity(intent);
                    finish();
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateui(user);
                } else {
                    updateui(null);

                }
            }
        });
    } //for google

    private void updateui(FirebaseUser user) {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (account != null) {
            String personname = account.getDisplayName();
            String persongivenname = account.getGivenName();
            String personfamilyname = account.getFamilyName();
            String personEmailname = account.getEmail();
            String personid = account.getId();
            String photo = account.getPhotoUrl().toString();
        }
    } //for google

//    private void gethashkey() {
//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(
//                    getPackageName(),
//                    PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//
//        } catch (NoSuchAlgorithmException e) {
//
//        }
//    }

    private void handelFacebokAccessTokan(AccessToken accessToken) {

        Log.d("AccessToken", "AccessToken" + accessToken);

        AuthCredential authCredential = FacebookAuthProvider.getCredential(accessToken.getToken());
        mAuth.signInWithCredential(authCredential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("onComplete", "signInWithCredential:Oncomplete:" + task.isSuccessful());
                        if (!task.isSuccessful()) {
                            Log.w("TRECTORS", "signInWithCredential", task.getException());
                        }
                    }
                });
    }  //for facebook you should memorize that

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == requestCode) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handlesgininResult(task);
if (task.isSuccessful()){

}
else {

Log.d("ee",task.getException().getMessage());
}
        }


    } //for google and facebook

    private void isuesr() {
        textView_email.setError(null);
        textView_password.setError(null);
        final String emailenterbyueser = textView_email.getEditText().getText().toString();
        final String passwordenterbyueser = textView_password.getEditText().getText().toString();

////////////////////////////////////
        firebaseAuth.signInWithEmailAndPassword(emailenterbyueser, passwordenterbyueser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(LoginScreen.this, "Welcome", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
