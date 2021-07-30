package com.Maktaba.MyBooks.LoginActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.Maktaba.MyBooks.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class CreateAccuont extends AppCompatActivity {
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private StorageReference storageReference = FirebaseStorage.getInstance().getReference();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Users_bookstore");
    private TextInputLayout textView_name, textView_email, textView_password, textView_phone;
    private ImageView imageView_profile;
    private ImageButton button_open_gallary;
    private Button button_for_create_Accuont;
    private final static int RQ_CODE = 1;
    private Uri image_uri;
    private String link;
    private Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_accuont);
        imageView_profile = findViewById(R.id.my_image_regster);
        button_open_gallary = findViewById(R.id.cma_up_load);
        button_for_create_Accuont = findViewById(R.id.create_account);
        textView_name = findViewById(R.id.txt_name);
        textView_email = findViewById(R.id.txt_email);
        textView_password = findViewById(R.id.txt_password);
        textView_phone = findViewById(R.id.txt_phone);
        button_open_gallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_gallary();
            }
        });

        button_for_create_Accuont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tx_name=textView_name.getEditText().getText().toString();
                String tx_email=textView_email.getEditText().getText().toString();
                String tx_phone=textView_phone.getEditText().getText().toString();
                String tx_password=textView_password.getEditText().getText().toString();

                if (TextUtils.isEmpty(tx_email)&&TextUtils.isEmpty(tx_name)&&TextUtils.isEmpty(tx_phone)&&TextUtils.isEmpty(tx_password)){
                    textView_name.setError("enter your name");
                    textView_phone.setError("enter your phone");
                    textView_password.setError("enter your password");
                    textView_email.setError("enter your email");

                }
                else if (TextUtils.isEmpty(tx_email)&&TextUtils.isEmpty(tx_name)){
                    textView_email.setError("enter your email");
                    textView_name.setError("enter your name");

                }
                else if (TextUtils.isEmpty(tx_phone)&&TextUtils.isEmpty(tx_password)){
                    textView_phone.setError("enter your phone");
                    textView_password.setError("enter your password");
                }
                else if (!TextUtils.isEmpty(tx_email)&&!TextUtils.isEmpty(tx_name)&&!TextUtils.isEmpty(tx_phone)&&!TextUtils.isEmpty(tx_password)){
                    createAccount(image_uri);
                }

            }
        });
    }

    private void open_gallary() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        startActivityForResult(intent, RQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RQ_CODE && resultCode == RESULT_OK && data != null) {
            image_uri = data.getData();
            imageView_profile.setImageURI(image_uri);
        }
        else {
            if (resultCode==RESULT_CANCELED&&data==null){
                Toast.makeText(this, "please chooce photo", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void createAccount(final Uri image_uri) {
        final String name = textView_name.getEditText().getText().toString();
        String email = textView_email.getEditText().getText().toString();
        String password = textView_password.getEditText().getText().toString();
        String phone = textView_phone.getEditText().getText().toString();
        model = new Model(name, email, password, phone, link);
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull final Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(CreateAccuont.this, "created", Toast.LENGTH_SHORT).show();
                    final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();   //create accuont done
                    final String uesid = firebaseUser.getUid(); // get uesrid done
                    //upload image by uesrid done
                    storageReference.child("photos_bookstore").child(uesid + ".jpg").putFile(image_uri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if (task.isSuccessful()) {
                                storageReference.child("photos_bookstore").child(uesid+".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        String url=uri.toString();  // link of image
                                        UserProfileChangeRequest userProfileChangeRequest=new UserProfileChangeRequest.Builder()
                                                .setDisplayName(name)
                                                .setPhotoUri(uri)
                                                .build();
                                        firebaseUser.updateProfile(userProfileChangeRequest); // to show data of normal create

                                        HashMap<String ,String> hashMap= new HashMap<>();
                                        hashMap.put("name",model.getName());
                                        hashMap.put("email",model.getEmail());
                                        hashMap.put("password",model.getPassword());
                                        hashMap.put("phone",model.getPhone());
                                        hashMap.put("link",url);

                                        Model info=new Model(model.getName(),model.getEmail(),model.getPassword(),model.getPhone(),url);

                                        myRef.child(uesid).setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()){
                                                  //  Toast.makeText(CreateAccuont.this, "uploaded", Toast.LENGTH_SHORT).show();
                                                }
                                                else {
                                                    Toast.makeText(CreateAccuont.this, "filed", Toast.LENGTH_SHORT).show();
                                                    Log.d("max",task.getException().getMessage());
                                                }
                                            }
                                        });
                                    }
                                });
                            }else{
                                Toast.makeText(CreateAccuont.this, "image didn't been uploaded", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                    startActivity(new Intent(getApplicationContext(),LoginScreen.class));
                    finish();
                } else {
                    String errormessage = task.getException().getMessage();
                    Toast.makeText(getBaseContext(), errormessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
