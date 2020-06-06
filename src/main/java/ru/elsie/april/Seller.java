package ru.elsie.april;

public class Seller {
    public void serve(Person person) {
        System.out.println("Welcome!");
        System.out.println("What are you interested in?");
        sellProduct(person);
        System.out.println("See you later!");
    }

    private void sellProduct(Person person) {
        System.out.println("Here you are, $1000.");
    }
}
