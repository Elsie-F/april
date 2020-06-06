package ru.elsie.april;

import ru.elsie.april.infrastructure.InjectProperty;

public class AdvertiserImpl implements Advertiser {
    @InjectProperty
    private String product;

    @Override
    public void advertise() {
        System.out.println("Try our new " + product);
    }
}
