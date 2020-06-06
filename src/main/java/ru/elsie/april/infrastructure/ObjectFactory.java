package ru.elsie.april.infrastructure;

import lombok.SneakyThrows;
import ru.elsie.april.Assistant;
import ru.elsie.april.PushyAssistant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private Config config;

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
         config = new JavaConfig("ru.elsie.april", new HashMap<>(Map.of(Assistant.class, PushyAssistant.class)));
        for (Class<? extends ObjectConfigurator> aClass : config.getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = type;
        if (implClass.isInterface()) {
            implClass = config.getImplClass(implClass);
        }

        T t = implClass.getDeclaredConstructor().newInstance();

        configurators.forEach(configurator -> configurator.configure(t));

        return t;
    }
}
