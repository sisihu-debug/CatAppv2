package com.example.catappv2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.HashMap;

import static com.example.catappv2.FavCatsDatabase.favCats;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    View view;
    FavCatsDatabase favCatsDatabase;



//    HashMap<Integer, Integer> favCats = new HashMap<>();
//
//    public static HashMap<Integer, Integer> getFavCats (HashMap <Integer, Integer> favCats){
//        return favCats;
//    }


    public FavFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_fav, container, false);
        // Inflate the layout for this fragment


        recyclerView = view.findViewById(R.id.order_rv_main);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        //set adapter

        FavAdapter favAdapter = new FavAdapter();
        favAdapter.setData(FavCatsDatabase.getAllFavs());
        recyclerView.setAdapter(favAdapter);

        return view;







    }

}
