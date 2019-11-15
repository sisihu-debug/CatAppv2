package com.example.catappv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FavCatsDatabase {

    public static HashMap<String, Cat> favCats = new HashMap<>();

    public static HashMap<String, Cat> getFavCats (HashMap <String,Cat> favCats){
        return favCats;
    }



    public static void addToFav(String catID, Cat cat){
        if (favCats.containsKey(catID)){
        } else{
            favCats.put(catID, cat);
        }

    }

    public static ArrayList<String> getAllFavs(){



        ArrayList<String> favCatsArrayList = new ArrayList<>();

        Iterator catsIterator = favCats.entrySet().iterator();


        while (catsIterator.hasNext()) {
            Map.Entry<String, Cat> cat = (Map.Entry) catsIterator.next();

            favCatsArrayList.add(cat.getValue().getName());
        }

        return favCatsArrayList;
    }



}
