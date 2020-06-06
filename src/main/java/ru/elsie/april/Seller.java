package ru.elsie.april;

import ru.elsie.april.infrastructure.ObjectFactory;

public class Seller {
    private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    private Assistant assistant = ObjectFactory.getInstance().createObject(Assistant.class);

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
