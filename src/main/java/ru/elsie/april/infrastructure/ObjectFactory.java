package ru.elsie.april.infrastructure;

import lombok.SneakyThrows;
import ru.elsie.april.Assistant;
import ru.elsie.april.PushyAssistant;

import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config;

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
         config = new JavaConfig("ru.elsie.april", new HashMap<>(Map.of(Assistant.class, PushyAssistant.class)));
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = type;
        if (implClass.isInterface()) {
            implClass = config.getImplClass(implClass);
        }

        return implClass.getDeclaredConstructor().newInstance();
    }
}
