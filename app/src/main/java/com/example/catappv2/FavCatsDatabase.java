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

    public static Cat value;

    public static void addToFav(String catID, Cat cat){
        if (favCats.containsKey(catID)){
            System.out.println("already added!!!");
        } else{
            favCats.put(catID, cat);
            System.out.println("Now i've been added");

        }

    }

    public static ArrayList<String> getAllFavs(){



        ArrayList<String> favCatsArrayList = new ArrayList<>();

        Iterator catsIterator = favCats.entrySet().iterator();



//        while (catsIterator.hasNext()) {
//            Map.Entry<String, Cat> cat = (Map.Entry) catsIterator.next();
//
//            System.out.println(favCats.size());
//
//            favCatsArrayList.add(cat.getValue().getName());
//
//            //Cat displaycat = Cat.class. cat.getKey()
//
//        }

        //Map<String, Object> catMap = new HashMap<>();

        for (Map.Entry<String, Cat> entry : favCats.entrySet()) {
            String key = entry.getKey();
            System.out.println(key);
            value = entry.getValue();

            System.out.println(value.getName());

            //favCatsArrayList.add(value.getName());



        }


        return favCatsArrayList;
    }



}
