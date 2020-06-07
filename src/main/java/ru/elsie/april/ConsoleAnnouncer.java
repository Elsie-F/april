package ru.elsie.april;

import ru.elsie.april.infrastructure.InjectByType;

public class ConsoleAnnouncer implements Announcer {
    @InjectByType
    private Advertiser advertiser;

    @Override
    public void announce(String message) {
            System.out.println(message);
            advertiser.advertise();
    }
}
