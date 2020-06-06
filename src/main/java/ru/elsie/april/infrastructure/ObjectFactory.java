package ru.elsie.april.infrastructure;

import lombok.SneakyThrows;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig("ru.elsie.april");

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
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
