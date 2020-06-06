package ru.elsie.april;

public class Seller {
    private Announcer announcer = new ConsoleAnnouncer();
    private Assistant assistant = new AssistantImpl();

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
