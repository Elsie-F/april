package ru.elsie.april.infrastructure;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> ifc);
}
