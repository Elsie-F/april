package ru.elsie.april;

import ru.elsie.april.infrastructure.InjectByType;

public class Seller {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Assistant assistant;

    public void serve(Person person) {
        announcer.announce("Welcome!");
        assistant.assist();
        sellProduct(person);
        announcer.announce("See you later!");
    }

    private void sellProduct(Person person) {
        System.out.println("Here you are, $1000.");
    }
}
