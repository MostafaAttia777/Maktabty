package com.Maktaba.MyBooks.BarFragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;

import com.Maktaba.MyBooks.Adpter_for_books;
import com.Maktaba.MyBooks.Data_for_books;
import com.Maktaba.MyBooks.OnclickListner;
import com.Maktaba.MyBooks.OpenBooks;
import com.Maktaba.MyBooks.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnglishFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Data_for_books> data_for_books;
    EditText editText;
    Adpter_for_books adpter_for_books;
    Context context;
    androidx.appcompat.widget.SearchView searchView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        context = getActivity();
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    public EnglishFragment() {
        // Required empty public constructor
    }

    OnclickListner onclickListner = new OnclickListner() {
        @Override
        public void onItemClick(int position) {
            openbook(position);
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_english, container, false);
        recyclerView = view.findViewById(R.id.my_rec_for_english_book);
        AdView mAdView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        data_for_books = new ArrayList<>();
        data_for_books.add(new Data_for_books(R.drawable.shaype, "Your Money or Your Life!"));
        data_for_books.add(new Data_for_books(R.drawable.bing, "Being Mortal"));
        data_for_books.add(new Data_for_books(R.drawable.mo100, "1001 Motivational Quotes for Success"));
        data_for_books.add(new Data_for_books(R.drawable.faums, "750 Famous Motivational"));
        data_for_books.add(new Data_for_books(R.drawable.cont, "Cognitive Psychology"));
        data_for_books.add(new Data_for_books(R.drawable.fondtion, "Foundations of Cognitive Psychology"));
        data_for_books.add(new Data_for_books(R.drawable.time, "The Time Machine"));
        data_for_books.add(new Data_for_books(R.drawable.thewor, "The War of the Worlds "));
        data_for_books.add(new Data_for_books(R.drawable.gift, "The Gift of the Magi"));
        data_for_books.add(new Data_for_books(R.drawable.sharlok, "The Sign Of Four "));
        data_for_books.add(new Data_for_books(R.drawable.littl, "A Little Princess "));
        data_for_books.add(new Data_for_books(R.drawable.mial, "The Mill on the Floss "));
        data_for_books.add(new Data_for_books(R.drawable.pdf, "World Wonders "));
        data_for_books.add(new Data_for_books(R.drawable.anna, "Anna Karenina by Leo Tolstoy "));
        data_for_books.add(new Data_for_books(R.drawable.crowad, "Far from the Madding Crowd "));
        data_for_books.add(new Data_for_books(R.drawable.dream, "A Dream Come True"));
        adpter_for_books = new Adpter_for_books(data_for_books, onclickListner, getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(adpter_for_books);
        return view;
    }


    private void openbook(int position) {
        Intent intent = new Intent(getContext(), OpenBooks.class);
        intent.putExtra("key", linkofbook().get(position));
        Toast.makeText(context, "Please wait.....", Toast.LENGTH_LONG + 100).show();
        startActivity(intent);
    }

    public ArrayList<String> linkofbook() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("https://ourrebellion.files.wordpress.com/2010/09/your-money-or-your-life.pdf");
        arrayList.add("https://firebasestorage.googleapis.com/v0/b/myfirstapp-43032.appspot.com/o/Being%20Mortal_%20Illness%2C%20Medicine%20and%20What%20Matters%20in%20the%20End%20(%20PDFDrive.com%20).pdf?alt=media&token=146c2e4e-2953-49ee-82af-89ae5b250c3c");
        arrayList.add("https://firebasestorage.googleapis.com/v0/b/myfirstapp-43032.appspot.com/o/1001_Motivational_Quotes_for_Success_Great_Quotes_from_Great_Minds.pdf?alt=media&token=b24abfc4-973b-4d46-a629-ba0eb46663de");
        arrayList.add("https://firebasestorage.googleapis.com/v0/b/myfirstapp-43032.appspot.com/o/750-Famous-Quotes.pdf?alt=media&token=30987bca-438f-4e4d-98b1-4b69e3fcc186");
        arrayList.add("https://firebasestorage.googleapis.com/v0/b/myfirstapp-43032.appspot.com/o/Cognitive%20Psychology%20(%20PDFDrive.com%20).pdf?alt=media&token=6202e3d6-197c-42f3-9e90-95b2a5f2986e");
        arrayList.add("https://firebasestorage.googleapis.com/v0/b/myfirstapp-43032.appspot.com/o/Foundations%20of%20Cognitive%20Psychology.pdf?alt=media&token=24bc55a5-f122-4032-b363-7dccd4e390da");
        arrayList.add("https://planetpdf.com/planetpdf/pdfs/free_ebooks/The_Time_Machine_NT.pdf");
        arrayList.add("https://www.planetpublish.com/wp-content/uploads/2011/11/The_War_of_the_Worlds_NT.pdf");
        arrayList.add("https://americanenglish.state.gov/files/ae/resource_files/1-the_gift_of_the_magi_0.pdf");
        arrayList.add("https://sherlock-holm.es/stories/pdf/a4/1-sided/sign.pdf");
        arrayList.add("https://firebasestorage.googleapis.com/v0/b/myfirstapp-43032.appspot.com/o/a-little-princess-001-chapter-1-sara.pdf?alt=media&token=abc5732f-f4bf-4c93-898c-92fcc068c592");
        arrayList.add("https://www.bartleby.com/ebook/adobe/309.pdf");
        arrayList.add("https://www.pearson.ch/download/restricted/PRANSWERKEYS/9781292110363_TN_Wonders-of-the-World.pdf");
        arrayList.add("https://planetpdf.com/planetpdf/pdfs/free_ebooks/Anna_Karenina_NT.pdf");
        arrayList.add("https://firebasestorage.googleapis.com/v0/b/myfirstapp-43032.appspot.com/o/far-from-the-madding-crowd.pdf?alt=media&token=59b2a0c5-c16a-4617-806f-374bc7d9c64d");
        arrayList.add("https://fernandamaterial2014.files.wordpress.com/2014/05/a-dream-come-true.pdf");
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");

        return arrayList;

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.ic_search_icon, menu);
        final MenuItem menuItem = menu.findItem(R.id.my_filter_icon);
        searchView = (androidx.appcompat.widget.SearchView) menuItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);

                }
                menuItem.collapseActionView();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ArrayList<Data_for_books> data = filter(data_for_books, newText);
                adpter_for_books.setfilter(data);
                return true;
            }
        });


//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adpter_for_books.getFilter().filter(newText);
//                return false;
//            }
//        });


    }

    private ArrayList<Data_for_books> filter(ArrayList<Data_for_books> p1, String query) {

        query = query.toLowerCase();
        final ArrayList<Data_for_books> filterformodel = new ArrayList<>();
        for (Data_for_books for_books : p1) {
            final String text = for_books.getTitle().toLowerCase();
            if (text.startsWith(query)) {
                filterformodel.addAll(Collections.singleton(for_books));
            }

        }
        return filterformodel;
    }
}