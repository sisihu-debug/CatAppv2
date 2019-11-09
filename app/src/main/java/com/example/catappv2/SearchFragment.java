package com.example.catappv2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpResponse;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private RecyclerView recyclerView;
    View view;
    RecyclerView.LayoutManager layoutManager;



    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_search, container, false);

        //Initialise the adapter
        final CatAdapter catAdapter = new CatAdapter();

        //Initialise the Recycler view and bind adapter

        recyclerView = view.findViewById(R.id.rv_main);
        recyclerView.setAdapter(catAdapter);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);


//      create request queue

        final RequestQueue requestQueue =  Volley.newRequestQueue(getActivity());

//

        String url = "https://api.thecatapi.com/v1/breeds/search?q=beng";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();


//              Attempt 1:

//                CatMeta[] catMeta = gson.fromJson(response,CatMeta[].class);
//
//                List<CatMeta> catsList = Arrays.asList(catMeta);
//
//                ArrayList<Cat> catsArrayList = new ArrayList<Cat>(catsList);
//
//
//
//                catAdapter.setData();

                Cat[] catMeta = gson.fromJson(response,Cat[].class);

                List<Cat> catsList = Arrays.asList(catMeta);

                ArrayList<Cat> catsArrayList = new ArrayList<Cat>(catsList);

                catAdapter.setData(catsArrayList);

                recyclerView.setAdapter(catAdapter);


            }

            };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("GSON VOLLEY ERROR!!!");
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        requestQueue.add(stringRequest);

        return view;


    }

}
