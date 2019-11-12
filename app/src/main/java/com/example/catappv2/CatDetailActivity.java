package com.example.catappv2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
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
    private ImageView detailPhotoImageView;
    private Button addToFavButton;


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
        addToFavButton = findViewById(R.id.favButton);
        detailPhotoImageView = findViewById(R.id.detailPhoto);


        Intent intent = getIntent();

        String catID = intent.getStringExtra("id");

        System.out.println(catID);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String apiKey = "62b8eef7-c68c-4bd6-85bf-ee7ecfcff0c6";
        //String url = "https://api.thecatapi.com/v1/breeds/search?api_key="+ apiKey + "&breed_id="+catID;

        //String url = "https://api.thecatapi.com/v1/breeds/search?api_key=62b8eef7-c68c-4bd6-85bf-ee7ecfcff0c6&breed_id=beng;

        String url = "https://api.thecatapi.com/v1/images/search?api_key="+apiKey+"&breed_id="+catID;
//

        //working because searching directly quotes exact match
        //String url = "https://api.thecatapi.com/v1/breeds/search?q=" + catID;

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();


                CatMeta[] catMeta = gson.fromJson(response, CatMeta[].class);

                List<CatMeta> catsList = Arrays.asList(catMeta);

                ArrayList<CatMeta> catsArrayList = new ArrayList<CatMeta>(catsList);

                CatMeta currentCatMeta = catsArrayList.get(0);

                Cat currentCat = currentCatMeta.getCats().get(0);

                int latestCat = catsArrayList.size();
                System.out.println("the size of the array is "+latestCat);

                System.out.println(currentCat.getName());
                System.out.println(currentCat.getTemperament());

                nameTextView.setText(currentCat.getName());
                temperamentTextView.setText(currentCat.getTemperament());
                wikiTextView.setText(currentCat.getWikipedia_url());
                originTextView.setText(currentCat.getOrigin());
                dogfriendlyTextView.setText(currentCat.getDog_friendly());
                weightTextView.setText(currentCat.getWeight().getMetric());
                lifespanTextView.setText(currentCat.getLife_span());
                descriptionTextView.setText(currentCat.getDescription());




                


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
