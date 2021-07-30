package com.Maktaba.MyBooks.BarFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.Maktaba.MyBooks.R;
import com.Maktaba.MyBooks.Requests;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class AskForBook extends Fragment {
    TextInputLayout name_of_authoer, link, book_name;
    Button button;

    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference=firebaseDatabase.getReference("bookRequests");
    public AskForBook() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ask_for_book, container, false);

        name_of_authoer=v.findViewById(R.id.my_textbox_authoer_of_ask_book);
        link=v.findViewById(R.id.my_textbox_link_of_ask_book);
        book_name=v.findViewById(R.id.my_textbox_name_of_ask_book);
        button=v.findViewById(R.id.btn_send);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name_of_book=String.valueOf(book_name.getEditText().getText().toString());
                String authoer=String.valueOf(name_of_authoer.getEditText().getText().toString());
                String link_of_book=(link.getEditText().getText().toString());

                if (TextUtils.isEmpty(name_of_book)&&TextUtils.isEmpty(authoer)&&TextUtils.isEmpty(link_of_book)){
                    book_name.setError("enter name of the book");
                    link.setError("enter link of the book");
                    name_of_authoer.setError("enter name of the authoer");
                }
                else {
                    Requests requests=new Requests(name_of_book,authoer,link_of_book);
                    databaseReference.push().setValue(requests);

                    Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
                }


            }
        });
        return v;
    }
}
