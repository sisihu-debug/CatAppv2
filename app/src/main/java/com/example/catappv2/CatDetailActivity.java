package com.example.catappv2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
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

    Cat currentCat;

    Context context;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_detail);

        context = this;

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

        final String catID = intent.getStringExtra("id");


        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String apiKey = "62b8eef7-c68c-4bd6-85bf-ee7ecfcff0c6";


        String url = "https://api.thecatapi.com/v1/images/search?api_key="+apiKey+"&breed_id="+catID;


        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                Gson gson = new Gson();


                CatMeta[] catMeta = gson.fromJson(response, CatMeta[].class);

                List<CatMeta> catsList = Arrays.asList(catMeta);

                ArrayList<CatMeta> catsArrayList = new ArrayList<CatMeta>(catsList);

                if(catsArrayList.size() ==0){

                    nameTextView.setText("Can't find information");
                    addToFavButton.setVisibility(View.GONE);

                } else{
                    CatMeta currentCatMeta = catsArrayList.get(0);

                    currentCat = currentCatMeta.getCats().get(0);

                    nameTextView.setText(currentCat.getName());
                    Glide.with(context).load(currentCatMeta.getUrl()).into(detailPhotoImageView);
                    temperamentTextView.setText("Temperament: "+ currentCat.getTemperament());
                    wikiTextView.setText("Wikipedia Link: "+ currentCat.getWikipedia_url());
                    originTextView.setText("Origin: "+currentCat.getOrigin());
                    dogfriendlyTextView.setText("Dog Friendliness: "+currentCat.getDog_friendly());
                    weightTextView.setText("Weight: "+ currentCat.getWeight().getMetric());
                    lifespanTextView.setText("Lifespan: "+currentCat.getLife_span());
                    descriptionTextView.setText("Description: "+currentCat.getDescription());


                }

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


        //setting up adding to favourites


        addToFavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                FavCatsDatabase.addToFav( catID ,currentCat);
                Context context = getApplicationContext();
                CharSequence text = "Added to Favourites!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


            }
        });

    }


}
