package ru.elsie.april;

import ru.elsie.april.infrastructure.Application;
import ru.elsie.april.infrastructure.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = Application.run("ru.elsie.april", new HashMap<>(Map.of(Assistant.class, AssistantImpl.class)));
        Seller seller = context.getObject(Seller.class);
        seller.serve(new Person());
    }
}
