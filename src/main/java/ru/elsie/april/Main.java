package ru.elsie.april;

import ru.elsie.april.infrastructure.ObjectFactory;

public class Main {
    public static void main(String[] args) {
        Seller seller = ObjectFactory.getInstance().createObject(Seller.class);
        seller.serve(new Person());
    }
}
