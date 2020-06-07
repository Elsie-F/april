package ru.elsie.april.infrastructure;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {
    private final ApplicationContext context;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
        this.context = context;
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {

        T t = implClass.getDeclaredConstructor().newInstance();

        configurators.forEach(configurator -> configurator.configure(t, context));

        return t;
    }
}
