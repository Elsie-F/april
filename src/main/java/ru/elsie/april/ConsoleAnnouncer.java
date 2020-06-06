package ru.elsie.april;

import ru.elsie.april.infrastructure.ObjectFactory;

public class ConsoleAnnouncer implements Announcer {

    private Advertiser advertiser = ObjectFactory.getInstance().createObject(Advertiser.class);

    @Override
    public void announce(String message) {
            System.out.println(message);
            advertiser.advertise();
    }
}
