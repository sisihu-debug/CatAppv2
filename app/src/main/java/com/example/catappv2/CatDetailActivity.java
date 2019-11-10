package com.example.catappv2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatDetailActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView temperamentTextView;
    private TextView wikiTextView;
    private TextView originTextView;
    private TextView dogfriendlyTextView;
    private TextView weightTextView;
    private TextView lifespanTextView;
    private TextView descriptionTextView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_detail);

        nameTextView = findViewById(R.id.detailName);
        temperamentTextView = findViewById(R.id.detailTemperament);
        wikiTextView = findViewById(R.id.detailWiki);
        originTextView = findViewById(R.id.detailOrigin);
        dogfriendlyTextView = findViewById(R.id.detailDogFriendly);
        weightTextView = findViewById(R.id.detailWeight);
        lifespanTextView = findViewById(R.id.detailLifespan);
        descriptionTextView = findViewById(R.id.detailDescription);

        Intent intent = getIntent();

        String catID = intent.getStringExtra("id");

        System.out.println(catID);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

//

        String url = "https://api.thecatapi.com/v1/breeds/search?q=" + catID;

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

                Cat[] catMeta = gson.fromJson(response, Cat[].class);

                List<Cat> catsList = Arrays.asList(catMeta);

                ArrayList<Cat> catsArrayList = new ArrayList<Cat>(catsList);

                int latestCat = catsArrayList.size();
                System.out.println("the size of the array is"+latestCat);

                nameTextView.setText(catsArrayList.get(latestCat-1).getName());
                temperamentTextView.setText(catsArrayList.get(latestCat-1).getTemperament());
                wikiTextView.setText(catsArrayList.get(latestCat-1).getWikipedia_url());
                originTextView.setText(catsArrayList.get(latestCat-1).getOrigin());
                //dogfriendlyTextView.setText(catsArrayList.get(0).getDog_friendly());
                weightTextView.setText(catsArrayList.get(latestCat-1).getWeight_imperial());
                lifespanTextView.setText(catsArrayList.get(latestCat-1).getLife_span());
                descriptionTextView.setText(catsArrayList.get(latestCat-1).getDescription());


//            catAdapter.setData(catsArrayList);
//
//            recyclerView.setAdapter(catAdapter);


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
    }
}
