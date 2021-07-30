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
public class IslamicFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Data_for_books> data_for_books;
    Adpter_for_books adpter_for_books;

    Context context;
    androidx.appcompat.widget.SearchView searchView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        context = getActivity();
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }
    public IslamicFragment() {
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

        View view = inflater.inflate(R.layout.fragment_islamic, container, false);
        recyclerView = view.findViewById(R.id.my_rec_for_islamic_book);
        AdView mAdView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        data_for_books = new ArrayList<>();
        data_for_books.add(new Data_for_books(R.drawable.po5ary, "صحيح البخاري"));
        data_for_books.add(new Data_for_books(R.drawable.muslam, "صحيح مسلم"));
        data_for_books.add(new Data_for_books(R.drawable.meet, "لقاء مع الرسول"));
        data_for_books.add(new Data_for_books(R.drawable.dose, "ألواح ودسر"));
        data_for_books.add(new Data_for_books(R.drawable.humen, "إنسان جديد"));
        data_for_books.add(new Data_for_books(R.drawable.frands, "مدرسة الصحابة"));
        data_for_books.add(new Data_for_books(R.drawable.ahmed1, "لو كان بيننا"));
        data_for_books.add(new Data_for_books(R.drawable.story, "قصص الأنبياء"));
        data_for_books.add(new Data_for_books(R.drawable.sayed, "في ظلال القرآنء"));
        data_for_books.add(new Data_for_books(R.drawable.sxsxsx, "كتاب إلي الله"));
        data_for_books.add(new Data_for_books(R.drawable.waytoquran, " الطريق إلى القرآن"));
        data_for_books.add(new Data_for_books(R.drawable.theytreedyou, " خدعوك فقالوا"));
        data_for_books.add(new Data_for_books(R.drawable.sadnes, "هموم داعية"));
        data_for_books.add(new Data_for_books(R.drawable.traugary, "الكنز المفقود"));
        data_for_books.add(new Data_for_books(R.drawable.lookatquran, "نظرات في القران"));
        data_for_books.add(new Data_for_books(R.drawable.bokofhades, "السنة النبوية بين أهل الفقه وأهل الحديث"));
        data_for_books.add(new Data_for_books(R.drawable.darkfromleft, "ظلام في الغرب"));
        data_for_books.add(new Data_for_books(R.drawable.headandheart, "ركائز الايمان بين العقل والقلب"));
        data_for_books.add(new Data_for_books(R.drawable.handred, "مائة سؤال عن الإسلام"));
        data_for_books.add(new Data_for_books(R.drawable.withmostafa, "مع المصطفى سلمان العودة "));
        data_for_books.add(new Data_for_books(R.drawable.greanbook, "صيد الخاطر "));
        data_for_books.add(new Data_for_books(R.drawable.twocountry, "عصر الدولتين الأموية والعباسية "));
        data_for_books.add(new Data_for_books(R.drawable.kaderandkdea, "القضاء والقدر "));
        data_for_books.add(new Data_for_books(R.drawable.soulofhumen, "الله والنفس البشرية"));
        data_for_books.add(new Data_for_books(R.drawable.profats, "دعاء الانبياء والصالحين"));
        data_for_books.add(new Data_for_books(R.drawable.razk, "تلك هي الارزاق"));
        data_for_books.add(new Data_for_books(R.drawable.butwithgod, "ولكن كونو ربانيين"));
        data_for_books.add(new Data_for_books(R.drawable.word, "تجسد الكلمة"));
        data_for_books.add(new Data_for_books(R.drawable.anserfromgod, "اجابات الله على اسئلة الحياة الصعبة"));
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

    private ArrayList<String> linkofbook() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%B5%D8%AD%D9%8A%D8%AD%20%D8%A7%D9%84%D8%A8%D8%AE%D8%A7%D8%B1%D9%8A%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%A8%D9%86%20%D8%A5%D8%B3%D9%85%D8%A7%D8%B9%D9%8A%D9%84%20%D8%A7%D9%84%D8%A8%D8%AE%D8%A7%D8%B1%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%B5%D8%AD%D9%8A%D8%AD%20%D9%85%D8%B3%D9%84%D9%85%20%D9%85%D8%B3%D9%84%D9%85%20%D8%A8%D9%86%20%D8%A7%D9%84%D8%AD%D8%AC%D8%A7%D8%AC%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%84%D9%82%D8%A7%D8%A1%20%D9%85%D8%B9%20%D8%A7%D9%84%D8%B1%D8%B3%D9%88%D9%84%20%D8%AE%D8%A7%D9%84%D8%AF%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%AE%D8%A7%D9%84%D8%AF%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A3%D9%84%D9%88%D8%A7%D8%AD%20%D9%88%D8%AF%D8%B3%D8%B1%20%D8%A3%D8%AD%D9%85%D8%AF%20%D8%AE%D9%8A%D8%B1%D9%8A%20%D8%A7%D9%84%D8%B9%D9%85%D8%B1%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A5%D9%86%D8%B3%D8%A7%D9%86%20%D8%AC%D8%AF%D9%8A%D8%AF%20%D9%85%D8%B5%D8%B7%D9%81%D9%89%20%D8%AD%D8%B3%D9%86%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%85%D8%AF%D8%B1%D8%B3%D8%A9%20%D8%A7%D9%84%D8%B5%D8%AD%D8%A7%D8%A8%D8%A9%20%D8%AC%D9%87%D8%A7%D8%AF%20%D8%A7%D9%84%D8%AA%D8%B1%D8%A8%D8%A7%D9%86%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%84%D9%88%20%D9%83%D8%A7%D9%86%20%D8%A8%D9%8A%D9%86%D9%86%D8%A7%20%D8%A3%D8%AD%D9%85%D8%AF%20%D8%A7%D9%84%D8%B4%D9%82%D9%8A%D8%B1%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%82%D8%B5%D8%B5%20%20%D8%A7%D9%84%D8%A3%D9%86%D8%A8%D9%8A%D8%A7%D8%A1%20%D9%85%D8%AD%D9%85%D8%AF%20%D9%85%D8%AA%D9%88%D9%84%D9%8A%20%D8%A7%D9%84%D8%B4%D8%B9%D8%B1%D8%A7%D9%88%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%81%D9%8A%20%D8%B8%D9%84%D8%A7%D9%84%20%D8%A7%D9%84%D9%82%D8%B1%D8%A2%D9%86%20%D8%B3%D9%8A%D8%AF%20%D9%82%D8%B7%D8%A8%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A5%D9%84%D9%8A%20%D8%A7%D9%84%D9%84%D9%87%20%D8%A3%D9%85%D9%8A%D8%B1%20%D9%85%D9%86%D9%8A%D8%B1%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A7%D9%84%D8%B7%D8%B1%D9%8A%D9%82%20%D8%A5%D9%84%D9%89%20%D8%A7%D9%84%D9%82%D8%B1%D8%A2%D9%86%20%D8%A5%D8%A8%D8%B1%D8%A7%D9%87%D9%8A%D9%85%20%D8%B9%D9%85%D8%B1%20%D8%A7%D9%84%D8%B3%D9%83%D8%B1%D8%A7%D9%86%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%AE%D8%AF%D8%B9%D9%88%D9%83%20%D9%81%D9%82%D8%A7%D9%84%D9%88%D8%A7%20%D9%85%D8%B5%D8%B7%D9%81%D9%89%20%D8%AD%D8%B3%D9%86%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%87%D9%85%D9%88%D9%85%20%D8%AF%D8%A7%D8%B9%D9%8A%D8%A9%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%A7%D9%84%D8%BA%D8%B2%D8%A7%D9%84%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A7%D9%84%D9%83%D9%86%D8%B2%20%D8%A7%D9%84%D9%85%D9%81%D9%82%D9%88%D8%AF%20%D9%85%D8%B5%D8%B7%D9%81%D9%89%20%D8%AD%D8%B3%D9%86%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%86%D8%B8%D8%B1%D8%A7%D8%AA%20%D9%81%D9%8A%20%D8%A7%D9%84%D9%82%D8%B1%D8%A2%D9%86%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%A7%D9%84%D8%BA%D8%B2%D8%A7%D9%84%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A7%D9%84%D8%B3%D9%86%D8%A9%20%D8%A7%D9%84%D9%86%D8%A8%D9%88%D9%8A%D8%A9%20%D8%A8%D9%8A%D9%86%20%D8%A3%D9%87%D9%84%20%D8%A7%D9%84%D9%81%D9%82%D9%87%20%D9%88%D8%A3%D9%87%D9%84%20%D8%A7%D9%84%D8%AD%D8%AF%D9%8A%D8%AB%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%A7%D9%84%D8%BA%D8%B2%D8%A7%D9%84%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%B8%D9%84%D8%A7%D9%85%20%D9%85%D9%86%20%D8%A7%D9%84%D8%BA%D8%B1%D8%A8%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%A7%D9%84%D8%BA%D8%B2%D8%A7%D9%84%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%B1%D9%83%D8%A7%D8%A6%D8%B2%20%D8%A7%D9%84%D8%A5%D9%8A%D9%85%D8%A7%D9%86%20%D8%A8%D9%8A%D9%86%20%D8%A7%D9%84%D8%B9%D9%82%D9%84%20%D9%88%D8%A7%D9%84%D9%82%D9%84%D8%A8%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%A7%D9%84%D8%BA%D8%B2%D8%A7%D9%84%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%85%D8%A7%D8%A6%D8%A9%20%D8%B3%D8%A4%D8%A7%D9%84%20%D8%B9%D9%86%20%D8%A7%D9%84%D8%A5%D8%B3%D9%84%D8%A7%D9%85%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%A7%D9%84%D8%BA%D8%B2%D8%A7%D9%84%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%85%D8%B9%20%D8%A7%D9%84%D9%85%D8%B5%D8%B7%D9%81%D9%89%20%D8%B3%D9%84%D9%85%D8%A7%D9%86%20%D8%A7%D9%84%D8%B9%D9%88%D8%AF%D8%A9%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%B5%D9%8A%D8%AF%20%D8%A7%D9%84%D8%AE%D8%A7%D8%B7%D8%B1%20%D8%A7%D8%A8%D9%86%20%D8%A7%D9%84%D8%AC%D9%88%D8%B2%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%B9%D8%B5%D8%B1%20%D8%A7%D9%84%D8%AF%D9%88%D9%84%D8%AA%D9%8A%D9%86%20%D8%A7%D9%84%D8%A3%D9%85%D9%88%D9%8A%D8%A9%20%D9%88%D8%A7%D9%84%D8%B9%D8%A8%D8%A7%D8%B3%D9%8A%D8%A9%20%D9%88%D8%B8%D9%87%D9%88%D8%B1%20%D9%81%D9%83%D8%B1%20%D8%A7%D9%84%D8%AE%D9%88%D8%A7%D8%B1%D8%AC%20%D8%B9%D9%84%D9%8A%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%A7%D9%84%D8%B5%D9%84%D8%A7%D8%A8%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A7%D9%84%D9%82%D8%B6%D8%A7%D8%A1%20%D9%88%D8%A7%D9%84%D9%82%D8%AF%D8%B1%20%D9%85%D8%AD%D9%85%D8%AF%20%D9%85%D8%AA%D9%88%D9%84%D9%8A%20%D8%A7%D9%84%D8%B4%D8%B9%D8%B1%D8%A7%D9%88%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A7%D9%84%D9%84%D9%87%20%D9%88%D8%A7%D9%84%D9%86%D9%81%D8%B3%20%D8%A7%D9%84%D8%A8%D8%B4%D8%B1%D9%8A%D8%A9%20%D9%85%D8%AD%D9%85%D8%AF%20%D9%85%D8%AA%D9%88%D9%84%D9%8A%20%D8%A7%D9%84%D8%B4%D8%B9%D8%B1%D8%A7%D9%88%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%AF%D8%B9%D8%A7%D8%A1%20%D8%A7%D9%84%D8%A7%D9%86%D8%A8%D9%8A%D8%A7%D8%A1%20%D9%88%D8%A7%D9%84%D8%B5%D8%A7%D9%84%D8%AD%D9%8A%D9%86%20%D9%85%D8%AD%D9%85%D8%AF%20%D9%85%D8%AA%D9%88%D9%84%D9%8A%20%D8%A7%D9%84%D8%B4%D8%B9%D8%B1%D8%A7%D9%88%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%AA%D9%84%D9%83%20%D9%87%D9%89%20%D8%A7%D9%84%D8%A7%D8%B1%D8%B2%D8%A7%D9%82%20%D9%85%D8%AD%D9%85%D8%AF%20%D9%85%D8%AA%D9%88%D9%84%D9%8A%20%D8%A7%D9%84%D8%B4%D8%B9%D8%B1%D8%A7%D9%88%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%88%D9%84%D9%83%D9%86%20%D9%83%D9%88%D9%86%D9%88%D8%A7%20%D8%B1%D8%A8%D8%A7%D9%86%D9%8A%D9%8A%D9%86%20%D8%B3%D9%84%D9%85%D8%A7%D9%86%20%D8%A7%D9%84%D8%B9%D9%88%D8%AF%D8%A9%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");

        arrayList.add("https://firebasestorage.googleapis.com/v0/b/mushaf-e490a.appspot.com/o/coptic-books.blogspot.com_tagsod_el%20klma.pdf?alt=media&token=48d59ea9-a38a-4362-800b-2f00edd818c1");

        arrayList.add("https://firebasestorage.googleapis.com/v0/b/mushaf-e490a.appspot.com/o/%5Bchristianlib.com%5D%20%20-%20%20%D8%B1%D9%8A%D9%83%20%D9%88%D8%A7%D8%B1%D9%8A%D9%86-%20%20%D8%A5%D8%AC%D8%A7%D8%A8%D8%A7%D8%AA%20%D8%A7%D9%84%D9%84%D9%87%20%D8%B9%D9%84%D9%89%20%D8%A3%D8%B3%D8%A6%D9%84%D8%A9%20%D8%A7%D9%84%D8%AD%D9%8A%D8%A7%D8%A9%20%D8%A7%D9%84%D8%B5%D8%B9%D8%A8%D8%A9.pdf?alt=media&token=cda10fd3-e4d4-4006-aca9-e343df16b6bb");
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
