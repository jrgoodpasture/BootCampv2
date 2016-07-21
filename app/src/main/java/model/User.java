package model;

/**
 * Created by Jacob on 7/22/2016.
 */
public class User {
    //declaring variables
    public String name;
    public double rating;
    public int age;
    public boolean isTrainer;

    //constructor
    public User(String name, double rating, int age, boolean isTrainer) {
        this.name = name;
        this.rating = rating;
        this.age = age;
        this.isTrainer = isTrainer;
    }


}
