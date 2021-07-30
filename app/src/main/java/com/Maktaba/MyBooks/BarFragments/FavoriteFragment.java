package com.Maktaba.MyBooks.BarFragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.Maktaba.MyBooks.Ad_for_custom_heart;
import com.Maktaba.MyBooks.R;
import com.Maktaba.MyBooks.Room.BuildeRoomDatabase;
import com.Maktaba.MyBooks.Room.ModelOfTable;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {
    BuildeRoomDatabase buildeRoomDatabase;
    RecyclerView recyclerView;
    Ad_for_custom_heart ad_for_custom_heart;
    ArrayList<ModelOfTable> modelOfTables;
    Context context;
    androidx.appcompat.widget.SearchView searchView;
    Button button;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        context = getActivity();
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_favorite, container, false);
        buildeRoomDatabase = BuildeRoomDatabase.getInstance(v.getContext());
        AdView mAdView = (AdView) v.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        // button = v.findViewById(R.id.delete_btn);
        recyclerView = v.findViewById(R.id.my_rc_for_fiv);
        ArrayList<ModelOfTable> show = (ArrayList<ModelOfTable>) buildeRoomDatabase.operationDao().getalll();
        ad_for_custom_heart = new Ad_for_custom_heart(show);
        recyclerView.setAdapter(ad_for_custom_heart);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        //ArrayList<ModelOfTable> modelOfTables= (ArrayList<ModelOfTable>) buildeRoomDatabase.operationDao().getalll();
        //Toast.makeText(getActivity(), modelOfTables.size(), Toast.LENGTH_SHORT).show();


        return v;
    }

}