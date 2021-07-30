package com.Maktaba.MyBooks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Maktaba.MyBooks.Room.BuildeRoomDatabase;
import com.Maktaba.MyBooks.Room.ModelOfTable;


import java.util.ArrayList;

public class Ad_for_custom_heart extends RecyclerView.Adapter<Ad_for_custom_heart.Box_vh> {
    public Ad_for_custom_heart(ArrayList<ModelOfTable> modelOfTables) {
        this.modelOfTables = modelOfTables;
    }

    ArrayList<ModelOfTable> modelOfTables=new ArrayList<>();
    BuildeRoomDatabase buildeRoomDatabase;
Context context;

    @NonNull
    @Override
    public Box_vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_heart,parent,false);
        buildeRoomDatabase= BuildeRoomDatabase.getInstance(context);
        return new Box_vh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Box_vh holder, int position) {
final ModelOfTable m=modelOfTables.get(position);
        //final Data_for_books d = data_for_books.get(position);
        holder.textView.setText(m.getName_of_book());
        holder.imageView.setImageResource(m.getImage());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buildeRoomDatabase.operationDao().Deletedata(m);
                    notifyDataSetChanged();

            }
        });

    }

    @Override
    public int getItemCount() {
        return modelOfTables.size();

    }

    class  Box_vh extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        Button button;
    public Box_vh(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text_custome_id);
        imageView = itemView.findViewById(R.id.book_custome_id);
    button=itemView.findViewById(R.id.delete_btn);
    }
}

}
