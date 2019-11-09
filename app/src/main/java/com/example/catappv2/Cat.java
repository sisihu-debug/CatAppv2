package com.example.catappv2;

public class Cat {

    private String id;
    private String name;
    private String temperament;
    private String wikipedia_url;
    private String origin;
    private int dog_friendly;
    private String weight_imperial;
    private String life_span;
    //image
    //description


    public Cat(String id, String name, String temperament, String wikipedia_url, String origin, int dog_friendly, String weight_imperial, String life_span) {
        this.id = id;
        this.name = name;
        this.temperament = temperament;
        this.wikipedia_url = wikipedia_url;
        this.origin = origin;
        this.dog_friendly = dog_friendly;
        this.weight_imperial = weight_imperial;
        this.life_span = life_span;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public void setWikipedia_url(String wikipedia_url) {
        this.wikipedia_url = wikipedia_url;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getDog_friendly() {
        return dog_friendly;
    }

    public void setDog_friendly(int dog_friendly) {
        this.dog_friendly = dog_friendly;
    }

    public String getWeight_imperial() {
        return weight_imperial;
    }

    public void setWeight_imperial(String weight_imperial) {
        this.weight_imperial = weight_imperial;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }
}
