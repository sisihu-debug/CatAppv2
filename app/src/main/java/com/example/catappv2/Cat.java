package com.example.catappv2;

public class Cat {

    private String id;
    private String name;
    private String temperament;
    private String wikipedia_url;
    private String origin;
    private String dog_friendly;
    //private String weight_imperial;
    public Weight weight;
    private String life_span;
    //image
    private String description;


    public Cat(String id, String name, String temperament, String wikipedia_url, String origin, String dog_friendly, Weight weight, String life_span, String description) {
        this.id = id;
        this.name = name;
        this.temperament = temperament;
        this.wikipedia_url = wikipedia_url;
        this.origin = origin;
        this.dog_friendly = dog_friendly;
        this.weight = weight;
        this.life_span = life_span;
        this.description = description;
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

    public String getDog_friendly() {
        return dog_friendly;
    }

    public void setDog_friendly(String dog_friendly) {
        this.dog_friendly = dog_friendly;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weightl) {
        this.weight = weight;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public class Weight{
        String metric;

        public Weight(String metric) {
            this.metric = metric;
        }

        public String getMetric() {
            return metric;
        }
    }
}
