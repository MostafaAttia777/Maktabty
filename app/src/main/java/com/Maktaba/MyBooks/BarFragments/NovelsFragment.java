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
public class NovelsFragment extends Fragment {

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
    public NovelsFragment() {
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
        View view = inflater.inflate(R.layout.fragment_novels, container, false);
        recyclerView = view.findViewById(R.id.my_rec_for_novels_book);

        AdView mAdView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        data_for_books = new ArrayList<>();
        data_for_books.add(new Data_for_books(R.drawable.acts, "اكستاسي"));
        data_for_books.add(new Data_for_books(R.drawable.sh, "شايب"));
        data_for_books.add(new Data_for_books(R.drawable.youtobya, "يوتوبيا"));
        data_for_books.add(new Data_for_books(R.drawable.hapta, "هيبتا"));
        data_for_books.add(new Data_for_books(R.drawable.ala, "الآلة"));
        data_for_books.add(new Data_for_books(R.drawable.gom3a, "في كل اسبوع جمعة"));
        data_for_books.add(new Data_for_books(R.drawable.tnen, "رقصة مع التنانين"));
        data_for_books.add(new Data_for_books(R.drawable.afreat, "عفريت العلبه"));
        data_for_books.add(new Data_for_books(R.drawable.days, "أيامنا الحلوة"));
        data_for_books.add(new Data_for_books(R.drawable.ppp, "بربونيا"));
        data_for_books.add(new Data_for_books(R.drawable.nothing, "لا شيء مما سبقا"));
        data_for_books.add(new Data_for_books(R.drawable.security, "حارس سطح العالم"));
        data_for_books.add(new Data_for_books(R.drawable.month, "شهرزاد اون فاير"));
        data_for_books.add(new Data_for_books(R.drawable.miner, "المنجم"));
        data_for_books.add(new Data_for_books(R.drawable.kash, "كش ملك"));
        data_for_books.add(new Data_for_books(R.drawable.calm, "فاطمئن"));
        data_for_books.add(new Data_for_books(R.drawable.leader, "سحر القيادة"));
        data_for_books.add(new Data_for_books(R.drawable.text, "الخروج عن النص"));
        data_for_books.add(new Data_for_books(R.drawable.savwd, "مخطوطة وجدت في عكرا"));
        data_for_books.add(new Data_for_books(R.drawable.die, "مبنى الرجل الميت"));
        data_for_books.add(new Data_for_books(R.drawable.mastry, "لغز سيتافورد"));
        data_for_books.add(new Data_for_books(R.drawable.frankfort, "مسافر إلى فرانكفورت"));
        data_for_books.add(new Data_for_books(R.drawable.advtnger, "مغامرة ثلاثة رجال يحملون اللقب جاريديب"));
        data_for_books.add(new Data_for_books(R.drawable.ging, "عصابة الأربعة"));
        data_for_books.add(new Data_for_books(R.drawable.nader, "نادر فودة 4 عمارة الفزع"));
        data_for_books.add(new Data_for_books(R.drawable.sandral, "سندريلا سيكريت"));
        data_for_books.add(new Data_for_books(R.drawable.blacsleep, "النوم الأسود"));
        data_for_books.add(new Data_for_books(R.drawable.twohoures, "ساعتين وداع"));
        data_for_books.add(new Data_for_books(R.drawable.see, "ساعتين وداع"));
        data_for_books.add(new Data_for_books(R.drawable.bluehear, "قلب ازرق"));
        data_for_books.add(new Data_for_books(R.drawable.blackcastle, "القصر الأسود"));
        data_for_books.add(new Data_for_books(R.drawable.houesofsecreat, "منزل التعويذة"));
        data_for_books.add(new Data_for_books(R.drawable.sonofdevil, "مخطوطة ابن الشيطان"));
        data_for_books.add(new Data_for_books(R.drawable.sevfn, "سبع سنبلات"));
        data_for_books.add(new Data_for_books(R.drawable.flatoftawondown, "شقة وسط البلد"));
        data_for_books.add(new Data_for_books(R.drawable.tomp, "أفراح المقبرة"));
        data_for_books.add(new Data_for_books(R.drawable.box, "الآن نفتح الصندوق 1"));
        data_for_books.add(new Data_for_books(R.drawable.taha, "لحظات"));
        data_for_books.add(new Data_for_books(R.drawable.revalgon, "هل تمردت بفعلتي"));
        data_for_books.add(new Data_for_books(R.drawable.dasret, "في صحراء ليبيا"));
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
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A7%D9%83%D8%B3%D8%AA%D8%A7%D8%B3%D9%8A%20%D8%B9%D8%A8%D8%AF%D8%A7%D9%84%D9%87%D8%A7%D8%AF%D9%8A%20%D8%A7%D9%84%D8%B9%D9%85%D8%B4%D8%A7%D9%86%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://firebasestorage.googleapis.com/v0/b/myfirstapp-43032.appspot.com/o/%D9%85%D9%83%D8%AA%D8%A8%D8%A9%20%D9%86%D9%88%D8%B1%20%D8%B4%D8%A2%D8%A8%D9%8A%D8%A8.pdf?alt=media&token=ceb06d1b-81e4-49c0-ac8d-ede3ced62dbe");
        arrayList.add("https://firebasestorage.googleapis.com/v0/b/myfirstapp-43032.appspot.com/o/%D9%85%D9%83%D8%AA%D8%A8%D8%A9%20%D9%86%D9%88%D8%B1%20%D8%B1%D9%88%D8%A7%D9%8A%D8%A9%20%D9%8A%D9%88%D8%AA%D9%88%D8%A8%D9%8A%D8%A7%20%D9%84%D9%84%D9%83%D8%A7%D8%AA%D8%A8%20%D8%A3%D8%AD%D9%85%D8%AF%20%D8%AE%D8%A7%D9%84%D8%AF%20%D8%AA%D9%88%D9%81%D9%8A%D9%82.pdf?alt=media&token=9d095e9c-22ce-4f94-898e-ea502e638e16");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%87%D9%8A%D8%A8%D8%AA%D8%A7%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%B5%D8%A7%D8%AF%D9%82%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A7%D9%84%D8%A2%D9%84%D8%A9%20%D8%B9%D9%85%D8%B1%D9%88%20%D8%A7%D9%84%D8%AC%D9%86%D8%AF%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%81%D9%8A%20%D9%83%D9%84%20%D8%A3%D8%B3%D8%A8%D9%88%D8%B9..%20%D9%8A%D9%88%D9%85%20%D8%AC%D9%85%D8%B9%D8%A9%20%D8%A5%D8%A8%D8%B1%D8%A7%D9%87%D9%8A%D9%85%20%D8%B9%D8%A8%D8%AF%20%D8%A7%D9%84%D9%85%D8%AC%D9%8A%D8%AF%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%B1%D9%82%D8%B5%D8%A9%20%D9%85%D8%B9%20%D8%A7%D9%84%D8%AA%D9%86%D8%A7%D9%86%D9%8A%D9%86%20%D8%AC%D9%88%D8%B1%D8%AC%20%D9%85%D8%A7%D8%B1%D8%AA%D9%86%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%B9%D9%81%D8%B1%D9%8A%D8%AA%20%D8%A7%D9%84%D8%B9%D9%84%D8%A8%D9%87%20%D8%B9%D9%85%D8%B1%D9%88%20%D8%A7%D9%84%D8%A8%D8%AF%D8%A7%D9%84%D9%89%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A3%D9%8A%D8%A7%D9%85%D9%86%D8%A7%20%D8%A7%D9%84%D8%AD%D9%84%D9%88%D8%A9%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%A7%D8%A8%D8%B1%D8%A7%D9%87%D9%8A%D9%85%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A8%D8%B1%D8%A8%D9%88%D9%86%D9%8A%D8%A7%20%D8%B9%D9%85%D8%B1%D9%88%20%D8%A7%D9%84%D8%A8%D8%AF%D8%A7%D9%84%D9%89%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%84%D8%A7%20%D8%B4%D8%A6%20%D9%85%D9%85%D8%A7%20%D8%B3%D8%A8%D9%82%20%D8%A3%D9%85%D9%8A%D8%B1%20%D8%B9%D8%A7%D8%B7%D9%81%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%AD%D8%A7%D8%B1%D8%B3%20%D8%B3%D8%B7%D8%AD%20%D8%A7%D9%84%D8%B9%D8%A7%D9%84%D9%85%20%D8%A8%D8%AB%D9%8A%D9%86%D8%A9%20%D8%A7%D9%84%D8%B9%D9%8A%D8%B3%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%B4%D9%87%D8%B1%D8%B2%D8%A7%D8%AF%20%D8%A7%D9%88%D9%86%20%D9%81%D8%A7%D9%8A%D8%B1%20%D9%87%D8%A8%D8%A9%20%D8%A7%D9%84%D8%B3%D9%88%D8%A7%D8%AD%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A7%D9%84%D9%85%D9%86%D8%AC%D9%85%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%B1%D8%AC%D8%A8%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%83%D8%B4%20%D9%85%D9%84%D9%83%20%D8%A3%D8%AF%D9%87%D9%85%20%D8%B4%D8%B1%D9%82%D8%A7%D9%88%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%26lrm%3B%D9%81%D8%A7%D8%B7%D9%85%D8%A6%D9%86%26lrm%3B%20%D8%B9%D9%85%D8%B1%20%D8%A7%D9%84%20%D8%B9%D9%88%D8%B6%D9%87%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%B3%D8%AD%D8%B1%20%D8%A7%D9%84%D9%82%D9%8A%D8%A7%D8%AF%D8%A9%20%D8%A5%D8%A8%D8%B1%D8%A7%D9%87%D9%8A%D9%85%20%D8%A7%D9%84%D9%81%D9%82%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A7%D9%84%D8%AE%D8%B1%D9%88%D8%AC%20%D8%B9%D9%86%20%D8%A7%D9%84%D9%86%D8%B5%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%B7%D8%A9%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%85%D8%AE%D8%B7%D9%88%D8%B7%D8%A9%20%D9%88%D8%AC%D8%AF%D8%AA%20%D9%81%D9%8A%20%D8%B9%D9%83%D8%B1%D8%A7%20%D8%A8%D8%A7%D9%88%D9%84%D9%88%20%D9%83%D9%88%D9%8A%D9%84%D9%88%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%85%D8%A8%D9%86%D9%89%20%D8%A7%D9%84%D8%B1%D8%AC%D9%84%20%D8%A7%D9%84%D9%85%D9%8A%D8%AA%20%D8%A3%D8%AC%D8%A7%D8%AB%D8%A7%20%D9%83%D8%B1%D9%8A%D8%B3%D8%AA%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%84%D8%BA%D8%B2%20%D8%B3%D9%8A%D8%AA%D8%A7%D9%81%D9%88%D8%B1%D8%AF%20%D8%A3%D8%AC%D8%A7%D8%AB%D8%A7%20%D9%83%D8%B1%D9%8A%D8%B3%D8%AA%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%85%D8%B3%D8%A7%D9%81%D8%B1%20%D8%A5%D9%84%D9%89%20%D9%81%D8%B1%D8%A7%D9%86%D9%83%D9%81%D9%88%D8%B1%D8%AA%20%D8%A3%D8%AC%D8%A7%D8%AB%D8%A7%20%D9%83%D8%B1%D9%8A%D8%B3%D8%AA%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%85%D8%BA%D8%A7%D9%85%D8%B1%D8%A9%20%D8%AB%D9%84%D8%A7%D8%AB%D8%A9%20%D8%B1%D8%AC%D8%A7%D9%84%20%D9%8A%D8%AD%D9%85%D9%84%D9%88%D9%86%20%D8%A7%D9%84%D9%84%D9%82%D8%A8%20%D8%AC%D8%A7%D8%B1%D9%8A%D8%AF%D9%8A%D8%A8%20%20%D8%A2%D8%B1%D8%AB%D8%B1%20%D9%83%D9%88%D9%86%D8%A7%D9%86%20%D8%AF%D9%88%D9%8A%D9%84%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%B9%D8%B5%D8%A7%D8%A8%D8%A9%20%D8%A7%D9%84%D8%A3%D8%B1%D8%A8%D8%B9%D8%A9%20%20%D8%A2%D8%B1%D8%AB%D8%B1%20%D9%83%D9%88%D9%86%D8%A7%D9%86%20%D8%AF%D9%88%D9%8A%D9%84%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%86%D8%A7%D8%AF%D8%B1%20%D9%81%D9%88%D8%AF%D8%A9%204%20-%20%D8%B9%D9%85%D8%A7%D8%B1%D8%A9%20%D8%A7%D9%84%D9%81%D8%B2%D8%B9%20%D8%A3%D8%AD%D9%85%D8%AF%20%D9%8A%D9%88%D9%86%D8%B3%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%B3%D9%86%D8%AF%D8%B1%D9%8A%D9%84%D8%A7%20%D8%B3%D9%8A%D9%83%D8%B1%D9%8A%D8%AA%20%D9%87%D8%A8%D8%A9%20%D8%A7%D9%84%D8%B3%D9%88%D8%A7%D8%AD%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A7%D9%84%D9%86%D9%88%D9%85%20%D8%A7%D9%84%D8%A3%D8%B3%D9%88%D8%AF%20%D9%85%D8%B1%D9%88%D9%89%20%D8%AC%D9%88%D9%87%D8%B1%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%B3%D8%A7%D8%B9%D8%AA%D9%8A%D9%86%20%D9%88%D8%AF%D8%A7%D8%B9%20%D8%A3%D8%AD%D9%85%D8%AF%20%D9%85%D9%87%D9%86%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%85%D8%A7%20%D8%B1%D9%88%D8%A7%D9%87%20%D8%A7%D9%84%D8%A8%D8%AD%D8%B1%20%D8%B3%D8%A7%D9%86%D8%AF%D8%B1%D8%A7%20%D8%B3%D8%B1%D8%A7%D8%AC%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%82%D9%84%D8%A8%20%D8%A7%D8%B2%D8%B1%D9%82%20%D8%A2%D9%85%D8%A7%D9%84%D9%8A%D8%A7%20%D8%AD%D9%84%D9%88%D8%A9%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A7%D9%84%D9%82%D8%B5%D8%B1%20%D8%A7%D9%84%D8%A3%D8%B3%D9%88%D8%AF%20%D9%85%D9%86%D9%8A%20%D8%B3%D9%84%D8%A7%D9%85%D8%A9%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%85%D9%86%D8%B2%D9%84%20%D8%A7%D9%84%D8%AA%D8%B9%D9%88%D9%8A%D8%B0%D8%A9%20%D9%85%D8%B1%D9%88%D9%89%20%D8%AC%D9%88%D9%87%D8%B1%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%85%D8%AE%D8%B7%D9%88%D8%B7%D8%A9%20%D8%A7%D8%A8%D9%86%20%D8%A7%D9%84%D8%B4%D9%8A%D8%B7%D8%A7%D9%86%20%D8%B9%D9%85%D8%B1%D9%88%20%D8%A7%D9%84%D9%85%D9%86%D9%88%D9%81%D9%8A%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%B3%D8%A8%D8%B9%20%D8%B3%D9%86%D8%A8%D9%84%D8%A7%D8%AA%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%A7%D8%A8%D8%B1%D8%A7%D9%87%D9%8A%D9%85%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%B4%D9%82%D8%A9%20%D9%88%D8%B3%D8%B7%20%D8%A7%D9%84%D8%A8%D9%84%D8%AF%20%D8%AA%D8%A7%D9%85%D8%B1%20%D8%B9%D8%B7%D9%88%D8%A9%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A3%D9%81%D8%B1%D8%A7%D8%AD%20%D8%A7%D9%84%D9%85%D9%82%D8%A8%D8%B1%D8%A9%20%D8%A3%D8%AD%D9%85%D8%AF%20%D8%AE%D8%A7%D9%84%D8%AF%20%D8%AA%D9%88%D9%81%D9%8A%D9%82%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D8%A7%D9%84%D8%A2%D9%86%20%D9%86%D9%81%D8%AA%D8%AD%20%D8%A7%D9%84%D8%B5%D9%86%D8%AF%D9%88%D9%82%201%20%D8%A3%D8%AD%D9%85%D8%AF%20%D8%AE%D8%A7%D9%84%D8%AF%20%D8%AA%D9%88%D9%81%D9%8A%D9%82%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%84%D8%AD%D8%B8%D8%A7%D8%AA%20%D8%B7%D8%A9%20%D8%AD%D8%B3%D9%8A%D9%86%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%87%D9%84%20%D8%AA%D9%85%D8%B1%D8%AF%D8%AA%D9%8F%20%D8%A8%D9%81%D8%B9%D9%84%D8%AA%D9%90%D9%80%D9%80%D9%8A%20%D8%AE%D9%86%D8%B3%D8%A7%D8%A1%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
        arrayList.add("https://www.4read.net/uploads/pdf/%D9%81%D9%8A%20%D8%B5%D8%AD%D8%B1%D8%A7%D8%A1%20%D9%84%D9%8A%D8%A8%D9%8A%D8%A7%20%D8%A3%D8%AD%D9%85%D8%AF%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%AD%D8%B3%D9%86%D9%8A%D9%86%20%D8%A8%D8%A7%D8%B4%D8%A7%20%23%D9%81%D9%88%D8%B1_%D8%B1%D9%8A%D8%AF.pdf");
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