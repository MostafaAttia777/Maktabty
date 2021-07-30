package com.Maktaba.MyBooks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Maktaba.MyBooks.Room.BuildeRoomDatabase;
import com.Maktaba.MyBooks.Room.ModelOfTable;
import java.util.ArrayList;

public class Adpter_for_books extends RecyclerView.Adapter<Adpter_for_books.Box_of_Vh> {
    ArrayList<Data_for_books> data_for_books;
    ArrayList<Data_for_books> data_for_booksfull;
    private OnclickListner recyclerViewClickInterface;
    Context context;
ModelOfTable modelOfTable;
BuildeRoomDatabase buildeRoomDatabase;
    public Adpter_for_books(ArrayList<Data_for_books> data_for_books, OnclickListner recyclerViewClickInterface, Context context) {
        this.data_for_books = data_for_books;
        this.recyclerViewClickInterface = recyclerViewClickInterface;
        this.context = context;
        data_for_booksfull = new ArrayList<>(data_for_books);
    }

    @NonNull
    @Override
    public Box_of_Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_for_books, parent, false);
        buildeRoomDatabase=BuildeRoomDatabase.getInstance(view.getContext());
        return new Box_of_Vh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Box_of_Vh holder, int position) {
        final Data_for_books d = data_for_books.get(position);
        holder.textView.setText(d.getTitle());
        holder.imageView.setImageResource(d.getImage());
String name=d.getTitle()+"";
final int image=d.getImage();

        holder.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//
//        Toast.makeText(context, "add ", Toast.LENGTH_SHORT).show();
//        Toast.makeText(context, d.getTitle(), Toast.LENGTH_SHORT).show();
        modelOfTable=new ModelOfTable(d.getTitle(),"",d.getImage());
        buildeRoomDatabase.operationDao().Insertdata(modelOfTable);
        Toast.makeText(context, "add to favorite", Toast.LENGTH_SHORT).show();


    }
});


    }

    @Override
    public int getItemCount() {
        return data_for_books.size();
    }


    public class Box_of_Vh extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
      RatingBar ratingBar;
        public Box_of_Vh(@NonNull final View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_title_id);
            imageView = itemView.findViewById(R.id.book_img_id);
         ratingBar=itemView.findViewById(R.id.my_rating_par);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    recyclerViewClickInterface.onItemClick(getAdapterPosition());
                }
            });

        }
    }

    //    @Override
//    public Filter getFilter() {
//        return data_filter_list;
//    }
//    Filter data_filter_list = new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//
//            ArrayList<Data_for_books> filterlist = new ArrayList<>();
//            if (constraint == null || constraint.length() == 0) {
//                filterlist.addAll(data_for_booksfull);         /////////////////maybe
//            } else {
//                String filterpattern = constraint.toString().toLowerCase().trim();
//                for (Data_for_books book : data_for_booksfull) {
//                    if (book.getTitle().toLowerCase().contains(filterpattern)) {
//                        //data_book.add(filterpattern);
//                        filterlist.add(book);
//                    } } }
//
//            FilterResults filterResults = new FilterResults();
//            filterResults.values = filterlist;
//            return filterResults;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            data_for_books.clear();
//            data_for_books.addAll((ArrayList) results.values);
//            notifyDataSetChanged(); }
//    };
    public void setfilter(ArrayList<Data_for_books> dataForBooks) {

        data_for_books = new ArrayList<>();
        data_for_books.addAll(dataForBooks);
        notifyDataSetChanged();
    }
}
