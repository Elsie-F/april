package ru.elsie.april;

import ru.elsie.april.infrastructure.InjectProperty;
import ru.elsie.april.infrastructure.Singleton;

@Singleton
public class AdvertiserImpl implements Advertiser {
    @InjectProperty(value = "chocolate")
    private String product;

    @Override
    public void advertise() {
        System.out.println("Try our new " + product);
    }
}
